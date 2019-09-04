/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaBancariaPersistance;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Estudiante
 */
@RunWith(Arquillian.class)
public class CuentaBancariaLogicTest {

    @PersistenceContext
    private EntityManager em;

    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private CuentaBancariaLogic cuentaBancariaLogic;

    private List<CuentaBancariaEntity> data = new ArrayList<CuentaBancariaEntity>();

    @Deployment
    public static JavaArchive createDeploytment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaBancariaEntity.class.getPackage())
                .addPackage(CuentaBancariaLogic.class.getPackage())
                .addPackage(CuentaBancariaPersistance.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Prueba para crear una cuenta bancaria.
     *
     */
    @Test
    public void createCuentaBancariaTest() throws BusinessLogicException {
        CuentaBancariaEntity newEntity = factory.manufacturePojo(CuentaBancariaEntity.class);
        CuentaBancariaEntity result = cuentaBancariaLogic.createCuentaBancaria(newEntity);
        Assert.assertNotNull(result);
        
        CuentaBancariaEntity entity = em.find(CuentaBancariaEntity.class, result.getId());

        Assert.assertEquals(newEntity.getNumeroCuenta(), entity.getNumeroCuenta());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());

    }
    @Test (expected = BusinessLogicException.class)
    public void createCuentaBancariaNombreNull() throws BusinessLogicException
    {
        CuentaBancariaEntity newEntity = factory.manufacturePojo(CuentaBancariaEntity.class);
        newEntity.setNumeroCuenta(0);
        CuentaBancariaEntity result = cuentaBancariaLogic.createCuentaBancaria(newEntity);
    }
}

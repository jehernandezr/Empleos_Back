/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.persistence.CuentaDeCobroPersistence;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
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
 * @author Santiago Tangarife
 */
@RunWith(Arquillian.class)
public class CuentaDeCobroPersistenceTest {
    
    @Inject
    private CuentaDeCobroPersistence persistance;
    
    @PersistenceContext
    private EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class).addPackage(CuentaDeCobroEntity.class.getPackage())
                .addPackage(CuentaDeCobroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml","persistence.xml")
                .addAsManifestResource("META-INF/beans.xml","beans.xml");
    }
    
    @Test
    public void createCuentaDeCobroEntity()
    {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaDeCobroEntity cuenta = factory.manufacturePojo(CuentaDeCobroEntity.class);
        
        CuentaDeCobroEntity cu= persistance.create(cuenta);
        
        Assert.assertNotNull(cu);
        
        CuentaDeCobroEntity entity= em.find(CuentaDeCobroEntity.class, cu.getId());
        
        Assert.assertEquals(entity.getNumeroCuentaDeCobro(), cu.getNumeroCuentaDeCobro());
        
    }
}

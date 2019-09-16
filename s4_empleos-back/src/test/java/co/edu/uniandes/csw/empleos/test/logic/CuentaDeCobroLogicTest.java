/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.ejb.CuentaDeCobroLogic;
import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaDeCobroPersistence;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 *
 * @author Santiago Tangarife Rincón
 */
@RunWith(Arquillian.class)
public class CuentaDeCobroLogicTest {

    @Inject
    private CuentaDeCobroLogic logic;

    private PodamFactory factory = new PodamFactoryImpl();

    @PersistenceContext
    private EntityManager em;

    @Inject
    private UserTransaction utx;

    private List<CuentaDeCobroEntity> cuentas = new ArrayList();

    private List<CuentaDeCobroEntity> data = new ArrayList<CuentaDeCobroEntity>();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaDeCobroEntity.class.getPackage())
                .addPackage(CuentaDeCobroLogic.class.getPackage())
                .addPackage(CuentaDeCobroPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from BookEntity").executeUpdate();
        em.createQuery("delete from EditorialEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        for (int i = 0; i < 3; i++) {
            CuentaDeCobroEntity cuenta = factory.manufacturePojo(CuentaDeCobroEntity.class);
            em.persist(cuenta);
            cuentas.add(cuenta);
        }
    }

    /**
     * Prueba crear una cuenta de cobro.
     *
     * @throws BusinessLogicException
     */
    @Test
    public void createCuentaDeCobroTest() throws BusinessLogicException {
        CuentaDeCobroEntity newEntity = factory.manufacturePojo(CuentaDeCobroEntity.class);
        newEntity.setValor(1);
        CuentaDeCobroEntity result = logic.createCuentaDeCobro(newEntity);
        Assert.assertNotNull(result);
        CuentaDeCobroEntity entity = em.find(CuentaDeCobroEntity.class, result.getId());
        Assert.assertEquals(newEntity.getId(), entity.getId());
        Assert.assertEquals(newEntity.getConcepto(), entity.getConcepto());
        Assert.assertEquals(newEntity.getContratista(), entity.getContratista());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());
        Assert.assertEquals(newEntity.getNombreEstudiante(), entity.getNombreEstudiante());
        Assert.assertEquals(newEntity.getNumeroCuentaDeCobro(), entity.getNumeroCuentaDeCobro());
        Assert.assertEquals(newEntity.getValor(), entity.getValor());
    }

    @Test(expected = BusinessLogicException.class)
    public void createCuentaDeCobroError() throws BusinessLogicException {
        logic.createCuentaDeCobro(null);//crea una cuenta nula
        CuentaDeCobroEntity entity = factory.manufacturePojo(CuentaDeCobroEntity.class);
        entity.setConcepto(null);
        entity.setContratista(null);
        entity.setFecha(null);
        entity.setNombreEstudiante(null);
        entity.setNumeroCuentaDeCobro(-1);
        entity.setValor(-1);
        logic.createCuentaDeCobro(entity);//Crea una cuenta con valores nulos e incorrectos
        entity.setConcepto("");
        entity.setContratista("");
        entity.setNombreEstudiante("");
        logic.createCuentaDeCobro(entity);//crea una cuenta con cadenas de texto vacias
    }
}

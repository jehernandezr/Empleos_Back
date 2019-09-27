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
        newEntity.setValor(8);
        //Comprueba que la cuenta de cobro creada por podam no sea nula ni sus atributos
        Assert.assertNotNull(newEntity);
        Assert.assertNotNull(newEntity.getConcepto());
        Assert.assertNotNull(newEntity.getContratista());
        Assert.assertNotNull(newEntity.getFecha());
        Assert.assertNotNull(newEntity.getNombreEstudiante());
        Assert.assertNotNull(newEntity.getNumeroCuentaDeCobro());
        Assert.assertNotNull(newEntity.getValor());
        //Comprueba que los atributos de la cuenta de cobro creada por podam no sean invalidos
        Assert.assertFalse("La cuenta de cobro creada tiene un contratista invalido", newEntity.getContratista().equals(" ")||newEntity.getContratista()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un concepto invalido", newEntity.getConcepto().equals(" ")||newEntity.getConcepto()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene una fecha invalida", newEntity.getFecha()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un nombre de estudiante invalido", newEntity.getNombreEstudiante().equals(" ")||newEntity.getNombreEstudiante()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un número invalido", newEntity.getNumeroCuentaDeCobro()<=0);
        Assert.assertFalse("La cuenta de cobro creada tiene un valor invalido", newEntity.getValor()<=0);
       
        CuentaDeCobroEntity result = logic.createCuentaDeCobro(newEntity);
        //Comprueba que la cuenta de cobro retornada del create no sea nula ni sus atributos
        Assert.assertNotNull(result);
        Assert.assertNotNull(result.getConcepto());
        Assert.assertNotNull(result.getContratista());
        Assert.assertNotNull(result.getFecha());
        Assert.assertNotNull(result.getNombreEstudiante());
        Assert.assertNotNull(result.getNumeroCuentaDeCobro());
        Assert.assertNotNull(result.getValor());
        //Comprueba que los atributos de la cuenta de cobro retornada del create no sean invalidos
        Assert.assertFalse("La cuenta de cobro creada tiene un contratista invalido", result.getContratista().equals(" ")||result.getContratista()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un concepto invalido", result.getConcepto().equals(" ")||result.getConcepto()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene una fecha invalida", result.getFecha()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un nombre de estudiante invalido", result.getNombreEstudiante().equals(" ")||result.getNombreEstudiante()==null);
        Assert.assertFalse("La cuenta de cobro creada tiene un número invalido", result.getNumeroCuentaDeCobro()<=0);
        Assert.assertFalse("La cuenta de cobro creada tiene un valor invalido", result.getValor()<=0);
        
        CuentaDeCobroEntity entity = em.find(CuentaDeCobroEntity.class, result.getId());
        //Comprueba que los valores sean iguales despues de crearla
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
        entity.setNombreEstudiante("");
        logic.createCuentaDeCobro(entity);//crea una cuenta con cadenas de texto vacias
    }
}

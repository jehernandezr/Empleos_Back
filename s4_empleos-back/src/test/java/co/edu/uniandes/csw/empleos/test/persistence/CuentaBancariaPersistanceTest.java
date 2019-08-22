/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.CuentaBancaria;
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
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

/**
 * Pruebas de persistencia de Cuentas
 *
 * @author Estudiante
 */
@RunWith(Arquillian.class)
public class CuentaBancariaPersistanceTest {

    @Inject
    private CuentaBancariaPersistance cuentaBancariaPersistance;

    @PersistenceContext
    private EntityManager em;

    @Inject
    UserTransaction utx;

    private List<CuentaBancaria> data = new ArrayList<CuentaBancaria>();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CuentaBancaria.class.getPackage())
                .addPackage(CuentaBancariaPersistance.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }

    @Test
    public void createTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaBancaria entity = factory.manufacturePojo(CuentaBancaria.class);
        CuentaBancaria result = cuentaBancariaPersistance.create(entity);
        Assert.assertNotNull(result);

        CuentaBancaria foundEntity = em.find(CuentaBancaria.class, result.getId());
        Assert.assertEquals(entity.getNumeroCuenta(), foundEntity.getNumeroCuenta());
    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            em.joinTransaction();
            clearData();
            insertData();
            utx.commit();

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from CuentaBancaria").executeUpdate();
       
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {
        PodamFactory factory = new PodamFactoryImpl();
        for (int i = 0; i < 3; i++) {
            CuentaBancaria entity = factory.manufacturePojo(CuentaBancaria.class);
            em.persist(entity);
            data.add(entity);
        }
    }

    /**
     * Prueba para crear una cuenta bancaria.
     *
     */
    @Test
    public void createCuentaBancariaTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CuentaBancaria newEntity = factory.manufacturePojo(CuentaBancaria.class);

        CuentaBancaria result = cuentaBancariaPersistance.create(newEntity);

        Assert.assertNotNull(result);

        CuentaBancaria entity = em.find(CuentaBancaria.class, result.getId());

        Assert.assertEquals(newEntity.getNumeroCuenta(), entity.getNumeroCuenta());
        Assert.assertEquals(newEntity.getFecha(), entity.getFecha());

    }

    /**
     * Prueba para consultar la lista de premios.
     */
    @Test
    public void getCuentaBancariasTest() {
        List<CuentaBancaria> list = cuentaBancariaPersistance.findAll();
        Assert.assertEquals(data.size(), list.size());
        for (CuentaBancaria ent : list) {
            boolean found = false;
            for (CuentaBancaria entity : data) {
                if (ent.getId().equals(entity.getId())) {
                    found = true;
                }
            }
            Assert.assertTrue(found);
        }
    }

    /**
     * Prueba para consultar un Prize.
     */
    @Test
    public void getCuentaBancariaTest() {
        CuentaBancaria entity = data.get(0);
        CuentaBancaria newEntity = cuentaBancariaPersistance.find(entity.getId());
        Assert.assertNotNull(newEntity);
        Assert.assertEquals(entity.getFecha(), newEntity.getFecha());
        Assert.assertEquals(entity.getNumeroCuenta(), newEntity.getNumeroCuenta());
    }

    /**
     * Prueba para eliminar un Prize.
     */
    @Test
    public void deleteCuentaBancariaTest() {
        CuentaBancaria entity = data.get(0);
        cuentaBancariaPersistance.delete(entity.getId());
        CuentaBancaria deleted = em.find(CuentaBancaria.class, entity.getId());
        Assert.assertNull(deleted);
    }

    /**
     * Prueba para actualizar un Prize.
     */
    @Test
    public void updateCuentaBancariaTest() {
        CuentaBancaria entity = data.get(0);
        PodamFactory factory = new PodamFactoryImpl();
        CuentaBancaria newEntity = factory.manufacturePojo(CuentaBancaria.class);

        newEntity.setId(entity.getId());

        cuentaBancariaPersistance.update(newEntity);

        CuentaBancaria resp = em.find(CuentaBancaria.class, entity.getId());

        Assert.assertEquals(newEntity.getNumeroCuenta(), resp.getNumeroCuenta());
        Assert.assertEquals(newEntity.getFecha(), resp.getFecha());

    }

}

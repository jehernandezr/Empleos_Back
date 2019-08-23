/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.FacturaEntity;
import co.edu.uniandes.csw.empleos.persistence.FacturaPersistence;
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
 * Clase que prueba los metodos CRUD implementados en la clase FacturaPersistence
 * @author n.munar
 */
@RunWith(Arquillian.class)
public class FacturaPersistenceTest {
    
    @PersistenceContext(unitName = "empleosPU")
    protected EntityManager em;
    
    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(FacturaEntity.class)
                .addClass(FacturaPersistence.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    FacturaPersistence fp;
    
    /**
     * Prueba para crear una Calificacion.
     */
    @Test
    public void createCalificacionTest() {
        PodamFactory factory = new PodamFactoryImpl();
        FacturaEntity factura = factory.manufacturePojo(FacturaEntity.class);
       FacturaEntity result = fp.create(factura);

        Assert.assertNotNull(result);

        FacturaEntity entity = em.find(FacturaEntity.class, result.getId());

       /**
        * Prueba para crear la fecha y encontrarlo
        */
        Assert.assertEquals(factura.getFecha(), entity.getFecha());
        
        /**
         * Pueba para crear el valor y enrlacontrarlo
         */
        Assert.assertEquals(factura.getValor(), entity.getValor());
    
    }
}

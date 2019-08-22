/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.persistence.CalificacionPersistence;
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
 *Clase de los test de que corresponden a las pruebas realizadas sobre los metodos de la Clase CalificacionPersistnence
 * @author Estudiante
 */
@RunWith(Arquillian.class)
public class CalificacionPersistenceTest {
    
       
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
                .addClass(CalificacionEntity.class)
                .addClass(CalificacionPersistence.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    CalificacionPersistence cp;
    
    
    /**
     * Prueba para crear una Calificacion.
     */
    @Test
    public void createCalificacionTest() {
        PodamFactory factory = new PodamFactoryImpl();
        CalificacionEntity calificacion = factory.manufacturePojo(CalificacionEntity.class);
        CalificacionEntity result = cp.create(calificacion);

        Assert.assertNotNull(result);

        CalificacionEntity entity = em.find(CalificacionEntity.class, result.getId());

       /**
        * Prueba para crear el comentario y encontrarlo
        */
        Assert.assertEquals(calificacion.getComentario(), entity.getComentario());
        
        /**
         * Pueba para crear la nota y enrlacontrarla
         */
        Assert.assertEquals(calificacion.getNota(), entity.getNota());
 
    }
    
    
}

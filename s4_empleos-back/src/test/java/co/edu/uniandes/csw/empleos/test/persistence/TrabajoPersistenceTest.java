package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import co.edu.uniandes.csw.empleos.persistence.TrabajoPersistence;
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
 *  Test de persistencia de la clase estudiante
 * @author David Dominguez
 */
@RunWith(Arquillian.class)
public class TrabajoPersistenceTest {
    
    // Se relaciona la base de datos con el entitymanager
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    // Se relaciona Arquilliean con las clases que se pobrarán
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(TrabajoEntity.class)
                .addClass(TrabajoPersistence.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    // Atributo que representa al objeto encargado de manejar la persistencia de Estudiante
    @Inject
    TrabajoPersistence tp;
    
    // Se prueba que se cree y guarde exitosamente el trabajo
    @Test
    public void crearTrabajoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TrabajoEntity trabajo = factory.manufacturePojo(TrabajoEntity.class);
        TrabajoEntity result = tp.create(trabajo);
        
        Assert.assertNotNull(result);
        
        TrabajoEntity t = em.find(TrabajoEntity.class, result.getId());
        Assert.assertEquals(t.getId(), result.getId());
    }
    
    // Se prueba que se cree y guarde exitosamente el atributo verificado de un trabajo
    @Test
    public void verificarTest() {
        PodamFactory factory = new PodamFactoryImpl();
        TrabajoEntity trabajo = factory.manufacturePojo(TrabajoEntity.class);
        TrabajoEntity result = tp.create(trabajo);
        
        Assert.assertNotNull(result);
        
        TrabajoEntity t = em.find(TrabajoEntity.class, result.getId());
        Assert.assertEquals(t.isVerificado(), result.isVerificado());
    }

    // Se prueba que se cree y guarde exitosamente el atributo cumplido de un trabajo
    @Test
    public void cumplidoTest () {
        PodamFactory factory = new PodamFactoryImpl();
        TrabajoEntity trabajo = factory.manufacturePojo(TrabajoEntity.class);
        TrabajoEntity result = tp.create(trabajo);
        
        Assert.assertNotNull(result);
        
        TrabajoEntity t = em.find(TrabajoEntity.class, result.getId());
        Assert.assertEquals(t.isCumplido(), result.isCumplido());
    }
    
}

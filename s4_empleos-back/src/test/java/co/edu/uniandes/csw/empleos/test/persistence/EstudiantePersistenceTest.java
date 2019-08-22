package co.edu.uniandes.csw.empleos.test.persistence;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.persistence.EstudiantePersistence;
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
 * @author David Dominguez
 */
@RunWith(Arquillian.class)
public class EstudiantePersistenceTest {
    
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(EstudianteEntity.class)
                .addClass(EstudiantePersistence.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    @Inject
    EstudiantePersistence ep;
    
    
    @Test
    public void crearEstudianteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getNombre(), result.getNombre());
        
    }
    
    @Test
    public void testTest2() {
        Assert.assertEquals("h", "h");
    }
}

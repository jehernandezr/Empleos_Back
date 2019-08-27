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
 * Test de persistencia de la clase estudiante
 * @author David Dominguez
 */
@RunWith(Arquillian.class)
public class EstudiantePersistenceTest {
    
    // Se relaciona la base de datos con el entitymanager
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    // Se relaciona Arquilliean con las clases que se pobrarán
    @Deployment
    public static JavaArchive createDeployment() {
        return ShrinkWrap.create(JavaArchive.class)
                .addClass(EstudianteEntity.class)
                .addClass(EstudiantePersistence.class)
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    // Atributo que representa al objeto encargado de manejar la persistencia de Estudiante
    @Inject
    EstudiantePersistence ep;
    
    // Se prueba que se cree y guarde exitosamente el estudiante
    @Test
    public void crearEstudianteTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getId(), result.getId());
        
    }
    
    // Se prueba que el nombre de un estudiante quede correctamente guardado
    @Test
    public void nombreTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getNombre(), result.getNombre());
    }
    
    // Se prueba que el id del medio de pago de un estudiante quede correctamente guardado
    @Test
    public void idMedioDePagoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getIdMedioDepago(), result.getIdMedioDepago());
    }
    
    // Se prueba que la carrera de un estudiante quede correctamente guardado
    @Test
    public void carreraTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getCarrera(), result.getCarrera());
    }
    
    // Se prueba que el correo de un estudiante quede correctamente guardado
    @Test
    public void correoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getCorreo(), result.getCorreo());
    }
    
    // Se prueba que la calificación promedio de un estudiante quede correctamente guardado
    @Test
    public void calificacionPromedioTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getCalificacionPromedio(), result.getCalificacionPromedio(), 0.000001);
    }
    
    // Se prueba que el horario de trabajo de un estudiante quede correctamente guardado
    @Test
    public void horarioDeTrabajoTest() {
        PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getNombre(), result.getNombre());
    }
    
    // Se prueba que el semestre que cursa de un estudiante quede correctamente guardado
    @Test
    public void semestreTest() {
       PodamFactory factory = new PodamFactoryImpl();
        EstudianteEntity estudiante = factory.manufacturePojo(EstudianteEntity.class);
        EstudianteEntity result = ep.create(estudiante);
        Assert.assertNotNull(result);
        
        EstudianteEntity e = em.find(EstudianteEntity.class, result.getId());
        Assert.assertEquals(e.getNombre(), result.getNombre());
    }
}

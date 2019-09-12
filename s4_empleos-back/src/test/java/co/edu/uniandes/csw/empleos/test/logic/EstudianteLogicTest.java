package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.logic.EstudianteLogic;
import co.edu.uniandes.csw.empleos.persistence.EstudiantePersistence;
import java.util.ArrayList;
import java.util.List;
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
public class EstudianteLogicTest {
    
    @Inject
    private EstudianteLogic estudianteLogic;
   
    @PersistenceContext
    private EntityManager em;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    private List<EstudianteEntity> datos = new ArrayList<EstudianteEntity>();
    
    @Deployment
    private static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EstudianteEntity.class.getPackage())
                .addPackage(EstudianteLogic.class.getPackage())
                .addPackage(EstudiantePersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * Se verifica que se haya creado correctamente un estudiante.
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test
    public void crearEstudiante()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);  
      newEntity.setCorreo("algo@uniandes.edu.co");
      newEntity.setSemestre(2);
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
      Assert.assertNotNull(result);
      EstudianteEntity entity = em.find(EstudianteEntity.class,result.getId());
      Assert.assertEquals(entity.getNombre(),result.getNombre());
      Assert.assertEquals(entity.getSemestre(),result.getSemestre());
      Assert.assertEquals(entity.getIdMedioDepago(),result.getIdMedioDepago());
      Assert.assertEquals(entity.getHorarioDeTrabajo(),result.getHorarioDeTrabajo());
      Assert.assertEquals(entity.getCorreo(),result.getCorreo());
      Assert.assertEquals(entity.getCarrera(),result.getCarrera());
      Assert.assertEquals(entity.getCalificacionPromedio(),result.getCalificacionPromedio(), 0.0001);
    }
         
    /**
     * Se crea un estudiante con una carrera vacía
     * @throws BusinessLogicException 
     */
    @Test(expected = BusinessLogicException.class)
    public void crearEstudianteCarreraVacia()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setCarrera("");
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con una calificacion promedio mayor a cero
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearCalificacionPromedioMenorCero()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setCalificacionPromedio(-1);
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con una calificacion promedio menor o igual a cinco
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearCalificacionPromedioMayorCinco()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setCalificacionPromedio(6);
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un correo no uniandino
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearCorreoNoUniandes()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setCorreo("akwjdand@gmail.com");
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un correo vacío
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearCorreoVacio()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setCorreo("");
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un horario de trabajo vacío
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearHorarioDeTrabajoVacio()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setHorarioDeTrabajo("");
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un nombre vacío
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearNombreVacio()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setNombre("");
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un semestre mayor a 12
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearSemestreMayor12()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setSemestre(13);
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
    
    /**
     * Se crea un estudiante con un semestre menos a 1
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void crearSemestreMenor1()throws BusinessLogicException{
      EstudianteEntity newEntity = factory.manufacturePojo(EstudianteEntity.class);
      newEntity.setSemestre(0);
      EstudianteEntity result = estudianteLogic.crearEstudiante(newEntity);
    }
}

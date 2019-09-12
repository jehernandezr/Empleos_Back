package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.logic.TrabajoLogic;
import co.edu.uniandes.csw.empleos.persistence.TrabajoPersistence;
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
public class TrabajoLogicTest {
    
    @Inject
    private TrabajoLogic trabajoLogic;
   
    @PersistenceContext
    private EntityManager em;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    private List<TrabajoEntity> datos = new ArrayList<TrabajoEntity>();
    
    @Deployment
    private static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(TrabajoEntity.class.getPackage())
                .addPackage(TrabajoLogic.class.getPackage())
                .addPackage(TrabajoPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
     /**
     * Se verifica que se haya creado correctamente un trabajo.
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test
    public void crearTrabajo()throws BusinessLogicException{
      TrabajoEntity newEntity = factory.manufacturePojo(TrabajoEntity.class);  
      TrabajoEntity result = trabajoLogic.crearTrabajo(newEntity);
      Assert.assertNotNull(result);
      TrabajoEntity entity = em.find(TrabajoEntity.class, result.getId());
      Assert.assertEquals(entity.isVerificado(), result.isVerificado());
      Assert.assertEquals(entity.isCumplido(), result.isCumplido());
    }
         
   //Esta clase no tiene reglas de negocio
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.logic.CalificacionLogic;
import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CalificacionPersistence;
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
 * @author Nicolas Munar
 */
@RunWith(Arquillian.class)
public class CalificacionLogicTest {
    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private CalificacionLogic calificacionLogic;
    
    private PodamFactory factory =  new PodamFactoryImpl();
    
    private List<CalificacionEntity> data = new ArrayList<CalificacionEntity>();
    
    @Deployment
    private static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(CalificacionEntity.class.getPackage())
                .addPackage(CalificacionLogic.class.getPackage())
                .addPackage(CalificacionPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
    }
    
    /**
     * Se verifica que se haya creado correctamente una calificacion.
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test
    public void createCalificacion()throws BusinessLogicException{
      CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);  
      CalificacionEntity result = calificacionLogic.createCalificacion(newEntity);
      Assert.assertNotNull(result);
      
      CalificacionEntity entity = em.find(CalificacionEntity.class,result.getId());
      Assert.assertEquals(entity.getNota(),result.getNota());
      Assert.assertEquals(entity.getComentario(),result.getComentario());
    }
   
    /**
     * Se crea una calificacion con una nota menor a 0
     * @throws BusinessLogicException 
     */
    @Test(expected = BusinessLogicException.class)
    public void createCalificacionNotaNoMenoraCero()throws BusinessLogicException{
        
      CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
      newEntity.setNota(-1.0);
      CalificacionEntity result = calificacionLogic.createCalificacion(newEntity);
    }
    
    /**
     * Se crea una calificacion con un Comentario no nulo
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void createCalificacionComentarioNotNull()throws BusinessLogicException{
        
      CalificacionEntity newEntity = factory.manufacturePojo(CalificacionEntity.class);
      newEntity.setComentario(null);
      CalificacionEntity result = calificacionLogic.createCalificacion(newEntity);
    }
    
}

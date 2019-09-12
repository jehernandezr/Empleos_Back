/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.ejb.FacturaLogic;
import co.edu.uniandes.csw.empleos.entities.FacturaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.FacturaPersistence;
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
public class FacturaLogicTest {
    
    @Inject
    private FacturaLogic facturaLogic;
   
    @PersistenceContext
    private EntityManager em;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    private List<FacturaEntity> data = new ArrayList<FacturaEntity>();
    
    @Deployment
    private static JavaArchive createDeployment()
    {
        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(FacturaEntity.class.getPackage())
                .addPackage(FacturaLogic.class.getPackage())
                .addPackage(FacturaPersistence.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");
                
    }
    
     /**
     * Se verifica que se haya creado correctamente una factura.
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test
    public void createCalificacion()throws BusinessLogicException{
      FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);  
      FacturaEntity result = facturaLogic.createFactura(newEntity);
      Assert.assertNotNull(result);
      
      FacturaEntity entity = em.find(FacturaEntity.class,result.getId());
      Assert.assertEquals(entity.getValor(),result.getValor());
      Assert.assertEquals(entity.getFecha(),result.getFecha());
    }
         
    /**
     * Se crea una factura con un valor menor a 0
     * @throws BusinessLogicException 
     */
    @Test(expected = BusinessLogicException.class)
    public void createCalificacionValorNoMenoraCero()throws BusinessLogicException{
        
      FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
      newEntity.setValor(-1);
      FacturaEntity result = facturaLogic.createFactura(newEntity);
    }
    
    /**
     * Se crea una factura con una fecha no nula
     * @throws BusinessLogicException Excepcion untilizada para representar errores en la lógica del negocio.
     */
    @Test(expected = BusinessLogicException.class)
    public void createCalificacionFechaNotNull()throws BusinessLogicException{
        
      FacturaEntity newEntity = factory.manufacturePojo(FacturaEntity.class);
      newEntity.setFecha(null);
      FacturaEntity result = facturaLogic.createFactura(newEntity);
    }
    
}

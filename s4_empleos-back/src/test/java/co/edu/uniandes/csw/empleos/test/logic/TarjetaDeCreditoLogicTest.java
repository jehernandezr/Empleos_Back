/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.ejb.TarjetaDeCreditoLogic;
import co.edu.uniandes.csw.empleos.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.TarjetaDeCreditoPersistence;
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
 * @author Miguel Angel Ramos Hurtado
 */
@RunWith(Arquillian.class)
public class TarjetaDeCreditoLogicTest {
    
    
    @PersistenceContext
   private EntityManager em;
    
    private PodamFactory factory = new PodamFactoryImpl();
    
    @Inject
    private TarjetaDeCreditoLogic tarjetaCreditoLogic;
    
    /**
    * @return Devuelve el jar Arquillian va a desplegar en Payara embebido.
    */
   @Deployment
   public static JavaArchive createDeployment()
   {
       return ShrinkWrap.create(JavaArchive.class)
               .addPackage(TarjetaDeCreditoEntity.class.getPackage())
               .addPackage(TarjetaDeCreditoLogic.class.getPackage())
               .addPackage(TarjetaDeCreditoPersistence.class.getPackage())
               .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
               .addAsManifestResource("META-INF/beans.xml", "beans.xml");
   }
   
   @Test
   public void createTarjetaDeCredito() throws BusinessLogicException {
       TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
       TarjetaDeCreditoEntity result = tarjetaCreditoLogic.createTarjetaDeCredito(newEntity);
       Assert.assertNotNull(result);
       
       TarjetaDeCreditoEntity entity = em.find(TarjetaDeCreditoEntity.class, result.getId());
       Assert.assertEquals(entity.getNumero(), result.getNumero());
               
   }
   
   @Test (expected = BusinessLogicException.class )
   public void createTarjetaDeCreditoNumeroNull () throws BusinessLogicException {
       TarjetaDeCreditoEntity newEntity = factory.manufacturePojo(TarjetaDeCreditoEntity.class);
       newEntity.setNumero(null);
       TarjetaDeCreditoEntity result = tarjetaCreditoLogic.createTarjetaDeCredito(newEntity); 
   }
   
}

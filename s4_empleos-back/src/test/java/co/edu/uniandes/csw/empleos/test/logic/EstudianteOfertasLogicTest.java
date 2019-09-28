/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.test.logic;

import co.edu.uniandes.csw.empleos.ejb.EstudianteOfertasLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteLogic;
import co.edu.uniandes.csw.empleos.ejb.OfertaLogic;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.EstudiantePersistence;
import co.edu.uniandes.csw.empleos.persistence.OfertaPersistence;
import java.util.ArrayList;
import java.util.List;
import javax.inject.Inject;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.UserTransaction;
import org.jboss.arquillian.container.test.api.Deployment;
import org.jboss.arquillian.junit.Arquillian;
import org.jboss.shrinkwrap.api.ShrinkWrap;
import org.jboss.shrinkwrap.api.spec.JavaArchive;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;


/**
 *
 * @author David Dominguez
 */
@RunWith(Arquillian.class)
public class EstudianteOfertasLogicTest {
    
    private PodamFactory factory = new PodamFactoryImpl();

    @Inject
    private EstudianteLogic estudianteLogic;
    @Inject
    private OfertaLogic ofertaLogic;

    @Inject
    private EstudianteOfertasLogic estudianteOfertasLogic;

    @PersistenceContext
    private EntityManager em;
    
    @Inject
    private UserTransaction utx;

    private List<EstudianteEntity> caldata = new ArrayList<EstudianteEntity>();
    private List<OfertaEntity> data = new ArrayList<OfertaEntity>();

    /**
     * @return Devuelve el jar que Arquillian va a desplegar en Payara embebido.
     * El jar contiene las clases, el descriptor de la base de datos y el
     * archivo beans.xml para resolver la inyección de dependencias.
     */
    @Deployment
    public static JavaArchive createDeployment() {

        return ShrinkWrap.create(JavaArchive.class)
                .addPackage(EstudianteEntity.class.getPackage())
                .addPackage(EstudianteLogic.class.getPackage())
                .addPackage(EstudiantePersistence.class.getPackage())
                .addPackage(OfertaEntity.class.getPackage())
                .addPackage(OfertaPersistence.class.getPackage())
                .addPackage(OfertaLogic.class.getPackage())
                .addPackage(EstudianteOfertasLogic.class.getPackage())
                .addAsManifestResource("META-INF/persistence.xml", "persistence.xml")
                .addAsManifestResource("META-INF/beans.xml", "beans.xml");

    }

    /**
     * Configuración inicial de la prueba.
     */
    @Before
    public void configTest() {
        try {
            utx.begin();
            clearData();
            insertData();
            utx.commit();
        } catch (Exception e) {
            e.printStackTrace();
            try {
                utx.rollback();
            } catch (Exception e1) {
                e1.printStackTrace();
            }
        }
    }

    /**
     * Limpia las tablas que están implicadas en la prueba.
     */
    private void clearData() {
        em.createQuery("delete from EstudianteEntity").executeUpdate();
        em.createQuery("delete from OfertaEntity").executeUpdate();
    }

    /**
     * Inserta los datos iniciales para el correcto funcionamiento de las
     * pruebas.
     */
    private void insertData() {


        for (int i = 0; i < 3; i++) {
            OfertaEntity entity = factory.manufacturePojo(OfertaEntity.class);
            em.persist(entity);
            data.add(entity);
        }
        caldata.get(0).setOfertas(data);
        
         for (int i = 0; i < 3; i++) {
            EstudianteEntity est = factory.manufacturePojo(EstudianteEntity.class);
            em.persist(est);
            caldata.add(est);
        }

    }
    
    /**
     * Prueba para remplazar las instancias de Books asociadas a una instancia
     * de Editorial.
     */
    @Test
    public void replaceOfertaTest() {
        EstudianteEntity entity = caldata.get(0);
        OfertaEntity e = data.get(0);
        estudianteOfertasLogic.replaceOferta(entity.getId(), data.get(0).getId());
        entity = estudianteLogic.getEstudiante(entity.getId());
        Assert.assertEquals(entity.getOfertas(), data.remove(e));
    }
    
}

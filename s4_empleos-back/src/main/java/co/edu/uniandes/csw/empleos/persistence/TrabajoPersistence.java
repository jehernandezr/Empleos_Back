package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Esta clase se encarga de crear y persistir trabajos
 * @author David Dominguez
 */
@Stateless
public class TrabajoPersistence {
    
    // Se declara el manejador de entidades y se relaciona con la base de datos
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    /* 
     * Método que crea añade el trabajo que llega por parámetro a la base de datos
     * @param 
           t El trabajo que se desea añadir a la base de datos.
     * @return 
           El trabajo que se añadió a la base de datos.
    */
    public TrabajoEntity create(TrabajoEntity t) {
        em.persist(t);
        return t;
    }
}

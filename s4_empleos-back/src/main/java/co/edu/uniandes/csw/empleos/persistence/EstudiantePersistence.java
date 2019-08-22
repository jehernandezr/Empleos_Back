/*

 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 * Esta clase se encarga de crear y persistir estudiantes
 * @author David Dominguez
 */
@Stateless
public class EstudiantePersistence {
    
    // Se declara el manejador de entidades y se relaciona con la base de datos
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    /* 
     * Método que crea añade el estudiante que llega por parámetro a la base de datos
     * @param 
           e El estudiante que se desea añadir a la base de datos.
     * @return 
           El estudiante que se añadió a la base de datos.
    */
    public EstudianteEntity create(EstudianteEntity e) {
        em.persist(e);
        return e;
    }
    
}

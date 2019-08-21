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
 *
 * @author Estudiante
 */
@Stateless
public class EstudiantePersistence {
    
    @PersistenceContext(unitName = "empleosPU")
    public EntityManager em;
    
    public EstudianteEntity create(EstudianteEntity e) {
        //throw new java.lang.UnsupportedOperationException("Not supported yet.");
        em.persist(e);
        return e;
    }
    
}

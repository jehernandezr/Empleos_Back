/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import jdk.nashorn.internal.runtime.FindProperty;

/**
 *
 * @author Estudiante
 */
@Stateless
public class CalificacionPersistence {
     
    /**
     * Portero, quien admistra quien entra y quien sale del PersistenceContext
     */
    @PersistenceContext(unitName= "empleosPU")
    protected EntityManager em;
    
    public CalificacionEntity find (Long id)
    {
      return em.find(CalificacionEntity.class, id);
    }
    
    public CalificacionEntity create(CalificacionEntity calificacionEntity)
    {
        em.persist(calificacionEntity);
        return calificacionEntity;
    }
    
  
}

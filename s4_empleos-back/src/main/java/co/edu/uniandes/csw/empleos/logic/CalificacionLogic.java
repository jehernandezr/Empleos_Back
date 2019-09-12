/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.logic;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CalificacionPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolás Munar
 */
@Stateless
public class CalificacionLogic {
    
     @Inject
    private CalificacionPersistence persistence;
    
    
    public CalificacionEntity createCalificacion(CalificacionEntity calificacion) throws BusinessLogicException{
        if(calificacion.getNota()<0){
            throw new BusinessLogicException("La nota del estudiante no puede tener valores negativos");
        }
        if(calificacion.getComentario()==null){
            throw new BusinessLogicException("El comentario de un estudainte no puede ser nulo");
        }
        
        calificacion = persistence.create(calificacion);
        return calificacion;
    }
    
}

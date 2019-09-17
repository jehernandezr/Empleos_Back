/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.logic;
import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import co.edu.uniandes.csw.empleos.persistence.TrabajoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author David Domínguez
 */
@Stateless
public class TrabajoLogic {
    
    @Inject
    private TrabajoPersistence persistence;
    
    //No hay reglas de negocio para esta clase
    
    
    public TrabajoEntity crearTrabajo(TrabajoEntity entity) {
        entity = persistence.create(entity);
        return entity;
    }
    
    public TrabajoEntity updateTrabajo(TrabajoEntity entity) {
        entity = persistence.update(entity);
        return entity;
    }
    
    public TrabajoEntity deleteTrabajo(long id) {
        return persistence.delete(id);
    }
    
    public TrabajoEntity readTrabajo(long id) {
        return persistence.read(id);
    }
}
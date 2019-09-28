/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import co.edu.uniandes.csw.empleos.persistence.OfertaPersistence;
import co.edu.uniandes.csw.empleos.persistence.TrabajoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;
/**
 *
 * @author Estudiante
 */
@Stateless
public class TrabajoOfertaLogic {
    
    @Inject
    private TrabajoPersistence trabajoPersistence;

    @Inject
    private OfertaPersistence ofertaPersistence;
    
     /**
     * Remplazar la oferta de un trabajo.
     *
     * @param calId .
     * @param estId .
     * @return .
     */
    public TrabajoEntity replaceOferta(Long calId, Long estId) {
        OfertaEntity ofertaEntity = ofertaPersistence.find(estId);
        TrabajoEntity trabajoEntity = trabajoPersistence.read(calId);
        trabajoEntity.setOferta(ofertaEntity);
        return trabajoEntity;
    }
    
    
    
    /**
     * Borrar una oferta de una trabajo Este metodo se utiliza para borrar la
     * relacion de una oferta.
     *
     * @param calId El libro que se desea borrar de la editorial.
     */
    public void removeOferta(Long calId) {
        TrabajoEntity trabajoEntity = trabajoPersistence.read(calId);
        OfertaEntity ofertaEntity = ofertaPersistence.find(trabajoEntity.getOferta().getId());
        trabajoEntity.setOferta(null);
        ofertaEntity.setTrabajo(null);
    }
    
    

}

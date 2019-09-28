package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.persistence.EstudiantePersistence;
import co.edu.uniandes.csw.empleos.persistence.OfertaPersistence;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import java.util.logging.Level;
import javax.ejb.Stateless;
import javax.inject.Inject;

@Stateless
public class EstudianteOfertasLogic {

    @Inject
    private EstudiantePersistence estudiantePersistence;

    @Inject
    private OfertaPersistence ofertaPersistence;
    
     /**
     * Remplazar la oferta de un estudiante.
     *
     * @param calId .
     * @param estId .
     * @return .
     */
    public EstudianteEntity replaceOferta(Long calId, Long estId) {
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estId);
        OfertaEntity ofertaEntity = ofertaPersistence.find(calId);
        int i = 0;
        for(OfertaEntity o : estudianteEntity.getOfertas()) {
        	if(o.getId() == estId) {
        		estudianteEntity.getOfertas().set(i, ofertaEntity);
        		break;
        	} else {
        		i++;
        	}
        } 
        
        return estudianteEntity;
    }
    
    
    
    /**
     * Borrar una oferta de un Estudiante Este metodo se utiliza para borrar la
     * relacion de una oferta.
     *
     * @param calId El libro que se desea borrar de la editorial.
     */
    public void removeOferta(Long estId, Long ofertaId) {
        EstudianteEntity estudianteEntity = estudiantePersistence.find(estId);
        OfertaEntity oferta = null;
        for(OfertaEntity o : estudianteEntity.getOfertas()) {
        	if(o.getId() == ofertaId) {
        		oferta = o;
        } 
        OfertaEntity ofertaEntity = ofertaPersistence.find(o.getId());
        int i = 0;
        for(OfertaEntity ofe : estudianteEntity.getOfertas()) {
        	if(ofe.getId() == ofertaId) {
        		estudianteEntity.getOfertas().set(i, null);
        		break;
        	} else {
        		i++;
        	}
        }
        i = 0;
        for(EstudianteEntity e: ofertaEntity.getEstudiantes()) {
        	if(e.getId() == estId) {
        		ofertaEntity.getEstudiantes().set(i, null);
        		break;
        	} else {
        		i++;
        	}
        		
        }
        }
    }
    
    

}

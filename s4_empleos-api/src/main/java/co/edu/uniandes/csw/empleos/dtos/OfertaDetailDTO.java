/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class OfertaDetailDTO extends OfertaDTO implements Serializable {
    
    private TrabajoDTO trabajo;
    
    private List<EstudianteDTO> estudiantes;
    
    private ContratistaDTO contratista;
    
    
    
    public OfertaDetailDTO(){
        
    }

    public OfertaDetailDTO(OfertaEntity ofertaEntity) {
       super(ofertaEntity);
        if (ofertaEntity != null) {
            
            if (ofertaEntity.getEstudiantes()!= null) {
                estudiantes = new ArrayList<>();
                for (EstudianteEntity entityBook : ofertaEntity.getEstudiantes()) {
                    estudiantes.add(new EstudianteDTO(entityBook));
                }
            }
            
            if (ofertaEntity.getTrabajo()!= null)
                trabajo = new TrabajoDTO(ofertaEntity.getTrabajo());
            
            if (ofertaEntity.getContratista()!= null)
                contratista = new ContratistaDTO(ofertaEntity.getContratista());
        }
    }
    
      /**
     * Transformar un DTO a un Entity
     *
     * @return El DTO de la editorial para transformar a Entity
     */
    @Override
    public OfertaEntity toEntity() {
        OfertaEntity ofertaEntity = super.toEntity();
        if (estudiantes != null) {
            List<EstudianteEntity> estudiantesEntity = new ArrayList<>();
            for (EstudianteDTO dtoEstudiante : estudiantes) {
                estudiantesEntity.add(dtoEstudiante.toEntity());
            }
            ofertaEntity.setEstudiantes(estudiantesEntity);
        }
        
        if (contratista != null) ofertaEntity.setContratista(contratista.toEntity());
        if (trabajo != null) ofertaEntity.setTrabajo(trabajo.toEntity());
        
        return ofertaEntity;
    }
    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class EstudianteDetailDTO extends EstudianteDTO implements Serializable{
    
    private List<CalificacionDTO> calificacioness;
    
    public EstudianteDetailDTO()
    {
        //Constructor vacio
    }

    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param estudianteEntity La entidad del estudiante para transformar a DTO.
     */
    public EstudianteDetailDTO(EstudianteEntity estudianteEntity) {
        super(estudianteEntity);
        if (estudianteEntity != null) {
            if (estudianteEntity.getCalificaciones()!= null) {
                calificacioness = new ArrayList<>();
                for (CalificacionEntity entityBook : estudianteEntity.getCalificaciones()) {
                    calificacioness.add(new CalificacionDTO(entityBook));
                }
            }
        }
    }
    
        /**
     * Transformar un DTO a un Entity
     *
     * @return El DTO de la editorial para transformar a Entity
     */
    @Override
    public EstudianteEntity toEntity() {
        EstudianteEntity estudianteEntity = super.toEntity();
        if (calificacioness != null) {
            List<CalificacionEntity> calificacionesEntity = new ArrayList<>();
            for (CalificacionDTO dtoCalificacion : calificacioness) {
                calificacionesEntity.add(dtoCalificacion.toEntity());
            }
            estudianteEntity.setCalificaciones(calificacionesEntity);
        }
        return estudianteEntity;
    }

    /**
     * @return the califics
     */
    public List<CalificacionDTO> getCalificaciones() {
        return calificacioness;
    }

    /**
     * @param califics the califics to set
     */
    public void setCalificaciones(List<CalificacionDTO> calificacioness) {
        this.calificacioness = calificacioness;
    }
    
}

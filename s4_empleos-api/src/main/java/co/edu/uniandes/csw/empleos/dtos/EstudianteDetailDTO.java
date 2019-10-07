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
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

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
     * @return the calificioness
     */
    public List<CalificacionDTO> getCalificaciones() {
        return calificacioness;
    }

    /**
     * @param calificacioness the califics to set
     */
    public void setCalificaciones(List<CalificacionDTO> calificacioness) {
        this.calificacioness = calificacioness;
    }
    
    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
    
}

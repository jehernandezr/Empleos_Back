/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;
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

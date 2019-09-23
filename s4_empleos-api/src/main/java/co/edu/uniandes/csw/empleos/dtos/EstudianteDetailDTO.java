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
    
    private List<CalificacionDTO> califics;
    
    public EstudianteDetailDTO()
    {
        //Constructor vacio
    }

    /**
     * @return the califics
     */
    public List<CalificacionDTO> getCalifics() {
        return califics;
    }

    /**
     * @param califics the califics to set
     */
    public void setCalifics(List<CalificacionDTO> califics) {
        this.califics = califics;
    }
    
}

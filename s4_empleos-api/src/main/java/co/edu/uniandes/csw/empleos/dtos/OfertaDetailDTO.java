/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import java.io.Serializable;

/**
 *
 * @author Estudiante
 */
public class OfertaDetailDTO extends OfertaDTO implements Serializable {
    
    
    
    
    public OfertaDetailDTO(){
        
    }

    public OfertaDetailDTO(OfertaEntity entity) {
       super(entity);
    }
    
    
    
    
}
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import java.io.Serializable;

/**
 *
 * @author Estudiante
 */
public class CalificacionDTO implements Serializable{
    
    private Long id;
    
    private Double nota;
    
    private String comentario;

    public CalificacionDTO()
    {
        //Constructor vacio
    }
    
        /**
     * Constructor a partir de la entidad
     *
     * @param calificacionEntity La entidad del libro
     */
    public CalificacionDTO(CalificacionEntity tarjetaEntity) {
        
        if (tarjetaEntity != null) {
            this.id = tarjetaEntity.getId();
            this.comentario = tarjetaEntity.getComentario();
            this.nota = tarjetaEntity.getNota();
       }
    }
    
    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad del libro asociado.
     */
    public CalificacionEntity toEntity() {
        
        CalificacionEntity calificacionEntity = new CalificacionEntity();
        calificacionEntity.setId(this.id);
        calificacionEntity.setNota(this.getNota());
        calificacionEntity.setComentario(this.getComentario());
        
        
        return calificacionEntity;
    }
    
    /**
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    /**
     * @return the nota
     */
    public Double getNota() {
        return nota;
    }

    /**
     * @param nota the nota to set
     */
    public void setNota(Double nota) {
        this.nota = nota;
    }

    /**
     * @return the comnetario
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * @param comnetario the comnetario to set
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;

/**
 *
 * @author Estudiante
 */
public class CalificacionDTO implements Serializable{
    
    private Integer id;
    
    private Double nota;
    
    private String comentario;

    public CalificacionDTO()
    {
        //Constructor vacio
    }
    
    /**
     * @return the id
     */
    public Integer getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(Integer id) {
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

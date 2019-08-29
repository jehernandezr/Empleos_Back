/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import javax.persistence.Entity;

/**
 *
 * @author Estudiante
 */
@Entity
public class CalificacionEntity extends BaseEntity{
    
    /**
     * Atributo de la nota que será puesta a un estudiante.
     */
    private Double nota;
    
    /**
     * Atributo que será el comentario a la calificacion puesta.
     */
    private String comentario;
    
     /**
     * Contrctor de la Clase Calificación para inicualizar los atributos
     * @param nota Nota de un estudiante. nota>=0.0 && nota<=5.0
     * @param comentario Comentario asociado a la nota. comentario != null && comentario != "".
     */
    public CalificacionEntity( ){
    }


    /**
     * Metodo que da el resultado del comentario.
     * @return Comentario asociado a la nota asignada. return != null
     */
    public String getComentario() {
        return comentario;
    }

    /**
     * Metodo que retorna la nota asociada a un estudainte
     * @return Nota en un valor entre 0.0 y 5.0
     */
    public Double getNota() {
        return nota;
    }

    /**
     * Metodo que permite modificar el comentario asignado a la nota.
     * @param comentario Es el nuevo mensaje por el cual se va a reemplzar el atributo inicializado previamente.
     */
    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    /**
     * Metodo que permite modificar el valor de la nota inicializado previamente.
     * @param nota Nota en un valor entre 0.0 y 5.0
     */
    public void setNota(Double nota) {
        this.nota = nota;
    }

}

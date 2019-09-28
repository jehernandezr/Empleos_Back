/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Estudiante
 */
class EstudianteDTO implements Serializable{
    
    private Integer id;
    private String nombre;
    private String carrera;
    private String correo;
    private Double calificacionPromedio;
    private Integer semestre;
    private Date horarioDeTrabajo;

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
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param nombre the nombre to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the calificacionPromedio
     */
    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    /**
     * @param calificacionPromedio the calificacionPromedio to set
     */
    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    /**
     * @return the semestre
     */
    public Integer getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the horarioDeTrabajo
     */
    public Date getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }

    /**
     * @param horarioDeTrabajo the horarioDeTrabajo to set
     */
    public void setHorarioDeTrabajo(Date horarioDeTrabajo) {
        this.horarioDeTrabajo = horarioDeTrabajo;
    }
    
}

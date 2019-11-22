/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import java.io.Serializable;

/**
 *
 * @author David Domínguez
 */
public class EstudianteDTO implements Serializable {

    private long id;
    private long idMedioDepago;
    private String nombre;
    private String carrera;
    private String correo;
    private double calificacionPromedio;
    private Integer semestre;
    private String horarioDeTrabajo;
    private String token;

    /**
     * Constructor por defecto
     */
    public EstudianteDTO() {
        //Vacio
    }

    /**
     * Conviertir Entity a DTO (Crea un nuevo DTO con los valores que recibe en
     * la entidad que viene de argumento.
     *
     * @param estudianteEntity: Es la entidad que se va a convertir a DTO
     */
    public EstudianteDTO(EstudianteEntity estudianteEntity) {
        if (estudianteEntity != null) {
            this.id = estudianteEntity.getId();
            this.idMedioDepago = estudianteEntity.getIdMedioDepago();
            this.nombre = estudianteEntity.getNombre();
            this.carrera = estudianteEntity.getCarrera();
            this.calificacionPromedio = estudianteEntity.getCalificacionPromedio();
            this.semestre = estudianteEntity.getSemestre();
            this.horarioDeTrabajo = estudianteEntity.getHorarioDeTrabajo();
            this.idMedioDepago = estudianteEntity.getIdMedioDepago();
            this.correo = estudianteEntity.getCorreo();
            this.token = null;
        }
    }

    public String getToken() {
        return token;
    }

    public void setToken(String id) {
        this.token = id;
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
    public void setId(long id) {
        this.id = id;
    }

    /**
     * @return the idMedioDepago
     */
    public Long getIdMedioDepago() {
        return idMedioDepago;
    }

    /**
     * @param id the idMedioDepago to set
     */
    public void setIdMedioDepago(long idMedioDepago) {
        this.idMedioDepago = idMedioDepago;
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
    public void setCalificacionPromedio(double calificacionPromedio) {
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
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the horarioDeTrabajo
     */
    public String getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }

    /**
     * @param horarioDeTrabajo the horarioDeTrabajo to set
     */
    public void setHorarioDeTrabajo(String horarioDeTrabajo) {
        this.horarioDeTrabajo = horarioDeTrabajo;
    }

    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public EstudianteEntity toEntity() {

        EstudianteEntity estudianteEntity = new EstudianteEntity();
        estudianteEntity.setId(this.id);
        estudianteEntity.setIdMedioDepago(this.idMedioDepago);
        estudianteEntity.setNombre(this.nombre);
        estudianteEntity.setCarrera(this.carrera);
        estudianteEntity.setCorreo(this.correo);
        estudianteEntity.setCalificacionPromedio(this.calificacionPromedio);
        estudianteEntity.setHorarioDeTrabajo(this.horarioDeTrabajo);
        estudianteEntity.setSemestre(this.semestre);
        estudianteEntity.setIdMedioDepago(this.idMedioDepago);
        return estudianteEntity;
    }

}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;

/**
 *
 * @author David Dominguez
 */
public class UsuarioDTO implements Serializable {

    private Long id;
    private Boolean esExterno;
    private String nombre;
    private String email;
    private String rutaImagen;
    private Long idMedioDepago;
    private String carrera;
    private Double calificacionPromedio;
    private Integer semestre;
    private String horarioDeTrabajo;

    public UsuarioDTO() {
        
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Boolean getEsExterno() {
        return esExterno;
    }

    public void setEsExterno(Boolean esExterno) {
        this.esExterno = esExterno;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRutaImagen() {
        return rutaImagen;
    }

    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }

    public Long getIdMedioDepago() {
        return idMedioDepago;
    }

    public void setIdMedioDepago(Long idMedioDepago) {
        this.idMedioDepago = idMedioDepago;
    }

    public String getCarrera() {
        return carrera;
    }

    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    public Double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    public void setCalificacionPromedio(Double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    public Integer getSemestre() {
        return semestre;
    }

    public void setSemestre(Integer semestre) {
        this.semestre = semestre;
    }

    public String getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }

    public void setHorarioDeTrabajo(String horarioDeTrabajo) {
        this.horarioDeTrabajo = horarioDeTrabajo;
    }
}

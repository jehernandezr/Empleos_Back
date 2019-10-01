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
public class ContratistaDTO implements Serializable{
    
    /**
     * Variable que representa si el contratista es externo.
     */
    private boolean esExterno;
    
    /**
     * Variable que representa el nombre del contratista.
     */
    private String nombre;
    
    /**
     * Variable que representa el nombre del contratista.
     */
    private String email;
    
    
    
    /**
     * Variable que representa la contraseña del contratista.
     */
    private String contrasena;
    
     /**
     * Variable que representa la ruta de la imagen del contratista.
     */
    private String rutaImagen;
    
    
    public ContratistaDTO(){
        
    }

    /**
     * @return the esExterno
     */
    public boolean isEsExterno() {
        return esExterno;
    }

    /**
     * @param esExterno the esExterno to set
     */
    public void setEsExterno(boolean esExterno) {
        this.esExterno = esExterno;
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
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * @param email the email to set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    /**
     * @return the contrasena
     */
    public String getContrasena() {
        return contrasena;
    }

    /**
     * @param contrasena the contrasena to set
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }

    /**
     * @return the rutaImagen
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * @param rutaImagen the rutaImagen to set
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
}

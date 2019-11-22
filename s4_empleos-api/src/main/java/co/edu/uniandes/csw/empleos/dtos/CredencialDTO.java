/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.CredencialesEntity;
import java.io.Serializable;

/**
 *
 * @author David Dominguez
 */
public class CredencialDTO implements Serializable {
    
    private String correo;
    private String contraseña;
    private String tipo;

    public CredencialDTO() {
        //Constructor vacío Token
    }

    public CredencialDTO(CredencialesEntity e) {
        if (e != null) {
            this.correo = e.getCorreo();
            this.contraseña = e.getContrasena();
            this.tipo = e.getTipo();

        }
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
     * @return the tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * @param tipo the tipo to set
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * @return the contraseña
     */
    public String getContraseña() {
        return contraseña;
    }

    /**
     * @param contraseña the contraseña to set
     */
    public void setId(String contraseña) {
        this.contraseña = contraseña;
    }

    public CredencialesEntity toEntity() {
        CredencialesEntity e = new CredencialesEntity();
        e.setContrasena(contraseña);
        e.setTipo(tipo);
        e.setCorreo(correo);
        return e;
    }
}

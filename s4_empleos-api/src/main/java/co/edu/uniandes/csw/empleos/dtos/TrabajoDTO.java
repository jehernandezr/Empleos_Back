/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import java.io.Serializable;

/**
 *
 * @author David Dominguez
 */
public class TrabajoDTO implements Serializable {

    private boolean verificado;
    private boolean cumplido;
    private long id;
    private String token;

    public TrabajoDTO() {
        //Constructor vacío
    }
    
    public TrabajoDTO(TrabajoEntity e) {
        if (e!= null){
            this.id = e.getId();
            this.verificado = e.isVerificado();
            this.cumplido = e.isCumplido();
            this.token = null;
        
        }
    }
    
    public long getId() {
        return id;
    }
    
    public void setId(long id) {
        this.id = id;
    }

    public boolean isVerificado() {
        return verificado;
    }

    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    public boolean isCumplido() {
        return cumplido;
    }

    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }
    
    public String getToken() {
        return token;
    }
    
    public void setToken(String id) {
        this.token = id;
    }

    public TrabajoEntity toEntity() {
        TrabajoEntity e = new TrabajoEntity();
        e.setCumplido(cumplido);
        e.setVerificado(verificado);
        return e;
    }
}

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

    public TrabajoDTO() {
        //Constructor vacío
    }
    
    public TrabajoDTO(TrabajoEntity e) {
        verificado = e.isVerificado();
        cumplido = e.isCumplido();
        id = e.getId();
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

    public TrabajoEntity toEntity() {
        TrabajoEntity e = new TrabajoEntity();
        e.setCumplido(cumplido);
        e.setVerificado(verificado);
        return e;
    }
}

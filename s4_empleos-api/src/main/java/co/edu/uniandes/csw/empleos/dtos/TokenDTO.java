/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.TokenEntity;
import java.io.Serializable;

/**
 *
 * @author Nicolas Munar
 */
public class TokenDTO implements Serializable {
    
     private String token;
    private String tipo;
        private long id;

    
     public TokenDTO() {
        //Constructor vacío Token
    }
    
     public TokenDTO(TokenEntity e) {
        if (e!= null){
            this.id = e.getId();
            this.token = e.getToken();
            this.tipo = e.getTipo();
        
        }
    }

    /**
     * @return the token
     */
    public String getToken() {
        return token;
    }

    /**
     * @param token the token to set
     */
    public void setToken(String token) {
        this.token = token;
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
     * @return the id
     */
    public long getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(long id) {
        this.id = id;
    }
     
         public TokenEntity toEntity() {
        TokenEntity e = new TokenEntity();
        e.setToken(token);
        e.setTipo(tipo);
        return e;
    }
     
}

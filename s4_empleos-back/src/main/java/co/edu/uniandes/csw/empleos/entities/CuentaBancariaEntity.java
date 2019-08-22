/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Santiago Tangarife Rincón
 */
@Entity
public class CuentaBancariaEntity extends BaseEntity implements Serializable
{
    /**
     * numero de la tarjeta
     */
    private int numero;
    
    /*
    numero idEstudiante de la tarjeta
    */
    private String idEstudiante;
    
    /*
    fecha de Fecha de la tarjeta
    */
    @Temporal(TemporalType.DATE)
    private Date fecha;

    
    
    public void CuentaBancariaEntity()
    {
    }
    
    //-------------------------------------------------
    //GETTERS & SETTERS
    //-------------------------------------------------
    
    /**
     * 
     * @return numero de la tarjeta 
     */
    public int getNumero() {
        return numero;
    }

    /**
     * cambia el numero de la tarjeta al ingresado por parametro
     * @param numero nuevo numero de la tarjeta
     */
    public void setNumero(int numero) {
        this.numero = numero;
    }

    
    /**
     * Da el idEstudiante de la tarjeta
     * @return idEstudiante de la tarjeta
     */
    public String getIdEstudiante() {
        return idEstudiante;
    }

    /**
     * Cambia el idEstudiante de la tarjeta
     * @param idEstudiante nuevo idEstudiante de la tarjeta
     */
    public void setIdEstudiante(String idEstudiante) {
        this.idEstudiante = idEstudiante;
    }

    /**
     * @return the Fecha
     */
    public Date getFecha() {
        return fecha;
    }

    /**
     * @param fecha the Fecha to set
     */
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    
}

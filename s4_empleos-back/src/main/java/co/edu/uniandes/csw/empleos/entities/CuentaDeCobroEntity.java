/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import co.edu.uniandes.csw.empleos.podam.DateStrategy;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Santiago Tangarife Rincón
 */
@Entity
public class CuentaDeCobroEntity extends BaseEntity implements Serializable {

    /**
     * numeroCuentaDeCobro de la tarjeta
     */
    private int numeroCuentaDeCobro;

    /*
    numeroCuentaDeCobro contratista de la tarjeta
     */
    private String contratista;

    /*
    fecha de Fecha de la tarjeta
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;

    public CuentaDeCobroEntity() {
    }

    //-------------------------------------------------
    //GETTERS & SETTERS
    //-------------------------------------------------
    /**
     *
     * @return numeroCuentaDeCobro de la tarjeta
     */
    public int getNumeroCuentaDeCobro() {
        return numeroCuentaDeCobro;
    }

    /**
     * cambia el numeroCuentaDeCobro de la tarjeta al ingresado por parametro
     *
     * @param numeroCuentaDeCobro nuevo numeroCuentaDeCobro de la tarjeta
     */
    public void setNumeroCuentaDeCobro(int numeroCuentaDeCobro) {
        this.numeroCuentaDeCobro = numeroCuentaDeCobro;
    }

    /**
     * Da el contratista de la tarjeta
     *
     * @return contratista de la tarjeta
     */
    public String getContratista() {
        return contratista;
    }

    /**
     * Cambia el contratista de la tarjeta
     *
     * @param contratista nuevo contratista de la tarjeta
     */
    public void setContratista(String contratista) {
        this.contratista = contratista;
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

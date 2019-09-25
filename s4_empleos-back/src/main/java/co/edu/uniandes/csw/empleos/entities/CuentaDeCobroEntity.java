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
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import uk.co.jemos.podam.common.PodamExclude;
import uk.co.jemos.podam.common.PodamLongValue;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Santiago Tangarife Rincón
 */
@Entity
public class CuentaDeCobroEntity extends BaseEntity implements Serializable {

    /**
     * numeroCuentaDeCobro
     */
    @PodamLongValue(minValue = 1)
    private int numeroCuentaDeCobro;

    /**
    * nombre del Contratista
     */
    @PodamExclude
    @ManyToOne
    private ContratistaEntity contratista;

    /**
    *fecha de la cuenta de cobro
     */
    @Temporal(TemporalType.DATE)
    @PodamStrategyValue(DateStrategy.class)
    private Date fecha;

    /**
     * Valor que de debe.
     */
    @PodamLongValue(minValue = 1)
    private int valor;
    
    /**
     * Nombre del nombreEstudiante a quien se le debe el valor
     */
    private String nombreEstudiante;
    
    /**
     *Concepto  
     */
    private String concepto;
    
    /**
     * Constructor
     */
    public CuentaDeCobroEntity() {
       //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
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
    public ContratistaEntity getContratista() {
        return contratista;
    }

    /**
     * Cambia el contratista de la tarjeta
     *
     * @param contratista nuevo contratista de la tarjeta
     */
    public void setContratista(ContratistaEntity contratista) {
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

    /**
     * @return el valor de la cuenta de cobro 
     */
    public int getValor() {
        return valor;
    }

    /**
     * @return nombreEstudiante de la cuenta de cobro
     */
    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    /**
     * @return concepto de la cuenta de cobro
     */
    public String getConcepto() {
        return concepto;
    }

    /**
     * @param valor de la cuenta de cobro
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @param nombreEstudiante de la cuenta de cobro
     */
    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    /**
     * @param concepto de la cuenta de cobro
     */
    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }

    
}

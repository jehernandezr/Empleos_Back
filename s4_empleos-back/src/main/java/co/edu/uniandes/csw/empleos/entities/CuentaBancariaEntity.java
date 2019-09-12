
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.podam.NumeroStringStrategy;
import co.edu.uniandes.csw.empleos.podam.TipoCuentaStrategy;
import javax.persistence.Entity;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 * @author je.hernandezr
 */
@Entity
public class CuentaBancariaEntity extends BaseEntity {

    private final static int CUENTA_AHORROS = 2;
    private final static int CUENTA_CORRIENTE = 3;

    @PodamStrategyValue(NumeroStringStrategy.class)
    private String numeroCuenta;

    private String nombreBanco;

    @PodamStrategyValue(TipoCuentaStrategy.class)
    private int tipoCuenta;

    public CuentaBancariaEntity() {
        //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
    }

    /**
     * @return the numeroCuenta
     */
    public String getNumeroCuenta() {
        return numeroCuenta;
    }

    /**
     * @param numeroCuenta the numeroCuenta to set
     */
    public void setNumeroCuenta(String numeroCuenta) {
        this.numeroCuenta = numeroCuenta;
    }

    /**
     * @return the tipoCuenta
     */
    public int getTipoCuenta() {
        return tipoCuenta;
    }

    /**
     * @param pTipoCuenta the tipoCuenta to set
     */
    public void setTipoCuenta(String pTipoCuenta) {

        if (pTipoCuenta != null) {
            if (pTipoCuenta.equalsIgnoreCase("Ahorros")) {
                tipoCuenta = CUENTA_AHORROS;
            } else if (pTipoCuenta.equalsIgnoreCase("Corriente")) {
                tipoCuenta = CUENTA_CORRIENTE;
            } else {
                tipoCuenta = 0;
            }

        }

    }

    /**
     * @return the nombreBanco
     */
    public String getNombreBanco() {
        return nombreBanco;
    }

    /**
     * @param nombreBanco the nombreBanco to set
     */
    public void setNombreBanco(String nombreBanco) {
        this.nombreBanco = nombreBanco;
    }

}

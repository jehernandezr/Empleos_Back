/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

/**
 *
 * @author Estudiante
 */
@Entity
public class TarjetaDeCreditoEntity 
{
    private int numero;
    
    private String cvc;
    
    private String vencimiento;

    
    
    public void TarjetaDeCreditoEntity(int pNumero, String pCvc,String pVencimiento)
    {
        numero=pNumero;
        cvc=pCvc;
        vencimiento=pVencimiento;
    }
    
    //-------------------------------------------------
    //GETTERS & SETTERS
    //-------------------------------------------------
    
    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        this.numero = numero;
    }

    public String getCvc() {
        return cvc;
    }

    public void setCvc(String cvc) {
        this.cvc = cvc;
    }

    public String getVencimiento() {
        return vencimiento;
    }

    public void setVencimiento(String vencimiento) {
        this.vencimiento = vencimiento;
    }
}

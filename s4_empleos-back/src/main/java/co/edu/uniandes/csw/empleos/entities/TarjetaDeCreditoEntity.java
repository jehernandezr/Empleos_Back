/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

/**
 *
 * @author Miguel Angel Ramos Hurtado
 */
@Entity
public class TarjetaDeCreditoEntity extends BaseEntity implements Serializable {
    
    private String numero;
    
    public TarjetaDeCreditoEntity()
    {
        
    }
    
    public TarjetaDeCreditoEntity(String pNumero)
    {
        this.numero = pNumero;
    }
    
    /**
     * @Return el nnmero de la tarjeta de credito.
     */
   public String getNumero(){
       return numero;
   }
    
    /**
     * @param pNumero el numero a poner.
     */
   public void setNumero(String pNumero){
       numero = pNumero;
   }
   
   
    
    
    
}

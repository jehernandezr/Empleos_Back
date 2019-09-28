/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *
 * @author Miguel Angel Ramos Hurtado
 */
@Entity
public class TarjetaDeCreditoEntity extends BaseEntity implements Serializable {
    
    private String numero;
    private String cvc;
    private String fecha;
    
    @PodamExclude
    @OneToOne(mappedBy = "tarjetaCredito", fetch = FetchType.LAZY)
    private ContratistaEntity contratista;
    
    public TarjetaDeCreditoEntity()
    {
        //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
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
   
   /**
    * @Return el cvc de la tarjeta de credito.
    */
   public String getCVC(){
       return cvc;
   }
   
   /**
    * @param pCVC es el cvc a establecer.
    */
   public void setCVC(String pCVC){
       cvc = pCVC;
   }
   /**
    * @return retorna la fecha de la tarjeta de crédito.
    */
   public String getFecha()
   {
       return fecha;
   }
   /**
    * @param pDia es el día de vencimiento de la tarjeta.
    * @param pAño es el año de vencimiento de la tarjeta.
    */
   public void setFecha(String pFecha)
   {
       fecha = pFecha;
   }
   
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.TarjetaDeCreditoEntity;
import java.io.Serializable;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 *
 * @author Estudiante
 */
public class TarjetaDeCreditoDTO implements Serializable {
    
    private Long id;
    private String numero;
    private String cvc;
    private String fecha;
    
    public TarjetaDeCreditoDTO()
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
   
    

    

    /**
     * Constructor a partir de la entidad
     *
     * @param bookEntity La entidad del libro
     */
    public TarjetaDeCreditoDTO(TarjetaDeCreditoEntity tarjetaEntity) {
        
        if (tarjetaEntity != null) {
            this.id = tarjetaEntity.getId();
            this.numero = tarjetaEntity.getNumero();
            this.cvc = tarjetaEntity.getCVC();
            this.fecha = tarjetaEntity.getFecha();
        }
    }

    /**
     * Método para transformar el DTO a una entidad.
     *
     * @return La entidad del libro asociado.
     */
    public TarjetaDeCreditoEntity toEntity() {
        
        TarjetaDeCreditoEntity tarjetaEntity = new TarjetaDeCreditoEntity();
        tarjetaEntity.setId(this.id);
        tarjetaEntity.setNumero(this.numero);
        tarjetaEntity.setCVC(this.cvc);
        tarjetaEntity.setFecha(this.fecha);
        
        
        return tarjetaEntity;
    }

    /**
     * Devuelve el ID del libro
     *
     * @return the id
     */
    public Long getId() {
        return id;
    }

    /**
     * Modifica el ID del libro.
     *
     * @param id the id to set
     */
    public void setId(Long id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this, ToStringStyle.MULTI_LINE_STYLE);
    }
}

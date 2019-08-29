/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import javax.persistence.Entity;

/**
 *
 * @author Estudiante
 */
@Entity
public class FacturaEntity extends BaseEntity{
    
    /**
     * La fecha que se le atribuirá a una factura. De esta manera se tiene un control por fechas
     */
    private String fecha;
    
    /**
     * Valor que se registrará a una factura.
     */
    private Integer valor;
    
    /**
     * Constructor de la clase 
     */
    public FacturaEntity()
    {
       
    }

    /**
     * Este metodo da el valor de la fecha que está asociada a una factura
     * @return Fecha Un valor en un formato acordado. fecha != null && != fecha""
     */
    public String getFecha() {
        return fecha;
    }

    /**
     * Este metodo da el valor de la factura creada
     * @return Valor >0  
     */
    public Integer getValor() {
        return valor;
    }

    /**
     * Se asigna un valor nuevo a la fecha de la factura creada
     * @param fecha Nueva fecha por la cual se quiere modificar el valor de la actual.
     */
    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    /**
     * Se asigna un nuevo valor a la factura creada-
     * @param valor valor > 0 que reemplazara el valor existente
     */
    public void setValor(Integer valor) {
        this.valor = valor;
    }
    
      @Override
    @SuppressWarnings({"BoxedValueEquality", "NumberEquality"})
    public boolean equals (Object obj){
        boolean resp = super.equals(this);
        boolean fin = false;
        final FacturaEntity otro = (FacturaEntity)obj;
        
        if(!resp)
        {
            return fin;
        }else
        {
            if(this.fecha.equalsIgnoreCase(otro.fecha))
            {
                fin = true;
            }if(this.valor == otro.valor)
            {
                fin = true;
            }
                
        }
        return fin;
    }
}

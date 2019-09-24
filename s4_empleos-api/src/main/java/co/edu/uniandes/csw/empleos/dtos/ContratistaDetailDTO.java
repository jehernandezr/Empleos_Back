/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Estudiante
 */
public class ContratistaDetailDTO extends ContratistaDTO implements Serializable{
    
    
     
    //private TarjetaDeCreditoDTOtarjetaDeCredito;
     
    
   // private CuentaBancariaDTO cuentaBancaria;
     
         
     
    private List<OfertaDTO> ofertas ;

    /**
     * @return the ofertas
     */
    public List<OfertaDTO> getOfertas() {
        return ofertas;
    }

    /**
     * @param ofertas the ofertas to set
     */
    public void setOfertas(List<OfertaDTO> ofertas) {
        this.ofertas = ofertas;
    }
    
}

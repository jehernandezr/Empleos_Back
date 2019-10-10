/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Contratista
 */
public class ContratistaDetailDTO extends ContratistaDTO implements Serializable{
    
    
     
    private TarjetaDeCreditoDTO tarjetaDeCredito;
     
    
   private CuentaBancariaDTO cuentaDeCobro;
     
         
     
    private List<OfertaDTO> ofertas ;
    
    /**
     * Constructor vacio
     *
     */
    public ContratistaDetailDTO() {
        //Vacio
    }
    
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param contratistaEntity La entidad del contratista para transformar a DTO.
     */
    public ContratistaDetailDTO(ContratistaEntity contratistaEntity) {
        super(contratistaEntity);
        if (contratistaEntity != null) {
            if (contratistaEntity.getTarjetaCredito()!= null) {
                tarjetaDeCredito = new TarjetaDeCreditoDTO(contratistaEntity.getTarjetaCredito());
                
            }
            
            if (contratistaEntity.getOfertas()!= null) {
                ofertas = new ArrayList<>();
                for (OfertaEntity entityBook : contratistaEntity.getOfertas()) {
                    ofertas.add(new OfertaDTO(entityBook));
                }
            }
            
            if (contratistaEntity.getCuentaDeCobro() != null){
               // cuentaDeCobro = new CuentaDeCobro(contratistaEntity.getCuentaDeCobro());
            }
        }
    }

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

    /**
     * @return the tarjetaDeCredito
     */
    public TarjetaDeCreditoDTO getTarjetaDeCredito() {
        return tarjetaDeCredito;
    }

    /**
     * @param tarjetaDeCredito the tarjetaDeCredito to set
     */
    public void setTarjetaDeCredito(TarjetaDeCreditoDTO tarjetaDeCredito) {
        this.tarjetaDeCredito = tarjetaDeCredito;
    }

   
    
}

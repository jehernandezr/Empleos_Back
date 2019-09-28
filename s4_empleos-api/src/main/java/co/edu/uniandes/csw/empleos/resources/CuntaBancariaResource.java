/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CuentaBancariaDTO;
import co.edu.uniandes.csw.empleos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.*;

/**
 *
 * @author je.hernandezr
 */
@Path("cuentaBancaria")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuntaBancariaResource {

    @Inject
    private CuentaBancariaLogic logic;

    @POST
    public CuentaBancariaDTO createCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws BusinessLogicException {
        CuentaBancariaEntity cuentaBancariaEntity = cuentaBancaria.toEntity();
        cuentaBancariaEntity = logic.createCuentaBancaria(cuentaBancariaEntity);
        return new CuentaBancariaDTO(cuentaBancariaEntity);
    }

    /**
     *
     * @param cuentaId
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{cuentaId: \\d+}")
    public CuentaBancariaDTO getCuntaBancaria(@PathParam("cuentaId") Long cuentaId) throws BusinessLogicException {
        CuentaBancariaEntity cuentaEntity = logic.getCuentaBancaria(cuentaId);
        if (cuentaEntity == null) {
            throw new WebApplicationException("El recurso /cuentaBancaria/" + cuentaId + " no existe.", 404);
        }
        CuentaBancariaDTO cuentaDTO = new CuentaBancariaDTO(cuentaEntity);
        return cuentaDTO;
    }
    
     /**
     * Actualiza la cuentaBancaria con el id recibido en la URL con la información que
     * se recibe en el cuerpo de la petición.
     * @param cuentaId
     * @param cuenta
     * @return JSON {@link PrizeDetailDTO} - El premio guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la cuenta a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar la cuenta.
     */
    @PUT
    @Path("{cuentaId: \\d+}")
 
    public  CuentaBancariaDTO updateCuenta(@PathParam("cuentaId") Long cuentaId,  CuentaBancariaDTO cuenta) throws BusinessLogicException {
        
        if (cuentaId.equals(cuenta.getId())) {
            throw new BusinessLogicException("La id de la cuenta no coincide.");
        }
        CuentaBancariaEntity entity = logic.getCuentaBancaria(cuentaId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /cuentaBancaria/" + cuentaId + " no existe.", 404);

        }
        CuentaBancariaDTO reviewDTO = new CuentaBancariaDTO(logic.updateCuentaBancaria(cuenta.getId(), cuenta.toEntity()));
        
        return reviewDTO;

    }


    /**
     * Borra el premio con el id asociado recibido en la URL.
     *
     * @param cuentaId    
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException    
     * @throws WebApplicationException {@link WebApplicationExceptionMapper}
     * Error de lógica que se genera cuando no se encuentra el premio.
     */
    @DELETE
    @Path("{cuentaId: \\d+}")
    public void deleteCuenta(@PathParam("cuentaId") Long cuentaId) throws BusinessLogicException {
      
        if (logic.getCuentaBancaria(cuentaId) == null) {
            throw new WebApplicationException("El recurso /cuentaBancaria/" + cuentaId + " no existe.", 404);
        }
        logic.delete(cuentaId);
 
    }
}

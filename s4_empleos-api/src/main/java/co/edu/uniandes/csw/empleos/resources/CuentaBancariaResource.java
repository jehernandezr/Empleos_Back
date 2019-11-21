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
public class CuentaBancariaResource {

    private static final  String NO_EXISTE = " no existe.";
    private static final  String RECURSO = "El recurso /cuentaBancaria/";
    
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
        try {
            CuentaBancariaEntity cuentaEntity = logic.getCuentaBancaria(cuentaId);

            
            return new CuentaBancariaDTO(cuentaEntity);
        } catch (Exception e) {
            throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);
        }

    }

    /**
     * Actualiza la cuentaBancaria con el id recibido en la URL con la
     * información que se recibe en el cuerpo de la petición.
     *
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

    public CuentaBancariaDTO updateCuenta(@PathParam("cuentaId") Long cuentaId, CuentaBancariaDTO cuenta) throws BusinessLogicException {

        if (cuentaId.equals(cuenta.getId())) {
            throw new BusinessLogicException("La id de la cuenta no coincide.");
        }
        try {
            CuentaBancariaEntity cuentaEntity = logic.getCuentaBancaria(cuentaId);

            
            return new CuentaBancariaDTO(cuentaEntity);
        } catch (Exception e) {
            throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);
        }

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

        try {
           logic.getCuentaBancaria(cuentaId);

        } catch (BusinessLogicException e) {
            throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);
        }

        logic.delete(cuentaId);

    }
}

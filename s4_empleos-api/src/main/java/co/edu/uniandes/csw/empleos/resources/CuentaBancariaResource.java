/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CuentaBancariaDTO;
import co.edu.uniandes.csw.empleos.ejb.CuentaBancariaLogic;
import co.edu.uniandes.csw.empleos.ejb.TokenLogic;
import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.empleos.entities.TokenEntity;
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

    private static final String NO_EXISTE = " no existe.";
    private static final String RECURSO = "El recurso /cuentaBancaria/";

    @Inject
    private CuentaBancariaLogic logic;
    @Inject
    private TokenLogic tokenLogic;

    @POST
    public CuentaBancariaDTO createCuentaBancaria(CuentaBancariaDTO cuentaBancaria) throws BusinessLogicException {

        String token = cuentaBancaria.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok.getTipo().equals("Estudiante")) {
            CuentaBancariaEntity cb = logic.createCuentaBancaria(cuentaBancaria.toEntity());
            CuentaBancariaDTO nuevaCuentaBancariaDTO = new CuentaBancariaDTO(cb);
            return nuevaCuentaBancariaDTO;

        } else {
            throw new BusinessLogicException("No se le tiene permitido acceder a este recurso");
        }
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

            throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);
        }
        CuentaBancariaDTO cuentaDTO = new CuentaBancariaDTO(cuentaEntity);

        String token = cuentaDTO.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok == null) {

            throw new BusinessLogicException("No se encuentra Registrado");
        }
        return cuentaDTO;
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

        String token = cuenta.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok.getTipo().equals("Estudiante")) {
            cuenta.setId(cuentaId);
            if (logic.getCuentaBancaria(cuentaId) == null) {
                throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);
            }
            CuentaBancariaDTO detailDTO = new CuentaBancariaDTO(logic.updateCuentaBancaria(cuentaId, cuenta.toEntity()));
            return detailDTO;

        } else {
            throw new BusinessLogicException("No se le tiene permitido acceder a este recurso");

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

        CuentaBancariaEntity cuentaEntity = logic.getCuentaBancaria(cuentaId);

        CuentaBancariaDTO cuentaDto = new CuentaBancariaDTO(cuentaEntity);

        if (cuentaEntity == null) {

            throw new WebApplicationException(RECURSO + cuentaId + NO_EXISTE, 404);

        }


        logic.delete(cuentaId);
    }
}

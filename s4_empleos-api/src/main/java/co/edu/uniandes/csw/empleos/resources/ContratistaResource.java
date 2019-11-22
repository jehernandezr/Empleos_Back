/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.ContratistaDTO;
import co.edu.uniandes.csw.empleos.dtos.ContratistaDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.ContratistaLogic;
import co.edu.uniandes.csw.empleos.ejb.ContratistaOfertasLogic;
import co.edu.uniandes.csw.empleos.ejb.TokenLogic;
import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
import co.edu.uniandes.csw.empleos.entities.TokenEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Juan Berdugo
 */
@Path("contratistas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ContratistaResource {

    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private ContratistaLogic contratistaLogic;

    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private ContratistaOfertasLogic contratistaOfertasLogic;

    @Inject
    private TokenLogic tokenLogic;

    @POST
    public ContratistaDTO createContratista(ContratistaDTO contratista) throws BusinessLogicException {
        ContratistaDTO contratistaFinal = new ContratistaDTO(contratistaLogic.createContratista(contratista.toEntity()));
        return contratistaFinal;
    }

    /**
     * Busca el contratista con el id asociado recibido en la URL y lo devuelve.
     *
     * @param contratistaId Identificador del contratista que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link ContratistaDTO} - El contratista buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el contratista.
     */
    @GET
    @Path("{id: \\d+}")
    public ContratistaDTO getContratista(@PathParam("id") Long contratistaId) throws BusinessLogicException {

        ContratistaEntity calEntity = contratistaLogic.getContratista(contratistaId);
        if (calEntity == null) {
            throw new WebApplicationException("El recurso /contratista/" + contratistaId + " no existe.", 404);
        }
        ContratistaDTO calDTO = new ContratistaDTO(calEntity);

        String token = calDTO.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok == null) {

            throw new BusinessLogicException("No se encuentra Registrado");
        }

        return calDTO;

    }

    /**
     * Actualiza el estudiante con el id recibido en la URL con la información
     * que se recibe en el cuerpo de la petición.
     *
     * @param calId Identificador del estudiante que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param calif {@link EstudianteDTO} El estudiante que se desea guardar.
     * @return JSON {@link EstudianteDTO} - El estudiante guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el estudiante a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al
     * estudiante.
     */
    @PUT
    @Path("{id: \\d+}")
    public ContratistaDetailDTO updateContratista(@PathParam("id") Long id, ContratistaDetailDTO contratista) throws BusinessLogicException {
        contratista.setId(id);
        String token = contratista.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok.getTipo().equals("Contratista")) {
            contratista.setId(id);
            if (contratistaLogic.getContratista(id) == null) {
                throw new WebApplicationException("El recurso /contratistas/" + id + " no existe.", 404);
            }
            ContratistaDetailDTO dto = new ContratistaDetailDTO(contratistaLogic.updateContratista(id, contratista.toEntity()));
            return dto;

        } else {
            throw new BusinessLogicException("No se le tiene permitido acceder a este recurso");
        }

    }

    /**
     * Borra el Estudiante con el id asociado recibido en la URL.
     *
     * @param calId Identificador del estudiante que se desea borrar. Este debe
     * ser una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra al estudiante.
     */
    @DELETE
    @Path("{id: \\d+}")
    public void deleteContratista(@PathParam("id") Long id) throws BusinessLogicException {

        ContratistaEntity contratistaEntity = contratistaLogic.getContratista(id);
        ContratistaDetailDTO estDTO = new ContratistaDetailDTO(contratistaEntity);

        if (contratistaLogic.getContratista(id) == null) {
            throw new WebApplicationException("El recurso contratista" + id + " no existe.", 404);
        }

        String token = estDTO.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok == null) {

            throw new BusinessLogicException("No se encuentra Registrado");
        }
        if (!(tok.getTipo().equals("Contratista") || tok.getTipo().equals("Administrador"))) {

            throw new BusinessLogicException("No tiene permiso para esto");
        }

        contratistaLogic.deleteContratista(id);

    }

}

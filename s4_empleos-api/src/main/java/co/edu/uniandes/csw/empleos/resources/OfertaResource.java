/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.OfertaDTO;
import co.edu.uniandes.csw.empleos.dtos.OfertaDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.OfertaLogic;

import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
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
 * @oferta Oferta
 */
@Path("ofertas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class OfertaResource {
    
   @Inject
    private OfertaLogic logic;
     private static final Logger LOGGER = Logger.getLogger(OfertaResource.class.getName());
     
    

    /**
     * Busca y devuelve todos los autores que existen en la aplicacion.
     *
     * @return JSONArray {@link OfertaDetailDTO} - Los autores encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<OfertaDetailDTO> getOfertas() {
        
        return listEntity2DTO(logic.getOfertas());
        
    }
    
    /**
     *
     * @param oferta
     *
     * @return
     * @throws BusinessLogicException
     */
    @POST
    public OfertaDTO crearOferta(OfertaDetailDTO oferta) throws BusinessLogicException {
        OfertaEntity ofertaEntity = oferta.toEntity();
        ofertaEntity = logic.createOferta(ofertaEntity);
        return new OfertaDetailDTO(ofertaEntity);
    }

    
    /**
     *
     * @param id
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public OfertaDetailDTO getOferta(@PathParam("id") Long idOferta) throws BusinessLogicException {
        OfertaEntity ofertaEntity = logic.getOferta(idOferta);
        if (ofertaEntity == null) {
            throw new WebApplicationException("El recurso /oferta/" + idOferta + " no existe.", 404);
        }
        OfertaDetailDTO cuentaDTO = new OfertaDetailDTO(ofertaEntity);
        return cuentaDTO;
    }
    
    /**
     * Actualiza el oferta con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param calId Identificador del oferta que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param calif {@link OfertaDTO} El oferta que se desea guardar.
     * @return JSON {@link OfertaDTO} - El oferta guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el oferta a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al oferta.
     */
    @PUT
    @Path("{act/ofertaId: \\d+}")
    public OfertaDetailDTO updateOferta(@PathParam("ofertaId") Long ofertaId, OfertaDetailDTO oferta) throws BusinessLogicException {
        oferta.setId(ofertaId);
        if (logic.getOferta(ofertaId) == null) {
            throw new WebApplicationException("El recurso /oferta/" + ofertaId + " no existe.", 404);
        }
        OfertaDetailDTO dto = new OfertaDetailDTO(logic.updateOferta(ofertaId,oferta.toEntity()));
        return dto;
    }
    
     /**
     * Borra el Oferta con el id asociado recibido en la URL.
     *
     * @param calId Identificador del oferta que se desea borrar. Este debe ser
     * una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra al oferta.
     */
    @DELETE
    @Path("del/{ofertaId: \\d+}")
    public void deleteOferta(@PathParam("ofertaId") Long ofertaId) throws BusinessLogicException {
        if (logic.getOferta(ofertaId) == null) {
            throw new WebApplicationException("El recurso /oferta/" + ofertaId + " no existe.", 404);
        }
         
        logic.deleteOferta(ofertaId);
    }
    
     /**
     * Convierte una lista de OfertaEntity a una lista de OfertaDetailDTO.
     *
     * @param entityList Lista de OfertaEntity a convertir.
     * @return Lista de OfertaDetailDTO convertida.
     */
    private List<OfertaDetailDTO> listEntity2DTO(List<OfertaEntity> entityList) {
        List<OfertaDetailDTO> list = new ArrayList<>();
        for (OfertaEntity entity : entityList) {
            list.add(new OfertaDetailDTO(entity));
        }
        return list;
    }
    
}

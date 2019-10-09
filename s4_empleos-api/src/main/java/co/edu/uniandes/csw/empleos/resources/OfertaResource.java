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
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @oferta Estudiante
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
    public List<OfertaDTO> getOfertas() {
        
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
    public OfertaDTO crearOferta(OfertaDTO oferta) throws BusinessLogicException {
        OfertaEntity ofertaEntity = oferta.toEntity();
        ofertaEntity = logic.createOferta(ofertaEntity);
        return new OfertaDTO(ofertaEntity);
    }

    
    /**
     *
     * @param id
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public OfertaDTO getCuntaBancaria(@PathParam("id") Long idOferta) throws BusinessLogicException {
        OfertaEntity ofertaEntity = logic.getOferta(idOferta);
        if (ofertaEntity == null) {
            throw new WebApplicationException("El recurso /oferta/" + idOferta + " no existe.", 404);
        }
        OfertaDTO cuentaDTO = new OfertaDTO(ofertaEntity);
        return cuentaDTO;
    }
    
     /**
     * Convierte una lista de OfertaEntity a una lista de OfertaDetailDTO.
     *
     * @param entityList Lista de OfertaEntity a convertir.
     * @return Lista de OfertaDetailDTO convertida.
     */
    private List<OfertaDTO> listEntity2DTO(List<OfertaEntity> entityList) {
        List<OfertaDTO> list = new ArrayList<>();
        for (OfertaEntity entity : entityList) {
            list.add(new OfertaDetailDTO(entity));
        }
        return list;
    }
    
}

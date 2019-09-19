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
import javax.ws.rs.Produces;

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
    private OfertaLogic ofertaLogic;
     private static final Logger LOGGER = Logger.getLogger(OfertaResource.class.getName());
     
     @POST
     public OfertaDTO crearOferta(OfertaDTO oferta) throws BusinessLogicException{
        LOGGER.log(Level.INFO, "OfertaResource createOferta: input: {0}", oferta);
        OfertaDTO ofertaDTO = new OfertaDTO(ofertaLogic.createOferta(oferta.toEntity()));
        LOGGER.log(Level.INFO, "OfertaResource createOferta: output: {0}", ofertaDTO);
        return ofertaDTO;
    }

    /**
     * Busca y devuelve todos los autores que existen en la aplicacion.
     *
     * @return JSONArray {@link OfertaDetailDTO} - Los autores encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<OfertaDetailDTO> getOfertas() {
        LOGGER.info("OfertaResource getOfertas: input: void");
        List<OfertaDetailDTO> listaOfertas = listEntity2DTO(ofertaLogic.getOfertas());
        LOGGER.log(Level.INFO, "OfertaResource getOfertas: output: {0}", listaOfertas);
        return listaOfertas;
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

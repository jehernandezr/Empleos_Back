/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;


import co.edu.uniandes.csw.empleos.dtos.ContratistaDTO;
import co.edu.uniandes.csw.empleos.ejb.ContratistaLogic;
import co.edu.uniandes.csw.empleos.ejb.ContratistaOfertasLogic;
import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
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
    
    @POST
    public ContratistaDTO createContratista(ContratistaDTO contratista) throws BusinessLogicException {
        ContratistaDTO contratistaFinal = new ContratistaDTO(contratistaLogic.createContratista(contratista.toEntity()));
        return contratistaFinal;
    }
    
    /**
     * Busca el contratista con el id asociado recibido en la URL y lo devuelve.
     *
     * @param contratistaId Identificador del contratista que se esta buscando. Este debe
     * ser una cadena de dígitos.
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
        return calDTO;
    }
    
    
   
    
}

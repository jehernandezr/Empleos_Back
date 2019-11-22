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
import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.DELETE;
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
    
    private static final  String NO_EXISTE = " no existe.";
    private static final  String RECURSO = "El recurso /contratista/";
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private ContratistaLogic contratistaLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private ContratistaOfertasLogic contratistaOfertasLogic; 
    
     @POST
    public ContratistaDTO createContratista(ContratistaDTO contratista) throws BusinessLogicException {

       return new ContratistaDTO(contratistaLogic.createContratista(contratista.toEntity()));
        
    }
    
     /**
     * Busca y devuelve todos los contratistas que existen en la aplicacion.
     *
     * @return JSONArray {@link ContratistaDTO} - Los contratistas
     * encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<ContratistaDetailDTO> getContratistas() {
       
        return listEntity2DTO(contratistaLogic.getContratistas());
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
    public ContratistaDetailDTO getContratista(@PathParam("id") Long contratistaId) throws BusinessLogicException {
        ContratistaEntity calEntity = contratistaLogic.getContratista(contratistaId);
        if (calEntity == null) {
            throw new WebApplicationException(RECURSO + contratistaId + NO_EXISTE, 404);
        }
        
        return new ContratistaDetailDTO(calEntity);
    }
    
     /**
     * Actualiza el contratista con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param calId Identificador del contratista que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param calif {@link ContratistaDTO} El contratista que se desea guardar.
     * @return JSON {@link ContratistaDTO} - El contratista guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el contratista a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al contratista.
     */
    @PUT
    @Path("{contratistaId: \\d+}")
    public ContratistaDetailDTO updateContratista(@PathParam("contratistaId") Long contratistaId, ContratistaDetailDTO contratista) throws BusinessLogicException {
        contratista.setId(contratistaId);
        if (contratistaLogic.getContratista(contratistaId) == null) {
            throw new WebApplicationException(RECURSO + contratistaId + NO_EXISTE, 404);
        }
        
        return new ContratistaDetailDTO(contratistaLogic.updateContratista(contratista.getId(),contratista.toEntity()));
    }
    
     /**
     * Borra el Contratista con el id asociado recibido en la URL.
     *
     * @param calId Identificador del contratista que se desea borrar. Este debe ser
     * una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra al contratista.
     */
    @DELETE
    @Path("{contratistaId: \\d+}")
    public void deleteContratista(@PathParam("contratistaId") Long contratistaId) throws BusinessLogicException {
        if (contratistaLogic.getContratista(contratistaId) == null) {
            throw new WebApplicationException(RECURSO + contratistaId + NO_EXISTE, 404);
        }
       
        contratistaLogic.deleteContratista(contratistaId);
    }
    
    
     /**
     * Convierte una lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos ContratistaEntity a una lista de
     * objetos ContratistaDTO (json)
     *
     * @param entityList corresponde a la lista de contratistas de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de contratistas en forma DTO (json)
     */
    private List<ContratistaDetailDTO> listEntity2DTO(List<ContratistaEntity> entityList) {
        List<ContratistaDetailDTO> list = new ArrayList<>();
        for (ContratistaEntity entity : entityList) 
            list.add(new ContratistaDetailDTO(entity));
        return list;
    }

    
   
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.TrabajoDTO;
import co.edu.uniandes.csw.empleos.dtos.TrabajoDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.TrabajoFacturaLogic;
import co.edu.uniandes.csw.empleos.ejb.TrabajoLogic;
import co.edu.uniandes.csw.empleos.ejb.TrabajoOfertaLogic;
import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
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
 * @author David Dominguez
 */
@Path("trabajos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TrabajoResource {

     
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private TrabajoLogic trabajoLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private TrabajoFacturaLogic trabajoFacturaLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private TrabajoOfertaLogic trabajoOfertaLogic; 
    
    
    @POST
    public TrabajoDTO createTrabajo(TrabajoDTO trabajo) throws BusinessLogicException {
        TrabajoDTO t = new TrabajoDTO(trabajoLogic.crearTrabajo(trabajo.toEntity()));
        return t;
    }
    
     /**
     * Busca el trabajo con el id asociado recibido en la URL y lo devuelve.
     *
     * @param trabajoId Identificador del trabajo que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link TrabajoDTO} - El trabajo buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el trabajo.
     */
    @GET
    @Path("{trabajoId: \\d+}")
    public TrabajoDetailDTO getTrabajo(@PathParam("trabajoId") Long trabajoId) {
        TrabajoEntity calEntity = trabajoLogic.getTrabajo(trabajoId);
        if (calEntity == null) {
            throw new WebApplicationException("El recurso /trabajo/" + trabajoId + " no existe.", 404);
        }
        TrabajoDetailDTO calDTO = new TrabajoDetailDTO(calEntity);
        return calDTO;
    }
    
    /**
     * Busca y devuelve todos los trabajos que existen en la aplicacion.
     *
     * @return JSONArray {@link TrabajoDTO} - Los trabajos
     * encontrados en la aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    public List<TrabajoDetailDTO> getTrabajos() {
        List<TrabajoDetailDTO> trabajos = listEntity2DTO(trabajoLogic.getTrabajos());
        return trabajos;
    }
    
     /**
     * Actualiza el trabajo con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param calId Identificador del trabajo que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param calif {@link EstudianteDTO} El trabajo que se desea guardar.
     * @return JSON {@link EstudianteDTO} - El trabajo guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el trabajo a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al trabajo.
     */
    @PUT
    @Path("{trabajoId: \\d+}")
    public TrabajoDetailDTO updateTrabajo(@PathParam("trabajoId") Long trabajoId, TrabajoDetailDTO trabajo) throws BusinessLogicException {
        trabajo.setId(trabajoId);
        if (trabajoLogic.getTrabajo(trabajoId) == null) {
            throw new WebApplicationException("El recurso /trabajo/" + trabajoId + " no existe.", 404);
        }
        TrabajoDetailDTO dto = new TrabajoDetailDTO(trabajoLogic.updateTrabajo(trabajo.toEntity()));
        return dto;
    }
    
     /**
     * Borra el Estudiante con el id asociado recibido en la URL.
     *
     * @param calId Identificador del estudiante que se desea borrar. Este debe ser
     * una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra al estudiante.
     */
    @DELETE
    @Path("{trabajoId: \\d+}")
    public void deleteTrabajo(@PathParam("trabajoId") Long trabajoId) throws BusinessLogicException {
        if (trabajoLogic.getTrabajo(trabajoId) == null) {
            throw new WebApplicationException("El recurso /trabajo/" + trabajoId + " no existe.", 404);
        }
        trabajoOfertaLogic.removeOferta(trabajoId);
        trabajoFacturaLogic.removeFactura(trabajoId);
        trabajoLogic.deleteTrabajo(trabajoId);
    }  
    
    /**
     * Convierte una lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos TrabajoEntity a una lista de
     * objetos TrabajoDTO (json)
     *
     * @param entityList corresponde a la lista de trabajos de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de trabajos en forma DTO (json)
     */
    private List<TrabajoDetailDTO> listEntity2DTO(List<TrabajoEntity> entityList) {
        List<TrabajoDetailDTO> list = new ArrayList<>();
        for (TrabajoEntity entity : entityList) 
            list.add(new TrabajoDetailDTO(entity));
        return list;
    }
}

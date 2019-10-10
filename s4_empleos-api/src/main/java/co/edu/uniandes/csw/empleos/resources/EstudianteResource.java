/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;


import co.edu.uniandes.csw.empleos.dtos.EstudianteDTO;
import co.edu.uniandes.csw.empleos.dtos.EstudianteDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.EstudianteCalificacionesLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteCuentaBancariaLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteOfertasLogic;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
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
@Path("estudiantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
<<<<<<< HEAD
class EstudianteResource {

=======

public class EstudianteResource {

>>>>>>> 626a73860495ef2aef6c2304297d2683724d2a6c

    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private EstudianteLogic estudianteLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private EstudianteCalificacionesLogic estudianteCalificacionesLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private EstudianteOfertasLogic estudianteOfertasLogic; 
    
    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private EstudianteCuentaBancariaLogic estudianteCuentaBancariaLogic; 
    
    @POST
    public EstudianteDTO createEstudiante(EstudianteDTO estudiante) throws BusinessLogicException {
        EstudianteDTO e = new EstudianteDTO(estudianteLogic.crearEstudiante(estudiante.toEntity()));
        return e;
    }
    
     /**
     * Busca el estudiante con el id asociado recibido en la URL y lo devuelve.
     *
     * @param estudianteId Identificador del estudiante que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link EstudianteDTO} - El estudiante buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el estudiante.
     */
    @GET
    @Path("{estudianteId: \\d+}")
    public EstudianteDetailDTO getEstudiante(@PathParam("estudianteId") Long estudianteId) {
        EstudianteEntity calEntity = estudianteLogic.getEstudiante(estudianteId);
        if (calEntity == null) {
            throw new WebApplicationException("El recurso /estudiante/" + estudianteId + " no existe.", 404);
        }
        EstudianteDetailDTO calDTO = new EstudianteDetailDTO(calEntity);
        return calDTO;
    }
    
    /**
     * Busca y devuelve todos los estudiantes que existen en la aplicacion.
     *
     * @return JSONArray {@link EstudianteDTO} - Los estudiantes
     * encontrados en la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    @GET
    public List<EstudianteDetailDTO> getEstudiantes() {
        List<EstudianteDetailDTO> estudiantes = listEntity2DTO(estudianteLogic.getEstudiantes());
        return estudiantes;
    }
    
     /**
     * Actualiza el estudiante con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param calId Identificador del estudiante que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param calif {@link EstudianteDTO} El estudiante que se desea guardar.
     * @return JSON {@link EstudianteDTO} - El estudiante guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el estudiante a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al estudiante.
     */
    @PUT
    @Path("{estudianteId: \\d+}")
    public EstudianteDetailDTO updateEstudiante(@PathParam("estudianteId") Long estudianteId, EstudianteDetailDTO estudiante) throws BusinessLogicException {
        estudiante.setId(estudianteId);
        if (estudianteLogic.getEstudiante(estudianteId) == null) {
            throw new WebApplicationException("El recurso /estudiante/" + estudianteId + " no existe.", 404);
        }
        EstudianteDetailDTO dto = new EstudianteDetailDTO(estudianteLogic.updateEstudiante(estudiante.toEntity()));
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
    @Path("{estudianteId: \\d+}")
    public void deleteEstudiante(@PathParam("estudianteId") Long estudianteId) throws BusinessLogicException {
        if (estudianteLogic.getEstudiante(estudianteId) == null) {
            throw new WebApplicationException("El recurso /estudiante/" + estudianteId + " no existe.", 404);
        }
        estudianteCalificacionesLogic.removeCalificaciones(estudianteId); 
        estudianteOfertasLogic.removeOfertas(estudianteId);
        estudianteCuentaBancariaLogic.removeCuentaBancaria(estudianteId); 
        estudianteLogic.deleteEstudiante(estudianteId);
    }
    
    /**
     * Convierte una lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos EstudianteEntity a una lista de
     * objetos EstudianteDTO (json)
     *
     * @param entityList corresponde a la lista de estudiantes de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de estudiantes en forma DTO (json)
     */
    private List<EstudianteDetailDTO> listEntity2DTO(List<EstudianteEntity> entityList) {
        List<EstudianteDetailDTO> list = new ArrayList<>();
        for (EstudianteEntity entity : entityList) 
            list.add(new EstudianteDetailDTO(entity));
        return list;
    }

}

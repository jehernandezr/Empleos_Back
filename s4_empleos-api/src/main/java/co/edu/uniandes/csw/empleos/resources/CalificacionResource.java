/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CalificacionDTO;
import co.edu.uniandes.csw.empleos.ejb.CalificacionEstudianteLogic;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.ejb.CalificacionLogic;
import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import java.util.ArrayList;
import java.util.List;
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
 * @author Nicolas Munar */
@Path("calificaciones")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CalificacionResource {
    private static final Logger LOOGER =Logger.getLogger(CalificacionResource.class.getName());
    
    
    @Inject
    private CalificacionLogic calificacionLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    @Inject
    private CalificacionEstudianteLogic calificacionEstudianteLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    

    
    @POST
    public CalificacionDTO createCalificacion(CalificacionDTO calificacion) throws BusinessLogicException {
        CalificacionDTO nuevaCalificacionDTO = new CalificacionDTO(calificacionLogic.createCalificacion(calificacion.toEntity()));
        return nuevaCalificacionDTO;
    }
    
    
    /**
     * Busca la calificaciòn con el id asociado recibido en la URL y lo devuelve.
     *
     * @param calificacionId Identificador del libro que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link BookDTO} - El libro buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el libro.
     */
    @GET
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO getCalificacion(@PathParam("calificacionesId") Long calificacionId) {
        CalificacionEntity calEntity = calificacionLogic.getCalificacion(calificacionId);
        if (calEntity == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + calificacionId + " no existe.", 404);
        }
        CalificacionDTO calDTO = new CalificacionDTO(calEntity);
        return calDTO;
    }
    
     /**
     * Actualiza la calificacion con el id recibido en la URL con la información que se
     * recibe en el cuerpo de la petición.
     *
     * @param calId Identificador de la Calificacion que se desea actualizar. Este debe
     * ser una cadena de dígitos.
     * @param calif {@link CalificacionDTO} La Calificacion que se desea guardar.
     * @return JSON {@link CalificacionDTO} - La Calificacion guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la Calificacion a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar la Calificacion.
     */
    @PUT
    @Path("{calificacionesId: \\d+}")
    public CalificacionDTO updateCalificacion(@PathParam("calificacionesId") Long calId, CalificacionDTO calif) throws BusinessLogicException {
        calif.setId(calId);
        if (calificacionLogic.getCalificacion(calId) == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + calId + " no existe.", 404);
        }
        CalificacionDTO detailDTO = new CalificacionDTO(calificacionLogic.updateCalificacion(calId, calif.toEntity()));
        return detailDTO;
    }
    
     /**
     * Borra La Calificacion con el id asociado recibido en la URL.
     *
     * @param calId Identificador del La Calificacion que se desea borrar. Este debe ser
     * una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra La Calificacion.
     */
    @DELETE
    @Path("{calificacionesId: \\d+}")
    public void deleteCalificacion (@PathParam("calificacionesId") Long calId) throws BusinessLogicException {
        CalificacionEntity entity = calificacionLogic.getCalificacion(calId);
        if (entity == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + calId + " no existe.", 404);
        }
        calificacionEstudianteLogic.removeEstudiante(calId);
        calificacionLogic.deleteCalificacion(calId);
        }
    
    /**
     * Conexión con el servicio de reseñas para una Calificacion. {@link ReviewResource}
     *
     * Este método conecta la ruta de /calificaciones con las rutas de /estudiantes que
     * dependen del libro, es una redirección al servicio que maneja el segmento
     * de la URL que se encarga de las reseñas.
     *
     * @param calId El ID de la Calificacion  con respecto al cual se accede al
     * servicio.
     * @return El servicio de Estudiantes para esa Calificacion en paricular.\
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la Calificacion .
     */
    @GET
    @Path("{calificacionesId: \\d+}/estudiantes")
    public Class<EstudianteResource> getEstudianteResource(@PathParam("calificacionesId") Long calId) {
        if (calificacionLogic.getCalificacion(calId) == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + calId + "/estudiantes no existe.", 404);
        }
        return EstudianteResource.class;
    }
    
        /**
     * Conexión con el servicio de estudiantes para una calificacion.
     * {@link CalificacionEstudiantesResource}
     *
     * Este método conecta la ruta de /calificaciones con las rutas de /estudiantes que
     * dependen de la calificacion.
     *
     * @param calId El ID de la calificacion con respecto al cual se accede al
     * servicio.
     * @return El servicio de autores para esa calificacion en paricular.\
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la calificacion.
     */
    @Path("{calificacionesId: \\d+}/estudiantes")
    public Class<CalificacionEstudianteResource> getCalificacionEstudianteResource(@PathParam("calificacionesId") Long calId) {
        if (calificacionLogic.getCalificacion(calId) == null) {
            throw new WebApplicationException("El recurso /calificaciones/" + calId + " no existe.", 404);
        }
        return CalificacionEstudianteResource.class;
    }
    
        /**
     * Convierte una lista de entidades a DTO.
     *
     * Este método convierte una lista de objetos BookEntity a una lista de
     * objetos BookDetailDTO (json)
     *
     * @param entityList corresponde a la lista de libros de tipo Entity que
     * vamos a convertir a DTO.
     * @return la lista de libros en forma DTO (json)
     */
    private List<CalificacionDTO> listEntity2DTO(List<CalificacionEntity> entityList) {
        List<CalificacionDTO> list = new ArrayList<>();
        for (CalificacionEntity entity : entityList) {
            list.add(new CalificacionDTO(entity));
        }
        return list;
    }
    
}

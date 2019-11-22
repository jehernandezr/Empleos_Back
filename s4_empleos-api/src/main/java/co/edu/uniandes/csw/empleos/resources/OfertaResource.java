/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.OfertaDTO;
import co.edu.uniandes.csw.empleos.dtos.OfertaDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.OfertaEstudianteLogic;
import co.edu.uniandes.csw.empleos.ejb.OfertaLogic;
import co.edu.uniandes.csw.empleos.ejb.TokenLogic;
import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import co.edu.uniandes.csw.empleos.entities.TokenEntity;
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
 * @oferta Oferta
 */
@Path("ofertas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class OfertaResource {

    private static final String NO_EXISTE = " no existe.";
    private static final String RECURSO = "El recurso /oferta/";

    @Inject
    private OfertaLogic logic;

    @Inject
    private TokenLogic tokenLogic;

    @Inject
    private OfertaEstudianteLogic estudianteOfertasLogic;

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
     * Busca y devuelve todos los autores que existen en la aplicacion.
     *
     * @param palabra
     * @return JSONArray {@link OfertaDetailDTO} - Los autores encontrados en la
     * aplicación. Si no hay ninguno retorna una lista vacía.
     */
    @GET
    @Path("{palabra}")
    public List<OfertaDetailDTO> getOfertasPalabraClave(@PathParam("palabra") String palabra) {

        return listEntity2DTO(logic.getOfertasPalabraClave(palabra.toLowerCase()));

    }

    /**
     *
     * @param oferta
     *
     * @return
     * @throws BusinessLogicException
     */
    public OfertaDTO crearOferta(OfertaDetailDTO oferta) throws BusinessLogicException {
        String token = oferta.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok.getTipo().equals("Contratista")) {

            OfertaEntity ofertaEntity = oferta.toEntity();
            ofertaEntity = logic.createOferta(ofertaEntity);
            return new OfertaDetailDTO(ofertaEntity);

        } else {
            throw new BusinessLogicException("No se le tiene permitido acceder a este recurso");
        }

    }

    /**
     *
     * @param idOferta
     * @return
     * @throws BusinessLogicException
     */
    @GET
    @Path("{id: \\d+}")
    public OfertaDetailDTO getOferta(@PathParam("id") Long idOferta) throws BusinessLogicException {

        OfertaEntity ofertaEntity = logic.getOferta(idOferta);
        if (ofertaEntity == null) {
            throw new WebApplicationException(RECURSO + idOferta + NO_EXISTE, 404);
        }

        return new OfertaDetailDTO(ofertaEntity);

    }

    /**
     * Conexión con el servicio de libros para una editorial.
     * {@link EstudiantesOfertaResource}
     *
     * Este método conecta la ruta de /editorials con las rutas de /books que
     * dependen de la editorial, es una redirección al servicio que maneja el
     * segmento de la URL que se encarga de los libros de una editorial.
     *
     * @param editorialsId El ID de la editorial con respecto a la cual se
     * accede al servicio.
     * @return El servicio de libros para esta editorial en paricular.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la editorial.
     */
    @Path("{ofertaId: \\d+}/estudiantes")
    public Class<EstudiantesOfertaResource> getEstudiantesOfertaResource(@PathParam("ofertaId") Long editorialsId) {
        if (estudianteOfertasLogic.getEstudiantes(editorialsId) == null) {
            throw new WebApplicationException(RECURSO + editorialsId + NO_EXISTE, 404);
        }
        return EstudiantesOfertaResource.class;
    }

    /**
     * Actualiza el oferta con el id recibido en la URL con la información que
     * se recibe en el cuerpo de la petición.
     *
     * @param ofertaId Identificador del oferta que se desea actualizar. Este
     * debe ser una cadena de dígitos.
     * @param oferta {@link OfertaDTO} El oferta que se desea guardar.
     * @return JSON {@link OfertaDTO} - El oferta guardada.
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el oferta a
     * actualizar.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando no se puede actualizar al oferta.
     */
    @PUT
    @Path("{id: \\d+}")
    public OfertaDetailDTO updateOferta(@PathParam("id") Long ofertaId, OfertaDetailDTO oferta) throws BusinessLogicException {

        String token = oferta.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok.getTipo().equals("Contratista")) {
            oferta.setId(ofertaId);
            if (logic.getOferta(ofertaId) == null) {
                throw new WebApplicationException(RECURSO + ofertaId + NO_EXISTE, 404);
            }

            OfertaDetailDTO dto = new OfertaDetailDTO(logic.updateOferta(ofertaId, oferta.toEntity()));
            return dto;

        } else {
            throw new BusinessLogicException("No se le tiene permitido acceder a este recurso");
        }

    }

    /**
     * Borra el Oferta con el id asociado recibido en la URL.
     *
     * @param ofertaId Identificador del oferta que se desea borrar. Este debe
     * ser una cadena de dígitos
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra al oferta.
     */
    @DELETE
    @Path("{ofertaId: \\d+}")
    public void deleteOferta(@PathParam("ofertaId") Long ofertaId) throws BusinessLogicException {

        OfertaEntity calEntity = logic.getOferta(ofertaId);
        OfertaDTO calDTO = new OfertaDTO(calEntity);
        if (logic.getOferta(ofertaId) == null) {
            throw new WebApplicationException(RECURSO + ofertaId + NO_EXISTE, 404);
        }

        String token = calDTO.getToken();
        TokenEntity tok = tokenLogic.getTokenByToken(token);
        if (tok == null) {

            throw new BusinessLogicException("No se encuentra Registrado");
        }
        if (tok.getTipo().equals("Enstutdiante")) {

            throw new BusinessLogicException("No tiene permiso para esto");
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

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CredencialDTO;
import co.edu.uniandes.csw.empleos.dtos.EstudianteDTO;
import co.edu.uniandes.csw.empleos.dtos.EstudianteDetailDTO;
import co.edu.uniandes.csw.empleos.dtos.TokenDTO;
import co.edu.uniandes.csw.empleos.ejb.CredencialesLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteCalificacionesLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteCuentaBancariaLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteLogic;
import co.edu.uniandes.csw.empleos.ejb.EstudianteOfertasLogic;
import co.edu.uniandes.csw.empleos.ejb.TokenLogic;
import co.edu.uniandes.csw.empleos.ejb.Tokenizer;
import co.edu.uniandes.csw.empleos.entities.CredencialesEntity;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
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
import javax.ws.rs.QueryParam;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author David Dominguez
 */
@Path("credenciales")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CredencialesResource {

    // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    @Inject
    private CredencialesLogic credencialLogic;

    @Inject
    private TokenLogic tokenLogic;

    @POST
    public TokenDTO createCredencial(CredencialDTO credencial) throws BusinessLogicException {
        CredencialDTO c = new CredencialDTO(credencialLogic.createCredencial(credencial.toEntity()));

        String tipo = c.getTipo();
        String token = Tokenizer.getToken();

        TokenEntity tokenE = new TokenEntity();
        tokenE.setTipo(tipo);
        tokenE.setToken(token);
        TokenDTO nuevoTokenDTO = new TokenDTO(tokenLogic.createToken(tokenE));

        return nuevoTokenDTO;
    }

    @GET
    public TokenDTO autenticar(@QueryParam("correo") String correo, @QueryParam("pass") String pass) throws BusinessLogicException {
        List<CredencialesEntity> c = credencialLogic.getCredenciales();
        CredencialesEntity credencialUsuario = null;
        boolean found = false;
        for (CredencialesEntity credencial : c) {
            if (credencial.getCorreo().equals(correo) && credencial.getContrasena().equals(pass)) {
                found = true;
                credencialUsuario = credencial;
            }
        }
        if (!found) {
            return null;
        } else {
            String tipo = credencialUsuario.getTipo();
            String token = Tokenizer.getToken();

            TokenEntity tokenE = new TokenEntity();
            tokenE.setTipo(tipo);
            tokenE.setToken(token);
            TokenDTO nuevoTokenDTO = new TokenDTO(tokenLogic.createToken(tokenE));
 
            return nuevoTokenDTO;
        }
    }

    /**
     * Busca el estudiante con el id asociado recibido en la URL y lo devuelve.
     *
     * @param estudianteId Identificador del estudiante que se esta buscando.
     * Este debe ser una cadena de dígitos.
     * @return JSON {@link EstudianteDTO} - El estudiante buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra el estudiante.
     */
    /*
    @GET
    @Path("{estudiantesId: \\d+}")
    public EstudianteDetailDTO getEstudiante(@PathParam("estudiantesId") Long estudianteId) {
        EstudianteEntity calEntity = estudianteLogic.getEstudiante(estudianteId);
        if (calEntity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + estudianteId + " no existe.", 404);
        }
        EstudianteDetailDTO calDTO = new EstudianteDetailDTO(calEntity);
        return calDTO;
    }
     */
    /**
     * Busca y devuelve todos los estudiantes que existen en la aplicacion.
     *
     * @return JSONArray {@link EstudianteDTO} - Los estudiantes encontrados en
     * la aplicación. Si no hay ninguna retorna una lista vacía.
     */
    /*
    @GET
    public List<EstudianteDetailDTO> getEstudiantes() {
        List<EstudianteDetailDTO> estudiantes = listEntity2DTO(estudianteLogic.getEstudiantes());
        return estudiantes;
    }
     */
}

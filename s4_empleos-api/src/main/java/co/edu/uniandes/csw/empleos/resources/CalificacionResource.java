/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CalificacionDTO;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.logic.CalificacionLogic;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    

    
    @POST
    public CalificacionDTO createCalificacion(CalificacionDTO calificacion) throws BusinessLogicException {
        
        CalificacionDTO nuevaCalificacionDTO = new CalificacionDTO(calificacionLogic.createCalificacion(calificacion.toEntity()));
        return nuevaCalificacionDTO;
    }
}

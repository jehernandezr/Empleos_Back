/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.TrabajoDTO;
import co.edu.uniandes.csw.empleos.ejb.TrabajoLogic;
import co.edu.uniandes.csw.empleos.entities.TrabajoEntity;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

/**
 *
 * @author David Dominguez
 */
@Path("trabajos")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class TrabajoResource {

    private static final Logger LOOGER = Logger.getLogger(TrabajoResource.class.getName());
    
    @Inject
    private TrabajoLogic trabajoLogic;

    @POST
    public TrabajoDTO createTrabajo(TrabajoDTO trabajo) {
        TrabajoDTO nuevaCalificacionDTO = new TrabajoDTO(trabajoLogic.crearTrabajo(trabajo.toEntity()));
        return nuevaCalificacionDTO;
    }
    
    
    
    @GET
    @Path("getAll")
    public List<TrabajoDTO> getAllTrabajos() {
        ArrayList<TrabajoDTO> trabajos = new ArrayList<>();
        for(TrabajoEntity e : trabajoLogic.getTrabajos()) {
            trabajos.add(new TrabajoDTO(e));
            System.out.println(e);
        }
        return trabajos;
    }
    
    @GET
    @Path("id/{id: \\d+}")
    public TrabajoDTO getTrabajo(@PathParam("id") Long id) {
        TrabajoEntity e = trabajoLogic.getTrabajo(id);
        return new TrabajoDTO(e);
    }
}

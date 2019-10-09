/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;


import co.edu.uniandes.csw.empleos.dtos.EstudianteDTO;
import co.edu.uniandes.csw.empleos.ejb.EstudianteLogic;
import co.edu.uniandes.csw.empleos.entities.EstudianteEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;


/**
 *
 * @author ... 
 */
@Path("estudiantes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
class EstudianteResource {
    
    @Inject
    private EstudianteLogic estudianteLogic;
    
    
     /**
     * Busca la tarjeta con el id asociado recibido en la URL y lo devuelve.
     *
     * @param tarjetaId Identificador de la tarjeta que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link TarjetaDeCreditoDTO} - El libro buscado
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra la tarjeta.
     */
    @GET
    @Path("{estudiantesId: \\d+}")
    public EstudianteDTO getTarjeta(@PathParam("estudiantesId") Long estudianteId) throws BusinessLogicException 
    {
        
        EstudianteEntity entity = estudianteLogic.getEstudiante(estudianteId);
        
        if (entity == null) {
            throw new WebApplicationException("El recurso /estudiantes/" + estudianteId + "no existe.", 404);
        }
        
        EstudianteDTO estudianteDTO = new EstudianteDTO(entity);
        
        return estudianteDTO;
    }
    

}

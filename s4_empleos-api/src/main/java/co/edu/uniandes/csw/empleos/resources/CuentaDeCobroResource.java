package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CuentaDeCobroDTO;
import co.edu.uniandes.csw.empleos.ejb.CuentaDeCobroLogic;
import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import java.util.logging.Logger;
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
 * @author Santiago Tangarife Rincón
 */
@Path("cuentasDeCobro")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class CuentaDeCobroResource {
   
    private static final Logger LOGGER =Logger.getLogger(CuentaDeCobroResource.class.getName());
    
    @Inject
    private CuentaDeCobroLogic cuentaDeCobroLogic;
    
    @POST
    public CuentaDeCobroDTO createCuentaDeCobro(CuentaDeCobroDTO cuenta) {
        return cuenta;
    }
    
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
    @Path("{cuentasId: \\d+}")
    public CuentaDeCobroDTO getCuentaDeCobro(@PathParam("cuentasId") Long cuentaId) throws BusinessLogicException 
    {
        
        CuentaDeCobroEntity entity = cuentaDeCobroLogic.getCuenta(cuentaId);
        
        if (entity == null) {
            throw new WebApplicationException("El recurso /cuentas/" + cuentaId + "no existe.", 404);
        }
        
        CuentaDeCobroDTO cuentaDTO = new CuentaDeCobroDTO(entity);
        
        return cuentaDTO;
    }
    
}

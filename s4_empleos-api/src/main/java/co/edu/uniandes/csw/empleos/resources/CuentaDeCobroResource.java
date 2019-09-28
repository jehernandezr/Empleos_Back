package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CuentaDeCobroDTO;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

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
    
    @POST
    public CuentaDeCobroDTO createCuentaDeCobro(CuentaDeCobroDTO cuenta) {
        return cuenta;
    }
    
}

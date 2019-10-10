package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.CuentaDeCobroDTO;
import co.edu.uniandes.csw.empleos.dtos.CuentaDeCobroDetailDTO;
import co.edu.uniandes.csw.empleos.ejb.ContratistaLogic;
import co.edu.uniandes.csw.empleos.ejb.CuentaDeCobroContratistaLogic;
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
    
     @Inject
    private ContratistaLogic editorialLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    @Inject
    private CuentaDeCobroContratistaLogic bookEditorialLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.

    
     /**
     * Crea una nueva cuenta con la informacion que se recibe en el cuerpo de la
     * petición y se regresa un objeto identico con un id auto-generado por la
     * base de datos.
     *
     * @param cuenta {@link CuentaDeCobroDTO} - La cuenta que se desea guardar.
     * @return JSON {@link CuentaDeCobroDTO} - La cuenta guardado con el atributo id
     * autogenerado.
     * @throws BusinessLogicException {@link BusinessLogicExceptionMapper} -
     * Error de lógica que se genera cuando rompe con las reglas de negocio.
     */
    @POST
    public CuentaDeCobroDTO createCuentaDeCobro(CuentaDeCobroDTO cuenta) throws BusinessLogicException {
        CuentaDeCobroDTO  nuevaCuentaDTO = new CuentaDeCobroDTO(cuentaDeCobroLogic.createCuentaDeCobro(cuenta.toEntity()));
        return nuevaCuentaDTO;
    }
    
    /**
     * Busca la cuenta con el id asociado recibido en la URL y lo devuelve.
     *
     * @param cuentaId Identificador de la cuenta que se esta buscando. Este debe
     * ser una cadena de dígitos.
     * @return JSON {@link CuentaDeCobroDetailDTO} - la cuenta buscada
     * @throws WebApplicationException {@link WebApplicationExceptionMapper} -
     * Error de lógica que se genera cuando no se encuentra La cuenta.
     */
    @GET
    @Path("{cuentasId: \\d+}")
    public CuentaDeCobroDTO getCuentaDeCobro(@PathParam("cuentasId") Long cuentaId) {
        
        CuentaDeCobroEntity cuentaEntity = cuentaDeCobroLogic.getCuenta(cuentaId);
        if (cuentaEntity == null) {
            throw new WebApplicationException("El recurso /books/" + cuentaId + " no existe.", 404);
        }
        CuentaDeCobroDTO cuentaDTO = new CuentaDeCobroDTO(cuentaEntity);
        
        return cuentaDTO;
    }
    
}

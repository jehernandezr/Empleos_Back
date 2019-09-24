/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.resources;

import co.edu.uniandes.csw.empleos.dtos.FacturaDTO;
import co.edu.uniandes.csw.empleos.ejb.FacturaLogic;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import java.util.logging.Logger;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

/**
 *
 * @author Nicolas Munar
 */
@Path("facturas")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class FacturaResource {
    private static final Logger LOOGER =Logger.getLogger(FacturaResource.class.getName());
    
    @Inject
    private FacturaLogic facturaLogic; // Variable para acceder a la lógica de la aplicación. Es una inyección de dependencias.
    
    
    @POST
    public FacturaDTO createFactura(FacturaDTO factura) throws BusinessLogicException    {
        FacturaDTO nuevaFacturaDTO = new FacturaDTO(facturaLogic.createFactura(factura.toEntity()));
        return nuevaFacturaDTO;
    }
}

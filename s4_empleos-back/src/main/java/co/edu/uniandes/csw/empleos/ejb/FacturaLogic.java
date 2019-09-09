/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.FacturaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.FacturaPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolas Munar
 */
@Stateless
public class FacturaLogic {
    
    @Inject
    private FacturaPersistence persistence;
    
    
    public FacturaEntity createFactura(FacturaEntity factura) throws BusinessLogicException{
        
        
        if(factura.getValor()<0)
        {
            throw new BusinessLogicException ("El valor de la factura no puede tener valores negativos");
        }
        if(factura.getFecha()==null)
        {
            throw new BusinessLogicException("La fecha no puede ser una valor nulo");
        }

        factura = persistence.create(factura);
        return factura;
    }
    
}

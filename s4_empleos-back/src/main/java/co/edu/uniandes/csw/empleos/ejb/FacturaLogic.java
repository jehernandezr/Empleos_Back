/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.FacturaEntity;
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
    
    
    public FacturaEntity createFactura(FacturaEntity factura){
        factura = persistence.create(factura);
        return factura;
    }
    
}

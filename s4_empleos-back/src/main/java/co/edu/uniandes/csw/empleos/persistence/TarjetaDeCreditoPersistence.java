/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.TarjetaDeCreditoEntity;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Miguel Angel Ramos Hurtado
 */
@Stateless
public class TarjetaDeCreditoPersistence {
    
    @PersistenceContext(unitName="empleosPU")
    protected EntityManager em;
    
    public TarjetaDeCreditoEntity create (TarjetaDeCreditoEntity tarjeta)
    {
        throw new java.lang.UnsupportedOperationException("Not suported yet.");
    }
}

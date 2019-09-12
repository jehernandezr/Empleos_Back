/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.TarjetaDeCreditoEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.TarjetaDeCreditoPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Miguel Angel Ramos Hurtado
 */
@Stateless
public class TarjetaDeCreditoLogic {

    @Inject
    private TarjetaDeCreditoPersistence persistence;

    public TarjetaDeCreditoEntity createTarjetaDeCredito(TarjetaDeCreditoEntity tarjetaCredito) throws BusinessLogicException {
        if (tarjetaCredito.getNumero() == null) {
            throw new BusinessLogicException("El número de la tarjeta de crédito no puede ser vacío.");
        }

        tarjetaCredito = persistence.create(tarjetaCredito);
        return tarjetaCredito;
    }

}

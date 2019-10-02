/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaDeCobroPersistence;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Santiago Tangarife Rincón
 */
@Stateless
public class CuentaDeCobroLogic {

    @Inject
    private CuentaDeCobroPersistence persistencia;

    public CuentaDeCobroEntity createCuentaDeCobro(CuentaDeCobroEntity cuentaDeCobro) throws BusinessLogicException {
        if (cuentaDeCobro != null) {
            if (cuentaDeCobro.getContratista() == null)
                throw new BusinessLogicException("La cuenta de cobro no tiene contratista.");
            if(cuentaDeCobro.getConcepto()==null||cuentaDeCobro.getConcepto().equals(""))
                throw new BusinessLogicException("La cuenta de cobro no tiene concepto.");
            if(cuentaDeCobro.getFecha()==null)
                throw new BusinessLogicException("La cuenta de cobro no tiene fecha.");
            if(cuentaDeCobro.getNombreEstudiante()==null||cuentaDeCobro.getNombreEstudiante().equals(""))
                throw new BusinessLogicException("La cuenta de cobro no tiene la información del estudiante.");
            if(cuentaDeCobro.getNumeroCuentaDeCobro()<=0)
                throw new BusinessLogicException("La cuenta de cobro no tiene número o tiene un número erroneo.");
            if(cuentaDeCobro.getValor()<=0)
                throw new BusinessLogicException("La cuenta de cobro no tiene valor o tiene un valor erroneo.");
            else {
                CuentaDeCobroEntity cuenta = persistencia.create(cuentaDeCobro);
                return cuenta;
            }
        } else {
            throw new BusinessLogicException("La cuenta de cobro es nula.");
        }
    }
    
}

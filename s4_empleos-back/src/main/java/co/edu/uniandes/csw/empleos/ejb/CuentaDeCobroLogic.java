/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaDeCobroPersistence;
import static com.sun.xml.internal.ws.spi.db.BindingContextFactory.LOGGER;
import java.util.logging.Level;
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
    
   /**
     * Busca una cuenta por ID
     *
     * @param cuentaId El id de la cuenta a buscar
     * @return La cuenta encontrada, null si no la encuentra.
     */
    public CuentaDeCobroEntity getCuenta(Long cuentaId) {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar la cuenta de cobro con id = {0}", cuentaId);
        CuentaDeCobroEntity cuentaEntity = persistencia.find(cuentaId);
        if (cuentaEntity == null) {
            LOGGER.log(Level.SEVERE, "La cuenta con el id = {0} no existe", cuentaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar la cuenta con id = {0}", cuentaId);
        return cuentaEntity;
    } 
}

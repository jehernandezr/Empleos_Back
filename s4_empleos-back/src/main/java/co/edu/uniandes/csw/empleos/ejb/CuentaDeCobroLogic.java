/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CalificacionEntity;
import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaDeCobroPersistence;
import java.util.List;
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
    private CuentaDeCobroPersistence persistence;
    
    public List<CuentaDeCobroEntity> getCuentasDeCobro;

    public CuentaDeCobroEntity createCuentaDeCobro(CuentaDeCobroEntity cuentaDeCobro) throws BusinessLogicException {
        if (cuentaDeCobro != null) {
            if (cuentaDeCobro.getContratista() == null) {
                throw new BusinessLogicException("La cuenta de cobro no tiene contratista.");
            }
            if (cuentaDeCobro.getConcepto() == null || cuentaDeCobro.getConcepto().equals("")) {
                throw new BusinessLogicException("La cuenta de cobro no tiene concepto.");
            }
            if (cuentaDeCobro.getFecha() == null) {
                throw new BusinessLogicException("La cuenta de cobro no tiene fecha.");
            }
            if (cuentaDeCobro.getNombreEstudiante() == null || cuentaDeCobro.getNombreEstudiante().equals("")) {
                throw new BusinessLogicException("La cuenta de cobro no tiene la información del estudiante.");
            }
            if (cuentaDeCobro.getNumeroCuentaDeCobro() <= 0) {
                throw new BusinessLogicException("La cuenta de cobro no tiene número o tiene un número erroneo.");
            }
            if (cuentaDeCobro.getValor() <= 0) {
                throw new BusinessLogicException("La cuenta de cobro no tiene valor o tiene un valor erroneo.");
            } else {
                CuentaDeCobroEntity cuenta = persistence.create(cuentaDeCobro);
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
        CuentaDeCobroEntity cuentaEntity = persistence.find(cuentaId);
        if (cuentaEntity == null) {
        }
        return cuentaEntity;
    }

    /**
     * Devuelve todas las calificaciones que hay en la base de datos.
     *
     * @return Lista de las entidades del tipo calificacion.
     */
    public List<CuentaDeCobroEntity> getCuentasDeCobro() {
        List<CuentaDeCobroEntity> cuentas = persistence.findAll();
        return cuentas;
    }

    /**
     * Actualizar una calificacion por ID
     *
     * @param cuentaId El ID de la calificacion a actualizar
     * @param cuentaDeCobroEntity La entidad de la Calificacion con los cambios
     * deseados
     * @return La entidad de la calificacion luego de actualizarla
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     */
    public CuentaDeCobroEntity updateCuentaDeCobro(Long cuentaId, CuentaDeCobroEntity cuentaEntity) throws BusinessLogicException {

        if (cuentaEntity != null) {
            if (cuentaEntity.getContratista() == null) {
                throw new BusinessLogicException("La cuenta de cobro no tiene contratista.");
            }
            if (cuentaEntity.getNumeroCuentaDeCobro() <= 0) {
                throw new BusinessLogicException("La cuenta de cobro no tiene número o tiene un número erroneo.");
            }
            if (cuentaEntity.getFecha() == null) {
                throw new BusinessLogicException("La cuenta de cobro no tiene fecha.");
            }
            if (cuentaEntity.getConcepto() == null || cuentaEntity.getConcepto().equals("")) {
                throw new BusinessLogicException("La cuenta de cobro no tiene concepto.");
            }
            if (cuentaEntity.getNombreEstudiante() == null || cuentaEntity.getNombreEstudiante().equals("")) {
                throw new BusinessLogicException("La cuenta de cobro no tiene la información del estudiante.");
            }
            if (cuentaEntity.getValor() <= 0) {
                throw new BusinessLogicException("La cuenta de cobro no tiene valor o tiene un valor erroneo.");
            } else {
                CuentaDeCobroEntity cuenta = persistence.update(cuentaEntity);
                return cuenta;
            }
        } else {
            throw new BusinessLogicException("La cuenta de cobro es nula.");
        }

    }

    /**
     * Eliminar una calificacion por Id
     *
     * @param calificacionId El ID de la calificacion a borrar.
     */
    public void deleteCuentaDeCobro(Long cuentaId) {
        persistence.delete(cuentaId);
    }

}

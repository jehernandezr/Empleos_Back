package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import java.io.Serializable;

/**
 *
 * @author Santiago Tangarife Rincón
 */
public class CuentaDeCobroDetailDTO extends CuentaDeCobroDTO implements Serializable{
     
    /**
     * Constructor para transformar un Entity a un DTO
     *
     * @param entity La entidad de la cual se construye el DTO
     */
    public CuentaDeCobroDetailDTO(CuentaDeCobroEntity entity) {
        super(entity);
    }
    
    /**
     * Transformar el DTO a una entidad
     *
     * @return La entidad que representa el libro.
     */
    @Override
    public CuentaDeCobroEntity toEntity() {
        CuentaDeCobroEntity cuentaEntity = super.toEntity();
        return cuentaEntity;
    }

}

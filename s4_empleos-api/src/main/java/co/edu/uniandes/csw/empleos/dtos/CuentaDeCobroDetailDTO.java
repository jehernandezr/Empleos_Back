package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import java.io.Serializable;

/**
 *
 * @author Santiago Tangarife Rincón
 */
public class CuentaDeCobroDetailDTO extends CuentaDeCobroDTO implements Serializable {

    /**
     * Contratista de la cuenta de cobro
     */
    private ContratistaDTO contratista;

    public CuentaDeCobroDetailDTO(CuentaDeCobroEntity entity) {
        super(entity);
    }

    /**
     * Constructor
     */
    public void CuentaDeCobroDetailDTO() {
        //Vacio
    }
}
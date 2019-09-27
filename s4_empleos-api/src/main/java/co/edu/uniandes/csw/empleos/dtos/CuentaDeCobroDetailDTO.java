package co.edu.uniandes.csw.empleos.dtos;

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

    /**
     * Constructor
     */
    public void CuentaDeCobroDetailDTO() {
        //Vacio
    }
}

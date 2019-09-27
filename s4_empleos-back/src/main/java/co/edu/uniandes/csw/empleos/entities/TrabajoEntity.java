package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Esta clase modela la entidad de trabajo, que será guardada en la base de datos.
 * @author David Dominguez
 */
@Entity
public class TrabajoEntity extends BaseEntity implements Serializable {
    
    //Atributo que representa si un trabajo ya fue terminado
    private boolean cumplido;
    //Atributo que representa si un trabajo ya ha sido "aprobado" por el contratista
    private boolean verificado;

    @PodamExclude
    @OneToOne
    private FacturaEntity factura;   
   
    @PodamExclude
    @ManyToOne(fetch = FetchType.LAZY)
    private OfertaEntity oferta;
    
    //Constructor vacío.
    public TrabajoEntity() {
        //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
    }

    /**
     * @return the cumplido
     */
    public boolean isCumplido() {
        return cumplido;
    }

    /**
     * @param cumplido the cumplido to set
     */
    public void setCumplido(boolean cumplido) {
        this.cumplido = cumplido;
    }

    /**
     * @return the verificado
     */
    public boolean isVerificado() {
        return verificado;
    }

    /**
     * @param verificado the verificado to set
     */
    public void setVerificado(boolean verificado) {
        this.verificado = verificado;
    }

    /**
     * @return the factura
     */
    public FacturaEntity getFactura() {
        return factura;
    }

    /**
     * @param factura the factura to set
     */
    public void setFactura(FacturaEntity factura) {
        this.factura = factura;
    }

    /**
     * @return the oferta
     */
    public OfertaEntity getOferta() {
        return oferta;
    }

    /**
     * @param oferta the oferta to set
     */
    public void setOferta(OfertaEntity oferta) {
        this.oferta = oferta;
    }
    
}
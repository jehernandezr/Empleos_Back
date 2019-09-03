package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

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
    
}

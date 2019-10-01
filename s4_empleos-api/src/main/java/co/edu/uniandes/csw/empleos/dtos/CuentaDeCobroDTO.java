package co.edu.uniandes.csw.empleos.dtos;

import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Santiago Tangarife Rincón
 */
public class CuentaDeCobroDTO implements Serializable {

    /**
     * id de la cuenta de cobro
     */
    private Long id;

    /**
     * número de la cuenta de cobro
     */
    private int numeroCuentaDeCobro;

    /**
     * fecha de la cuenta de cobro
     */
    private Date fecha;

    /**
     * Valor que se debe.
     */
    private int valor;

    /**
     * Nombre del nombreEstudiante a quien se le debe el valor
     */
    private String nombreEstudiante;

    /**
     * Concepto
     */
    private String concepto;

    /**
     * Constructor vacio
     */
    public void CuentaDeCobroDTO()
    {
        //Vacio
    }
    //--------------------------------------------------------------------------------------------
    //Getters && Setters
    //Mira que titulo más cool xd
    //--------------------------------------------------------------------------------------------
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public int getNumeroCuentaDeCobro() {
        return numeroCuentaDeCobro;
    }

    public void setNumeroCuentaDeCobro(int numeroCuentaDeCobro) {
        this.numeroCuentaDeCobro = numeroCuentaDeCobro;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public int getValor() {
        return valor;
    }

    public void setValor(int valor) {
        this.valor = valor;
    }

    public String getNombreEstudiante() {
        return nombreEstudiante;
    }

    public void setNombreEstudiante(String nombreEstudiante) {
        this.nombreEstudiante = nombreEstudiante;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }
}

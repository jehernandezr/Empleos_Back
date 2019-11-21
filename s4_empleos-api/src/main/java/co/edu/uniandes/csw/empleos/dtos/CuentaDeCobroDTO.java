package co.edu.uniandes.csw.empleos.dtos;
import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import java.io.Serializable;
import java.util.Date;

/**
 *
 * @author Jonatan Hernandez
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
 * la asociacion con contratista
 */
    private ContratistaDTO contratistaDTO;
    
     /**
     * Token que definirá el inicio de sesión
     */
    private String token;
    
    /**
     * Constructor vacio
     */
    public CuentaDeCobroDTO()
    {
        //Vacio
    }
    
    public CuentaDeCobroDTO(CuentaDeCobroEntity entity )
    {
        if(entity != null)
        {
           this.id = entity.getId(); 
           this.concepto = entity.getConcepto(); 
           this.fecha = entity.getFecha(); 
           this.nombreEstudiante = entity.getNombreEstudiante(); 
           this.numeroCuentaDeCobro = entity.getNumeroCuentaDeCobro(); 
           this.valor = entity.getValor(); 
           this.token = null;
      if(entity.getContratista()!=null)
      {
          contratistaDTO= new ContratistaDTO(entity.getContratista());
      }
        }
    }
    
    /**
     * Convertir DTO a Entity
     *
     * @return Un Entity con los valores del DTO
     */
    public CuentaDeCobroEntity toEntity() {
    
        CuentaDeCobroEntity cuentaDeCobroEntity = new CuentaDeCobroEntity();
        cuentaDeCobroEntity.setId(this.id);
        cuentaDeCobroEntity.setConcepto(this.concepto);
        cuentaDeCobroEntity.setNumeroCuentaDeCobro(this.numeroCuentaDeCobro);
        cuentaDeCobroEntity.setFecha(this.fecha);
        cuentaDeCobroEntity.setNombreEstudiante(this.nombreEstudiante);
        cuentaDeCobroEntity.setValor(this.valor);
        cuentaDeCobroEntity.setContratista(this.contratistaDTO.toEntity());

        return cuentaDeCobroEntity;
    }
    
    //--------------------------------------------------------------------------------------------
    //Getters && Setters
    
    //--------------------------------------------------------------------------------------------
    public String getToken() {
        return token;
    }
    
    public void setToken(String id) {
        this.token = id;
    }
    
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

    /**
     * @return the contratistaDTO
     */
    public ContratistaDTO getContratistaDTO() {
        return contratistaDTO;
    }

    /**
     * @param contratistaDTO the contratistaDTO to set
     */
    public void setContratistaDTO(ContratistaDTO contratistaDTO) {
        this.contratistaDTO = contratistaDTO;
    }
}
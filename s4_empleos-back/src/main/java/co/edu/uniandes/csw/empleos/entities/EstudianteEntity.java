package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Entity;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 * Esta clase modela la entidad Estudiante.
 * @author David Dominguez
 */
@Entity
public class EstudianteEntity extends BaseEntity implements Serializable  {
    
    // Atributo que representa el nombre del estudiante
    private String nombre;
    // Atributo que representa el ID del medio de pago del estudiante
    private long idMedioDepago;
    // Atributo que representa la carrera que el estudiante cursa
    private String carrera;
    // Atributo que representa el correo del estudiante
    private String correo;
    // Atributo que representa la calificación promedio del estudiante en lso trabajos que ha hecho
    private double calificacionPromedio;
    // Atributo que representa el horario de trabajo disponible del estudiante
    private String horarioDeTrabajo;
    // Atributo que representa el semestre que cursa el estudiante
    private int semestre;
    
    
    
    

    // Atributo que representa las ofertas a las que ha aplicado el estudiante 
    @PodamExclude
    @javax.persistence.ManyToMany(
       
        fetch = javax.persistence.FetchType.LAZY
    )
    Collection<OfertaEntity> ofertas;

    // Atributo que representa las calificaciones que tiene el estudiante 
    @javax.persistence.OneToMany(
         mappedBy = "estudiante",
        fetch = javax.persistence.FetchType.LAZY
    )
    Collection<CalificacionEntity> calificaciones;

    // Atributo que representa la cuenta bancaria que tiene el estudiante
    @PodamExclude
    @OneToOne
    private CuentaBancariaEntity cuentaBancaria; 

    // Constructor vacío
    public EstudianteEntity () {
        //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
    }

    /**
     * @return el nombre
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * @param name the name to set
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * @return the idMedioDepago
     */
    public long getIdMedioDepago() {
        return idMedioDepago;
    }

    /**
     * @param idMedioDepago the idMedioDepago to set
     */
    public void setIdMedioDepago(long idMedioDepago) {
        this.idMedioDepago = idMedioDepago;
    }

    /**
     * @return the carrera
     */
    public String getCarrera() {
        return carrera;
    }

    /**
     * @param carrera the carrera to set
     */
    public void setCarrera(String carrera) {
        this.carrera = carrera;
    }

    /**
     * @return the correo
     */
    public String getCorreo() {
        return correo;
    }

    /**
     * @param correo the correo to set
     */
    public void setCorreo(String correo) {
        this.correo = correo;
    }

    /**
     * @return the calificacionPromedio
     */
    public double getCalificacionPromedio() {
        return calificacionPromedio;
    }

    /**
     * @param calificacionPromedio the calificacionPromedio to set
     */
    public void setCalificacionPromedio(double calificacionPromedio) {
        this.calificacionPromedio = calificacionPromedio;
    }

    /**
     * @return the horarioDeTrabajo
     */
    public String getHorarioDeTrabajo() {
        return horarioDeTrabajo;
    }

    /**
     * @param horarioDeTrabajo the horarioDeTrabajo to set
     */
    public void setHorarioDeTrabajo(String horarioDeTrabajo) {
        this.horarioDeTrabajo = horarioDeTrabajo;
    }

    /**
     * @return the semestre
     */
    public int getSemestre() {
        return semestre;
    }

    /**
     * @param semestre the semestre to set
     */
    public void setSemestre(int semestre) {
        this.semestre = semestre;
    }

    /**
     * @return the ofertas
     */
    public Collection<OfertaEntity> getOfertas() {
        return ofertas;
    }

    /**
     * @param ofertas the ofertas to set
     */
    public void setOfertas(Collection<OfertaEntity> ofertas) {
        this.ofertas = ofertas;
    }

    /**
     * @return the calificaciones
     */
    public Collection<CalificacionEntity> getCalificaciones() {
        return calificaciones;
    }

    /**
     * @param calificaciones the calificaciones to set
     */
    public void setCalificaciones(Collection<CalificacionEntity> calificaciones) {
        this.calificaciones = calificaciones;
    }

    /**
     * @return the cuentaBancaria
     */
    public CuentaBancariaEntity getCuentaBancaria() {
        return cuentaBancaria;
    }

    /**
     * @param cuentaBancaria the cuentaBancaria to set
     */
    public void setCuentaBancaria(CuentaBancariaEntity cuentaBancaria) {
        this.cuentaBancaria = cuentaBancaria;
    }
    
}
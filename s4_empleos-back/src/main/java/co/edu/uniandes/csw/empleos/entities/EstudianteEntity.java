package co.edu.uniandes.csw.empleos.entities;

import java.io.Serializable;
import javax.persistence.Entity;

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
    
    // Constructor vacío
    public EstudianteEntity () {}

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
    
}


package co.edu.uniandes.csw.empleos.entities;

import javax.persistence.Entity;

/**
 *Clase que representa una oferta para poder ser guardado en la base de datos.
 * @author je.berdugo10
 */
@Entity
public class OfertaEntity extends BaseEntity{
    
    /**
     * Variable que representa el tipo de oferta (Normal o Express).
     */
    private int tipoOferta;
    
    /**
     * Variable que representa sel numero de vacantes de una oferta.
     * numeroDeVacantes>1
     */
    private int numeroDeVacantes;
    
    /**
     * Variable que representa el pago por hora de la oferta.
     */
    private Double pagoPorHora;
    
    /**
     * Variable que representa el nombre de la oferta.
     */
    private String nombre;
    
    /**
     * Variable que representa la descripcion de la oferta.
     */
    private String descripcion;
    
    /**
     * Variable que representa a categoria de empleo de la oferta.
     */
    private String categoria;
    
     /**
     * Variable que representa el tiempo maximo de aplicacion de una oferta Express.
     */
    private int tiempoMaximoAplicacion;
    
    /**
     * Variable que representa el porcentaje de pago extra de una oferta Express.
     */
    private int porcentajePagoAdicional;
    
    /**
     * Variable que si una oferta esta abierta al publico.
     * 
     */
    private boolean estaAbierta;
    
    /**
     * Variable que representa los requisitos de un aplicante (Separados por un guion (-)).
     * 
     */
    private String requisitos;
    
    /**
     * Variable que representa los horarios de trabajo.
     * Franjas DDS:HH:MM-DDS:HH:MM donde DDS es el dia de la semana:
     * LUN-lunes
     * MAR-martes
     * MIE-miercoles
     * JUE-jueves
     * VIE-viernes
     */
    private String horario;
    
    /**
     * Variable que representa las horas totales de trabajo, calculadas con el horario.
     * 
     */
    private Double horasDeTrabajo;
    
    /**
     * Variable que representa la ruta de la imagen principal de la oferta.
     * 
     */
    private String rutaImagen;
    
    
     /**
     * Constructor de la oferta
     */
    public OfertaEntity(){
        
    }
    
    /**
     * Devuelve el tipoDeOferta del contratista.
     * @return 1 si es NORMAL o 2 si es EXPRESS
     */
    public int getTipoOferta() {
        return tipoOferta;
    }

    /**
     * Actualiza lel tipo de la oferta.
     * @param tipoOferta ruta de la imagen a modificar
     */
    public void setTipoOferta(int tipoOferta) {
        this.tipoOferta = tipoOferta;
    }

    /**
     * Devuelve numero de vacantes disponibles en el momento.
     * @return el numero de vanates disponibles.
     */
    public int getNumeroDeVacantes() {
        return numeroDeVacantes;
    }

    /**
     * Actualiza el numero de vacantes de la oferta.
     * @param rutaImagen ruta de la imagen a modificar
     */
    public void setNumeroDeVacantes(int numeroDeVacantes) {
        this.numeroDeVacantes = numeroDeVacantes;
    }

    /**
     * Devuelve el pago por hora en pesos de la oferta.
     * @return el pago por hora de la oferta.
     */
    public Double getPagoPorHora() {
        return pagoPorHora;
    }

    /**
     * Actualiza el pago por hora de la oferta.
     * @param rutaImagen ruta de la imagen a modificar
     */
    public void setPagoPorHora(Double pagoPorHora) {
        this.pagoPorHora = pagoPorHora;
    }

    /**
     * Devuelve el nombre de la oferta.
     * @return true si el contratista es externo y false si es interno.
     */
    public String getNombre() {
        return nombre;
    }

    /**
     * Actualiza el nombre de la oferta.
     * @param nombre ruta de la imagen a modificar
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    /**
     * Devuelve la descripcion de la oferta.
     * @return la descripcion de la oferta.
     */
    public String getDescripcion() {
        return descripcion;
    }

    /**
     * Actualiza la descripcion de la oferta.
     * @param descripcion ruta de la imagen a modificar
     */
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    /**
     * Devuelve la categoria de la oferta.
     * @return la categoria de la oferta.
     */
    public String getCategoria() {
        return categoria;
    }

    /**
     * Actualiza la categoria de la oferta.
     * @param categoria ruta de la imagen a modificar
     */
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    /**
     * Devuelve el tiempo maximo de aplicacion de una oferta Express.
     * @return el tiempo maximo de aplicacion de una oferta Express.
     */
    public int getTiempoMaximoAplicacion() {
        return tiempoMaximoAplicacion;
    }

    /**
     * Actualiza el tiempo maximo de aplicacion de una oferta Express.
     * @param tiempoMaximoAplicacion el tiempo maximo de aplicacion de una oferta Express.
     */
    public void setTiempoMaximoAplicacion(int tiempoMaximoAplicacion) {
        this.tiempoMaximoAplicacion = tiempoMaximoAplicacion;
    }

    /**
     * Devuelve el porcentaje de pago adicional de una oferta Express.
     * @return el tiempo maximo de aplicacion de una oferta Express.
     */
    public int getPorcentajePagoAdicional() {
        return porcentajePagoAdicional;
    }

    /**
     * Actualiza el porcentaje de pago adicional de una oferta Express.
     * @param porcentajePagoAdicional el porcentaje de pago adicional de una oferta Express.
     */
    public void setPorcentajePagoAdicional(int porcentajePagoAdicional) {
        this.porcentajePagoAdicional = porcentajePagoAdicional;
    }

     /**
     * Devuelve el estado de una oferta.
     * @return estado de la oferta.
     */
    public boolean getEstaAbierta() {
        return estaAbierta;
    }
    
   /**
     * Actualiza el estado de una oferta.
     * @param estaAbierta estado a modificar
     */
    public void setEstaAbierta(boolean estaAbierta) {
        this.estaAbierta = estaAbierta;
    }

    /**
     * Devuelve los requisitos de una oferta.
     * @return requisitos de la oferta.
     */
    public String getRequisitos() {
        return requisitos;
    }

    /**
     * Actualiza los requisitos de una oferta.
     * @param requisitos  a modificar
     */
    public void setRequisitos(String requisitos) {
        this.requisitos = requisitos;
    }

    /**
     * Devuelve el horario de una oferta.
     * @return horario de la oferta.
     */
    public String getHorario() {
        return horario;
    }

    /**
     * Actualiza el horario de una oferta.
     * @param horario  a modificar
     */
    public void setHorario(String horario) {
        this.horario = horario;
    }

    /**
     * Devuelve el numero de horas de trabajo de una oferta.
     * @return estado de la oferta.
     */
    public Double getHorasDeTrabajo() {
        return horasDeTrabajo;
    }

    /**
     * Actualiza las horas de trabajo de la oferta.
     * @param horasDeTrabajo horas de trabajo a modificar
     */
    public void setHorasDeTrabajo(Double horasDeTrabajo) {
        this.horasDeTrabajo = horasDeTrabajo;
    }

    /**
     * Obtener la ruta de la imagen de la oferta.
     * @return ruta de la imagen del contratista
     */
    public String getRutaImagen() {
        return rutaImagen;
    }

    /**
     * Actualiza la ruta de la imagen dela oferta.
     * @param rutaImagen ruta de la imagen a modificar
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
    
    
}

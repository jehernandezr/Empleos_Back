/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.entities;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import uk.co.jemos.podam.common.PodamExclude;

/**
 *Clase que representa un contratista para poder ser guardado en la base de datos.
 * @author je.berdugo10
 */
@Entity
public class ContratistaEntity extends BaseEntity {
    
    /**
     * Variable que representa si el contratista es externo.
     */
    private boolean esExterno;
    
    /**
     * Variable que representa el nombre del contratista.
     */
    private String nombre;
    
    /**
     * Variable que representa el nombre del contratista.
     */
    private String email;
    
    
    
    /**
     * Variable que representa la contraseña del contratista.
     */
    private String contrasena;
    
     /**
     * Variable que representa la ruta de la imagen del contratista.
     */
    private String rutaImagen;

    @PodamExclude
    @OneToOne(fetch = FetchType.LAZY)
    private TarjetaDeCreditoEntity tarjetaCredito; 

    

   
    /**
     * Constructor del contratista
     */
    public ContratistaEntity(){
        //Constructor vacío para evitar fallos en compilacion. Se asignan valores a los parámetros a través de los metodos set
    }
    
      
   /**
     * Devuelve el nombre del contratista.
     * @return true si el contratista es externo y false si es interno.
     */
   public String getNombre(){
       return nombre;
   }
   
   /**
     * Actualiza el nombre del contratista.
     * @param nombre del contratista.
     */
   public void setNombre(String nombre){
       this.nombre=nombre;
   }
  
    /**
     * Devuelve si el contratista es externo.
     * @return true si el contratista es externo y false si es interno.
     */
   public boolean getEsExterno(){
       return esExterno;
   }
   
    /**
     * Actualiza el estado del contratista.
     * @param esExterno true si el contratista es externo y false si es interno.
     */
   public void setEsExterno(boolean esExterno){
       this.esExterno=esExterno;
   }
   
    /**
     * Obetener el email del contratista.
     * @return email del contratista
     */
    public String getEmail() {
        return email;
    }

    /**
     * Actualiza el email del contratista.
     * @param email a modificar
     */
    public void setEmail(String email) {
        this.email = email;
    }
    /**
     * Obetener la contraseña del contratista.
     * @return contraseña del contratista
     */    
    public String getContrasena() {
        return contrasena;
    }

    /**
     * Actualiza la contraseña del contratista.
     * @param contrasena a modificar
     */
    public void setContrasena(String contrasena) {
        this.contrasena = contrasena;
    }
    
     /**
     * Obtener la ruta de la imagen del contratista.
     * @return ruta de la imagen del contratista
     */ 
     public String getRutaImagen() {
        return rutaImagen;
    }

     /**
     * Actualiza la ruta de la imagen del contratista.
     * @param rutaImagen a modificar
     */
    public void setRutaImagen(String rutaImagen) {
        this.rutaImagen = rutaImagen;
    }
    
   
    
}

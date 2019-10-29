/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.dtos;

import co.edu.uniandes.csw.empleos.entities.OfertaEntity;
import java.io.Serializable;
import java.util.List;

/**
 *
 * @author Estudiante
 * 
 * 
{
   "tipoOferta": number  ,
   "numeroDeVacantes":  string ,
   "pagoPorHora": number   ,
   "nombre":   string  ,
   "descripcion":   string  ,
   "categoria":   string  ,
   "tiempoMaximoAplicacion":   number  ,
   "porcentajePagoAdicional":  number  ,
   "estaAbierta":   boolean    ,
   "requisitos":  string    ,
   "horario":  string  ,
   "horasDeTrabajo":  number ,
   "rutaImagen": string,
   "trabajo": {
   },
   "estudiantes":{
   
    }
   
}
 */
public class OfertaDetailDTO extends OfertaDTO implements Serializable {
    
    private TrabajoDTO trabajo;
    
    private List<EstudianteDetailDTO> estudiantes;
    
    
    
    public OfertaDetailDTO(){
        
    }

    public OfertaDetailDTO(OfertaEntity entity) {
       super(entity);
    }
    
    
    
    
}

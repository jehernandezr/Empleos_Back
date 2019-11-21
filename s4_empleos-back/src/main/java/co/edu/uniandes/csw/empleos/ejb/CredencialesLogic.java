/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CredencialesEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CredencialesPersistence;

import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.hernandezr
 */
@Stateless
public class CredencialesLogic {
    
     @Inject
    private CredencialesPersistence persistence;
    
       /**
     * Guarda una token
     * @param credencial la entidad de tipo Token a persistir
     * @return entidad luego de persistirla
     * @throws BusinessLogicException Si alguna regla de negocio se rompe.
     */
    public CredencialesEntity createCredencial(CredencialesEntity  credencial) throws BusinessLogicException{
       if(credencial!=null){
           
           if(credencial.getTipo()==null){
            throw new BusinessLogicException("El campo no puede ser nulo");
        }
        if(credencial.getCorreo()==null){
            throw new BusinessLogicException("El campo no puede ser nulo");
        
        }
        if(credencial.getTipo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        if(credencial.getCorreo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        
                credencial = persistence.create(credencial);

       }
       
        return credencial;
    }
    
        /**
     * Devuelve todas las token que hay en la base de datos.
     * @return  Lista de las entidades del tipo token.
     */
    public List<CredencialesEntity> getCredenciales()
    {
       List<CredencialesEntity> token= persistence.findAll();
       return token;
    }
    
        /**
     * Busca Una calificacion por ID
     * @param tokenId El id de la token a buscar.
     * @return La token encontrada, null si no se encuentra.
     */
    public CredencialesEntity getCredencial(Long tokenId)
    {
        CredencialesEntity credencialEntity = persistence.find(tokenId);
        
        return  credencialEntity;
    }
    
         /**
     * Actualizar una calificacion por ID
     *
     * @param credencialId El ID de la calificacion a actualizar
     * @param credencialEntity La entidad de la Calificacion con los cambios deseados
     * @return La entidad de la calificacion luego de actualizarla
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     */
    public CredencialesEntity updateCredencial(Long credencialId, CredencialesEntity credencialEntity)throws BusinessLogicException {
        
        
        if(credencialEntity.getTipo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        if(credencialEntity.getCorreo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        
        CredencialesEntity newEntity = persistence.update(credencialEntity);
        return newEntity;
    }
     
}

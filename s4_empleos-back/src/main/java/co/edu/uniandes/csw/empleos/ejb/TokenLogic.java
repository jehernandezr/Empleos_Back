/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.TokenEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.TokenPersistence;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Nicolás Munar
 */
@Stateless
public class TokenLogic {
    
     @Inject
    private TokenPersistence persistence;
    
       /**
     * Guarda una token
     * @param token la entidad de tipo Token a persistir
     * @return entidad luego de persistirla
     * @throws BusinessLogicException Si alguna regla de negocio se rompe.
     */
    public TokenEntity createToken(TokenEntity token) throws BusinessLogicException{
       if(token!=null){
           
           if(token.getTipo()==null){
            throw new BusinessLogicException("El campo no puede ser nulo");
        }
        if(token.getToken()==null){
            throw new BusinessLogicException("El campo no puede ser nulo");
        
        }
        if(token.getTipo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        if(token.getToken().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        
                token = persistence.create(token);

       }
       
        return token;
    }
    
        /**
     * Devuelve todas las token que hay en la base de datos.
     * @return  Lista de las entidades del tipo token.
     */
    public List<TokenEntity> getTokens()
    {
       List<TokenEntity> token= persistence.findAll();
       return token;
    }
    
        /**
     * Busca Una calificacion por ID
     * @param tokenId El id de la token a buscar.
     * @return La token encontrada, null si no se encuentra.
     */
    public TokenEntity getToken(Long tokenId)
    {
        TokenEntity tokenEntity = persistence.find(tokenId);
        
        return  tokenEntity;
    }
    
         /**
     * Actualizar una calificacion por ID
     *
     * @param tokenId El ID de la calificacion a actualizar
     * @param tokenEntity La entidad de la Calificacion con los cambios deseados
     * @return La entidad de la calificacion luego de actualizarla
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException
     */
    public TokenEntity updateToken(Long tokenId, TokenEntity tokenEntity)throws BusinessLogicException {
        
        
        if(tokenEntity.getTipo().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        if(tokenEntity.getToken().equals("")){
            throw new BusinessLogicException("El campo no puede ser vacìo");
        }
        
        TokenEntity newEntity = persistence.update(tokenEntity);
        return newEntity;
    }
     
}

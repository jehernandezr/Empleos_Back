/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.ContratistaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author Estudiante
 */
public class ContratistaLogic {
    
     private static final Logger LOGGER = Logger.getLogger(ContratistaLogic.class.getName());

    @Inject
    private ContratistaPersistence persistence;

    /**
     * Se encarga de crear un Contratista en la base de datos.
     *
     * @param contratistaEntity Objeto de ContratistaEntity con los datos nuevos
     * @return Objeto de ContratistaEntity con los datos nuevos y su ID.
     */
    public ContratistaEntity createContratista(ContratistaEntity contratistaEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de creación del autor");
        ContratistaEntity newContratistaEntity = persistence.create(contratistaEntity);
        LOGGER.log(Level.INFO, "Termina proceso de creación del autor");
        return newContratistaEntity;
    }

    /**
     * Obtiene la lista de los registros de Author.
     *
     * @return Colección de objetos de AuthorEntity.
     */
    public List<ContratistaEntity> getAuthors() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los autores");
        List<ContratistaEntity> lista = persistence.findAll();
        LOGGER.log(Level.INFO, "Termina proceso de consultar todos los autores");
        return lista;
    }

    /**
     * Obtiene los datos de una instancia de Contratista a partir de su ID.
     *
     * @param contratistaId Identificador de la instancia a consultar
     * @return Instancia de ContratistaEntity con los datos del Author consultado.
     * @throws co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException 
     */
    public ContratistaEntity getContratista(Long contratistaId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el contratista con id = {0}", contratistaId);
        ContratistaEntity contratistaEntity = persistence.find(contratistaId);
        if (contratistaEntity == null) {
            throw new BusinessLogicException("No existe el contratista con el id "+contratistaId);
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el autor con id = {0}", contratistaId);
        return contratistaEntity;
    }

}

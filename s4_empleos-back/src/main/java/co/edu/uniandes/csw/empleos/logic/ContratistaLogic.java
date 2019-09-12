/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.ContratistaEntity;
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
     */
    public ContratistaEntity getContratista(Long contratistaId) throws BussinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar el contratista con id = {0}", contratistaId);
        ContratistaEntity contratistaEntity = persistence.find(contratistaId);
        if (contratistaEntity == null) {
            
        }
        LOGGER.log(Level.INFO, "Termina proceso de consultar el autor con id = {0}", contratistaId);
        return contratistaEntity;
    }

    /**
     * Actualiza la información de una instancia de Author.
     *
     * @param authorsId Identificador de la instancia a actualizar
     * @param authorEntity Instancia de AuthorEntity con los nuevos datos.
     * @return Instancia de AuthorEntity con los datos actualizados.
     */
    public AuthorEntity updateAuthor(Long authorsId, AuthorEntity authorEntity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar el autor con id = {0}", authorsId);
        AuthorEntity newAuthorEntity = persistence.update(authorEntity);
        LOGGER.log(Level.INFO, "Termina proceso de actualizar el autor con id = {0}", authorsId);
        return newAuthorEntity;
    }

    /**
     * Elimina una instancia de Author de la base de datos.
     *
     * @param authorsId Identificador de la instancia a eliminar.
     * @throws BusinessLogicException si el autor tiene libros asociados.
     */
    public void deleteAuthor(Long authorsId) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de borrar el autor con id = {0}", authorsId);
        List<BookEntity> books = getAuthor(authorsId).getBooks();
        if (books != null && !books.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el autor con id = " + authorsId + " porque tiene books asociados");
        }
        List<PrizeEntity> prizes = getAuthor(authorsId).getPrizes();
        if (prizes != null && !prizes.isEmpty()) {
            throw new BusinessLogicException("No se puede borrar el autor con id = " + authorsId + " porque tiene premios asociados");
        }
        persistence.delete(authorsId);
        LOGGER.log(Level.INFO, "Termina proceso de borrar el autor con id = {0}", authorsId);
    }
    
}

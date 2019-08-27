/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;

import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author je.hernandezr
 */
@Stateless
public class CuentaBancariaPersistance {

    @PersistenceContext(unitName = "empleosPU")
    protected EntityManager em;
   

     /**
     * Busca si hay alguna cuentaBancaria con el id que se envía de argumento
     *
     * @param id: id correspondiente al premio buscado.
     * @return un cuenta bancaria.
     */
    public CuentaBancariaEntity find(Long id) {
        
        return em.find(CuentaBancariaEntity.class,id);
    }
    
     /**
     * Devuelve todas las cuentas Bancarias de la base de datos.
     *
     * @return una lista con todos las cuentas bancarias que encuentre en la base de
     * datos, "select u from PrizeEntity u" es como un "select * from
     * PrizeEntity;" - "SELECT * FROM table_name" en SQL.
     */
    public List<CuentaBancariaEntity> findAll() {
        
        Query q = em.createQuery("select u from CuentaBancariaEntity u");
        return q.getResultList();
    }

    /**
     * Método para persisitir la entidad en la base de datos.
     *
     * @param cuentaBancaria objeto cuentaBancaria que se creará en la base de datos
     * @return devuelve la entidad creada con un id dado por la base de datos.
     */
    public CuentaBancariaEntity create(CuentaBancariaEntity cuentaBancaria) {
      
        em.persist(cuentaBancaria);
        
        return cuentaBancaria;
    }

    /**
     * Actualiza una cuenta Bancaria.
     *
     * @param cuentaBancaria: la cuentaBancaria que viene con los nuevos cambios. Por
     * ejemplo el nombre pudo cambiar. En ese caso, se haria uso del método
     * update.
     * @return una CuentaBancariaEntity con los cambios aplicados.
     */
    public CuentaBancariaEntity update(CuentaBancariaEntity cuentaBancaria) {

        return em.merge(cuentaBancaria);
    }

    /**
     *
     * Borra  una cuenta bancaria de la base de datos recibiendo como argumento el id del
     * premio
     *
     * @param id: id correspondiente a la cuentaBancaria a borrar.
     */
    public void delete(Long id) {
        CuentaBancariaEntity entity = em.find(CuentaBancariaEntity.class, id);
        em.remove(entity);
    }
    
}

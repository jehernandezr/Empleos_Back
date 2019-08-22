/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import co.edu.uniandes.csw.empleos.entities.CuentaDeCobroEntity;
import java.util.List;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

/**
 *
 * @author Santiago Tangarife
 */
@Stateless
public class CuentaDeCobroPersistence {

    @PersistenceContext(unitName = "empleosPU")
    protected EntityManager em;

    public CuentaDeCobroEntity create(CuentaDeCobroEntity cuentaDeCobroEntity) {
        em.persist(cuentaDeCobroEntity);
        return cuentaDeCobroEntity;
    }

    public CuentaDeCobroEntity find(Long cuentaDeCobroId) {
        return em.find(CuentaDeCobroEntity.class, cuentaDeCobroId);
    }

    public List<CuentaDeCobroEntity> findAll() {
        TypedQuery<CuentaDeCobroEntity> query = em.createQuery("select u from CuentaDeCobroEntity u", CuentaDeCobroEntity.class);
        return query.getResultList();
    }
    
}

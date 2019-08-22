/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.persistence;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Santiago Tangarife
 */
@Stateless
public class CuentaDeCobroPersistence 
{
@PersistenceContext(unitName ="empleosPU")
protected EntityManager em;

}

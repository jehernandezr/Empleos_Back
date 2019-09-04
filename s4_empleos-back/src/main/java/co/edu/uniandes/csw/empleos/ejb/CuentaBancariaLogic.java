/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import co.edu.uniandes.csw.empleos.entities.CuentaBancariaEntity;
import co.edu.uniandes.csw.empleos.exceptions.BusinessLogicException;
import co.edu.uniandes.csw.empleos.persistence.CuentaBancariaPersistance;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author je.hernandezr
 */
@Stateless


public class CuentaBancariaLogic {
    
   @Inject
    private CuentaBancariaPersistance persistance;
   
   
   public CuentaBancariaEntity createCuentaBancaria(CuentaBancariaEntity cuentaBancaria)throws BusinessLogicException
  {
   {
       if(cuentaBancaria.getNumeroCuenta()==0)
      {
          throw new BusinessLogicException("el numero de cuenta está vacio");
      }
       cuentaBancaria=persistance.create(cuentaBancaria);
       return cuentaBancaria;
   }
  
      
  }
}

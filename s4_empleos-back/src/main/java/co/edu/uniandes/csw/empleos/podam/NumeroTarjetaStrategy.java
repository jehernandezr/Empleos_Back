/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.podam;

import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 *
 * @author Miguel Angel Ramos Hurtado
 */
public class NumeroTarjetaStrategy implements AttributeStrategy<String>
{
    @Override
    public String getValue()
    {
        String numTarjeta = "";
        for(int i = 0 ; i < 16 ; i++)
        {
             Random r = new Random();
             int numero = (r.nextInt(9));
             numTarjeta += String.format("%d", numero);
        }
        return numTarjeta;
    }
}

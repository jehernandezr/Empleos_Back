package co.edu.uniandes.csw.empleos.podam;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.SecureRandom;
import java.util.Random;
import uk.co.jemos.podam.common.AttributeStrategy;

/**
 * Strategy para generar correos corporativos
 *
 * @author je.hernandezr
 */
public class TipoCuentaStrategy implements AttributeStrategy<String> {

    @Override
    public String getValue() {
        SecureRandom num = new SecureRandom();
        
        int numero = Math.abs(num.nextInt(7)+4);
        byte[] array = new byte[numero];
        new Random().nextBytes(array);
        String generatedString = new String(array, StandardCharsets.UTF_8 );
        
       
        return (generatedString);
    }

}

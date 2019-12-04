/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package co.edu.uniandes.csw.empleos.ejb;

import java.util.Calendar;
import java.text.SimpleDateFormat;

/**
 *
 * @author David Dominguez
 */
public class Tokenizer {
	
    private Tokenizer(){
            throw new IllegalStateException("Utility class");

    }
            
    
    public static String currentDate() {
        Calendar cal = Calendar.getInstance();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy MM dd HH mm ss.SSS");
        return sdf.format(cal.getTime());
    }
    
    public static String getToken() {
        String date = currentDate();
        String token = "";
        String[] lines = date.split(" ");
        for(int i = 0; i < lines.length - 1; i++) {
            token += parseString(lines[i]);
        }
        String millis[] = lines[lines.length - 1].split("\\.");
        token += parseString(millis[0]) + parseString(millis[1]);
        return token;
    }
    
    public static String parseString(String str) {
        String result = "";
        for (int i = 0; i < str.length(); i++)
            result += parseNumber(String.valueOf(str.charAt(i)));
        return result;
    }
    
    public static String parseNumber(String number) {
        int initial = 97;
        int n = Integer.parseInt(number);
        char c = (char) (initial + n * 2);
        return ("" + c);
    }
}
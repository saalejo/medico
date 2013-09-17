package hcdigital.util.validaciones;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Clase para validaciones del tipo texto en el sistema
 * @author Diego Alejandro
 */
public class TextoValidaciones {
    
	/**
	 * Valida que el correo electr�nico establecido como par�metro sea un correo electr�nico con formato v�lido
	 * @param correo texto con el correo electr�nico a validar
	 * @return true si el texto tiene un formato de correo electr�nico v�lido, de lo contrario retorna false
	 */
    public static boolean esEmail(String correo) {
        Pattern pat = null;
        Matcher mat = null;
        
        pat = Pattern.compile("^([0-9a-zA-Z]([_.w]*[0-9a-zA-Z])*@([0-9a-zA-Z][-w]*[0-9a-zA-Z].)+([a-zA-Z]{2,9}.)+[a-zA-Z]{2,3})$");
        
        if(esTextoVacio(correo))
        	return false;
        
        mat = pat.matcher(correo);
        if (mat.find()) {            
            return false;
        }else{
            return true;
        }        
    }
    
    /**
     * Valida que el texto ingresado sea un texto considerado vacio, para ser considerado vacio debe ser nulo o una cadena de caracteres
     * vacia
     * @param texto texto a validar
     * @return true, si el texto ingresado es nulo o vacio, de lo contrario false
     */
    public static boolean esTextoVacio(String texto){
    	if(null == texto)
    		return true;
    	texto = texto.trim();
    	if("".equals(texto)){
    		return true;
    	}    		
    	return false;
    }
	
}
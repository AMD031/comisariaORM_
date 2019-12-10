package Otros;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Utilidades {

    public static final int ID = 0;
    public static final int NOMBRE = 1;
    public static final int APELLIDOS = 2;
    public static final int DOCUMENTO = 3;
    public static final int MATRICULAS = 4;
    public static final int DOMICILIOS = 5;
    public static final int TELEFONOS = 6;
    public static final int CORREOS = 7;
    public static final int DETALLES = 8;
    public static final int BORRAR = 9;
    public static final int FOTO = 10;
    public static final int COMPLICE = 11;

    public static int filaSeleccionada;

    //fuera de tabla
    public static final int HECHOS = 20;
    public static final int ANTECEDENTES = 30;

    public static boolean esNumerico(String cadena) {
        try {
            Integer.parseInt(cadena);
            return true;
        } catch (NumberFormatException nfe) {
            return false;
        }
    }

    public static boolean esSoloLetras(String cadena) {
        for (int i = 0; i < cadena.length(); i++) {
            char caracter = cadena.toUpperCase().charAt(i);
            int valorASCII = (int) caracter;
            if (valorASCII != 165 && valorASCII != 164 && (valorASCII < 65 || valorASCII > 90)) {
                return false; //Se ha encontrado un caracter que no es letra
            }
        }
        return true;

    }

    public static boolean validarNIF(String nif) {
        boolean correcto = false;
        Pattern pattern = Pattern.compile("(\\d{1,8})([TRWAGMYFPDXBNJZSQVHLCKEtrwagmyfpdxbnjzsqvhlcke])");
        Matcher matcher = pattern.matcher(nif);
        if (matcher.matches()) {
            String letra = matcher.group(2);
            String letras = "TRWAGMYFPDXBNJZSQVHLCKE";
            int index = Integer.parseInt(matcher.group(1));
            index = index % 23;
            String reference = letras.substring(index, index + 1);
            if (reference.equalsIgnoreCase(letra)) {
                correcto = true;
            } else {
                correcto = false;
            }
        } else {
            correcto = false;
        }
        return correcto;
    }

    public static boolean validaCorreo(String email) {
        // Establecer el patron
        Pattern p = Pattern.compile("[-\\w\\.]+@[\\.\\w]+\\.\\w+");
        // Asociar el string al patron
        Matcher m = p.matcher(email);
        // Comprobar si encaja
        return m.matches();
    }
    
    public static boolean validaMatricula(String matricula){
        boolean correcto = false;
        Pattern pat = Pattern.compile("^\\d{4}[A-Z]{3}");
        Matcher mat = pat.matcher(matricula);
        if (mat.matches()) {
            correcto = true;
        }
        return correcto;
    }
    
    
       public static boolean tieneNumeros(String cadena){
        boolean correcto =false;
        for (int i = 0; i < cadena.length() && !correcto; i++) {
            char caracter = cadena.charAt(i);
            int valorASCII = (int) caracter;
            if ( (valorASCII >=48 && valorASCII <= 57)) {
               correcto =true;
            }
        }
        return correcto;

    }
        
        
        
        
        
        
        
  
    
    

}

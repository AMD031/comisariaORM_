/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Controlador;

import ConsultasH2.ConsultaSospechoso;
import com.mycompany.comisariaorm.Modelo.Foto;
import com.mycompany.comisariaorm.Modelo.Matricula;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class Controlador {

    public static List<Sospechoso> devolverSospechosos() {
        return ConsultaSospechoso.devolverSospechosos();
    }

    public static long idSospechoso(int indice) {
        long id = -1;
        if (ConsultaSospechoso.devolverSospechosos().get(indice) != null) {
            id = ConsultaSospechoso.devolverSospechosos().get(indice).getId();
        }
        return id;
    }
    
    public static String obtenerCamposEs(String campo, long id){
         String resultado =""; 
        if (campo.equals("antecedentes")) {
            resultado = ConsultaSospechoso.devloverSospechoso(id).getAntecedentes()+"";
        }
        
          if (campo.equals("hechos")) {
            resultado = ConsultaSospechoso.devloverSospechoso(id).getHechos()+"";
        }
       return resultado;
    }
    
    public static void guadarCampoEs(long indice ,int campo, String cambio){
        
        ConsultaSospechoso.actulizarCampoMo(indice, campo, cambio);
        
    }

    public static String obtenerCampoMo(String campo, int indice) {
        String resultado = "";

        if (campo.equals("id")) {
            resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getId() + "";
        }

        if (campo.equals("nombre")) {
            resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getNombre() + " ";
        }

        if (campo.equals("apellidos")) {
            resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getApellidos() + " ";
        }

        if (campo.equals("documento")) {
            resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getDocumento() + "";
        }
        
   
        

        return resultado;
    }

    public static String obtenerCampoMul(String campo, long indice) {
        String resultado = "";

        if (campo.equals("matriculas")) {
            resultado = ConsultaSospechoso.matriculasSospechoso(indice) + "";
        }

        if (campo.equals("domicilios")) {
            resultado = ConsultaSospechoso.direccionesSospechoso(indice) + "";
        }

        if (campo.equals("telefonos")) {
            resultado = ConsultaSospechoso.telefonosSospechoso(indice) + "";
        }

        if (campo.equals("correos")) {
            resultado = ConsultaSospechoso.correosSospechoso(indice) + "";
        }

        if (campo.equals("dirrecciones")) {
            resultado = ConsultaSospechoso.direccionesSospechoso(indice) + "";
        }
        return resultado;
    }

    public static List<? extends Object> obtenerCampoMulB(String campo, long indice) {
        List<? extends Object> resultado = null;
        if (campo.equals("matriculas")) {
            resultado = ConsultaSospechoso.matriculasSospechoso(indice);
        }

        if (campo.equals("domicilios")) {
            resultado = ConsultaSospechoso.direccionesSospechoso(indice);
        }

        if (campo.equals("telefonos")) {
            resultado = ConsultaSospechoso.telefonosSospechoso(indice);
        }

        if (campo.equals("correos")) {
            resultado = ConsultaSospechoso.correosSospechoso(indice);
        }

        if (campo.equals("dirrecciones")) {
            resultado = ConsultaSospechoso.direccionesSospechoso(indice);
         }
        if(campo.equals("complices")){
         // resultado = ConsultaSospechoso);
        }
        
        
        return resultado;
    }

    public static void actualizarMo(Long in, int campo, String cambio) {
        ConsultaSospechoso.actulizarCampoMo(in, campo, cambio);
    }

    public static void actualizarMul(Long in, int campo, List<String> datos) {
        ConsultaSospechoso.actulizarCampoMul(in, campo, datos);
    }

    public static void borrarSospechoso(long id) {
        ConsultaSospechoso.eliminarSospechoso(id);
    }

    public static void guardarSospechoso(String nombre, String apellidos, String dni, String calle, String Matricula, String correo,
            String antecedentes, String hechos, String telefono) {

        ConsultaSospechoso.guardarSospechoso(nombre, apellidos, dni, calle, Matricula, correo,
                antecedentes, hechos, telefono);

    }

    public static void GuardarFotoSospechoso(Long indice,String ruta) throws Exception{
            ConsultaSospechoso.GuardarFotoSospechoso(indice, ruta);
    }
    
    public static Foto cargarFoto(long indice){        
        return ConsultaSospechoso.cargarFoto(indice);
    }

    public static void BorraFoto(long id) {
       ConsultaSospechoso.BorrarFoto(id);
    }

    public static List<Sospechoso> devolverComplices(long id) {
      
        return ConsultaSospechoso.devolverComplices(id);
    }

    public static void GuardarComplice( long id,long idcomplice) {
       ConsultaSospechoso.agreagarComplice(id, idcomplice);
    }

    public static void actualizaComplices(ArrayList<Long> obtenerDatosTabla, long id) {
      ConsultaSospechoso.actualizaComplices(obtenerDatosTabla, id);
    }

  

    public static void borrarComplice(long idcomplice, long id) {
      ConsultaSospechoso.borrarComplice(idcomplice, id);
    }

  
    
    
    
    
    
    
}

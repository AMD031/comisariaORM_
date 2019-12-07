/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Controlador;

import ConsultasH2.ConsultaSospechoso;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import java.util.List;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class Controlador {
    
    
    public static List<Sospechoso> devolverSospechosos(){
        return  ConsultaSospechoso.devolverSospechosos();
    }
    
    
    public static long idSospechoso(int indice){
        
       long id = -1;
        if( ConsultaSospechoso.devolverSospechosos().get(indice)!=null){
           id = ConsultaSospechoso.devolverSospechosos().get(indice).getId();
        }
        
        return  id;
    }

    public static String obtenerCampoMo (String campo, int indice){
     String resultado ="";
    
     
    if(campo.equals("id")){
       resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getId()+"";
    }
    
    if(campo.equals("nombre")){
         resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getNombre()+" ";
    }
     
    if(campo.equals("apellidos")){
         resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getApellidos()+" ";
    }
  
      if(campo.equals("documento")){
        resultado = ConsultaSospechoso.devolverSospechosos().get(indice).getDocumento()+"";
       }
       

  
        return resultado;
    }

    public static String obtenerCampoMul (String campo, long indice){
      String resultado ="";
            
      if(campo.equals("matriculas")){
          resultado = ConsultaSospechoso.matriculasSospechoso(indice)+"";
       }
      
      if(campo.equals("domicilios")){
        resultado = ConsultaSospechoso.direccionesSospechoso(indice)+"";
      }
      
       if(campo.equals("telefonos")){
         resultado = ConsultaSospechoso.telefonosSospechoso(indice)+"";
       }
       
       if(campo.equals("correos")){
         resultado = ConsultaSospechoso.correosSospechoso(indice)+"";
       }
      
        if(campo.equals("dirrecciones")){
         resultado = ConsultaSospechoso.direccionesSospechoso(indice)+"";
       }
       return resultado;
     }
    
    
    
    
}

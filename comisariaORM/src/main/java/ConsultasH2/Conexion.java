/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ConsultasH2;

import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class Conexion {
     private static EntityManagerFactory emf;
    
     public static EntityManagerFactory  devolverConexion(){
          if(emf ==null){
             emf = Persistence.createEntityManagerFactory("aplicacion");
          }
          return emf;
      }  
        
    
    
    
    
}

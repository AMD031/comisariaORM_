/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import com.mycompany.comisariaorm.Modelo.Sospechoso;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class test4 {
        private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");
    public static void main(String[] args) {
//        listar();
//        ConsultasH2.ConsultaSospechoso.eliminarSospechoso(1l);
//        listar();


    ConsultasH2.ConsultaSospechoso.matriculasSospechoso(1l);
        
    }
    
      static void listar() {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        //Sospechoso so = manager.find(Sospechoso.class, n);
          System.out.println("Ejecucion:");
        
          List<Sospechoso> sos=  ConsultasH2.ConsultaSospechoso.devolverSospechosos();
     
   
          for (Sospechoso so : sos) {
              System.out.println(so);
          }
         
         
         
        manager.getTransaction().commit();
        manager.close();
        
        
        
    }

    
}

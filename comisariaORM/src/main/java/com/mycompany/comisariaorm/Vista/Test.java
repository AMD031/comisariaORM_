/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import com.mycompany.comisariaorm.Modelo.Sospechoso;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
public class Test {

 
    private static EntityManagerFactory emf=Persistence.createEntityManagerFactory("aplicacion");
  
    public static void main(String[] args) {
        
       EntityManager manager=emf.createEntityManager();
     
        
        manager.getTransaction().begin();
        //long id, String documento, String nombre, String apellidos, String antecedentes, String hechos
        Sospechoso s1 = new Sospechoso(1L,"f5sd656f","fajsl","fjsdl","fdskl","fjsdal");
        Sospechoso s2 = new Sospechoso(2L,"f5sd656f","fajsl","fjsdl","fdskl","fjsdal");
        manager.persist(s1);
        manager.persist(s2);
        manager.getTransaction().commit();  
        
         List<Sospechoso> sospechosos= manager.createQuery("FROM Sospechoso ").getResultList();
         listar((ArrayList<Sospechoso>) sospechosos);
         manager.close();
         
         
    }

    static void listar(ArrayList<Sospechoso>sos){
       for(Sospechoso s : sos){
             System.out.println(s);
       }
    }
    
    
}

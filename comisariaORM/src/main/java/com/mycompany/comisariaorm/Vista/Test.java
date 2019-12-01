/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import com.mycompany.comisariaorm.Modelo.Correo;
import com.mycompany.comisariaorm.Modelo.Direccion;
import com.mycompany.comisariaorm.Modelo.Matricula;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class Test {

    private static EntityManagerFactory emf = Persistence.createEntityManagerFactory("aplicacion");

    public static void main(String[] args) {

        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
        Sospechoso s1 = new Sospechoso();
        s1.setNombre("Pedro");
        s1.setApellidos("Sanchez Rodriguez");
        s1.setDocumento("128312z");
        s1.addDireccion(new Direccion("calle anonima 2"));
        s1.addCorreo(new Correo("alguien@gmail.com"));
        s1.addCorreo(new Correo("alguien2@gmail.com"));
        
        
        
        
        
        Sospechoso s2 = new Sospechoso();
        s2.setNombre("Ana");
        s2.setApellidos("Perez Rodriguez");
        s2.setDocumento("1283312x");
        s2.addDireccion(new Direccion("calle anonima"));
        
        
       Sospechoso s3 = new Sospechoso();
        s3.setNombre("Dios");
        s3.setApellidos("X Rodriguez");
        s3.setDocumento("31231312x");
        s3.setAntecedentes("Hinundar el mundo");
        s3.addDireccion(new Direccion("calle anonima 4"));
        s3.setHechos("biblicos");
        
        
        s1.addAcopagnate(s2);
        s2.addAcopagnate(s1);
        s1.addAcopagnate(s3);
        
        
        manager.persist(s1);
        manager.persist(s2);
        
        
        manager.getTransaction().commit();
        manager.close();
        
       
        
        //-----------------------------------------
   
        
        
        listar(1l);
   
    }

    static void listar(long n) {
        EntityManager manager = emf.createEntityManager();
        manager.getTransaction().begin();
        
           Sospechoso so = manager.find(Sospechoso.class, n);
     
           if(so !=null){
               System.out.println("Acopañantes: ");
               if(  so.getAcopagnates()!=null){
                   for (Sospechoso sos : so.getAcopagnates()){
                       System.out.println(sos);
                   }
                       
               }
              
               if(  so.getMatriculas()!=null){
                   for (Matricula m : so.getMatriculas()){
                       System.out.println(m);
                   }
                       
               }
               
            so.getCorreos().forEach(
          
            (c)->{
                System.out.println(c);  
                System.out.println("sospechoso del correo");
                System.out.println(c.getSospechoso());
                System.out.println();
            } 
            );
            
               
               
               
           }
        
        manager.getTransaction().commit();
        manager.close();
    }

}

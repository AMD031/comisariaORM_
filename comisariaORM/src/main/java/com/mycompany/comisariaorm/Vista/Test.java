/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import ConsultasH2.Conexion;
import com.mycompany.comisariaorm.Modelo.Correo;
import com.mycompany.comisariaorm.Modelo.Direccion;
import com.mycompany.comisariaorm.Modelo.Matricula;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import com.mycompany.comisariaorm.Modelo.Telefono;
import com.sun.javafx.scene.control.skin.VirtualFlow;
import java.util.ArrayList;
import java.util.List;
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
        s1.addCorreo(new Correo("fsdjlsfd@algo.com"));
        s1.addCorreo(new Correo("fdsjlk@jalfd.com"));
       
        s1.addMatriculas(new Matricula("fjsdkljkl"));
        s1.addMatriculas(new Matricula("jflkjllkj"));
        s1.addTelefonos(new Telefono("5656565656"));
        s1.addTelefonos(new Telefono("5542379243"));

        
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
            
        Sospechoso s4 = new Sospechoso();
        s4.setNombre("Desconocido");
        s4.setApellidos("Z X");
        s4.setDocumento("43243242x");
        s4.setAntecedentes("Trafico de drogas");
        s4.addDireccion(new Direccion("calle anonima 5"));
        s4.setHechos("aparecio ");
        
        
        manager.persist(s1);
        manager.persist(s2);
        manager.persist(s3);
        manager.persist(s4);
        
        
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
               System.out.println("Matriculas");
               if(  so.getMatriculas()!=null){
                   for (Matricula m : so.getMatriculas()){
                       System.out.println(m);
                   }
               }
               
               
               System.out.println("telefonos");
               if(  so.getTelefonos()!=null){
                   for (Telefono t : so.getTelefonos()){
                       System.out.println(t);
                   }
               }  
           
              System.out.println( so.getCorreos());
           }
        
        manager.getTransaction().commit();
        manager.close();
        
        }
           
    }



package ConsultasH2;

import com.mycompany.comisariaorm.Modelo.Correo;
import com.mycompany.comisariaorm.Modelo.Direccion;
import com.mycompany.comisariaorm.Modelo.Matricula;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import com.mycompany.comisariaorm.Modelo.Telefono;
import java.util.List;
import javax.persistence.EntityManager;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
public class ConsultaSospechoso{
 
    
    public static List<Matricula> matriculasSospechoso(long  indice){
        List<Matricula>matriculas =null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();  
        Sospechoso so = manager.find(Sospechoso.class, indice);
            if(so != null){
            so.getMatriculas().size();
            matriculas = so.getMatriculas();
         }
        manager.getTransaction().commit();
        manager.close();
        return matriculas;
       }
    
       public static List<Telefono> telefonosSospechoso(long  indice){
        List<Telefono>telefonos=null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();  
        Sospechoso so = manager.find(Sospechoso.class, indice);
            if(so != null){
            so.getTelefonos().size();
            telefonos = so.getTelefonos();
         }
        manager.getTransaction().commit();
        manager.close();
        return telefonos;
       }
   
    
       public static List<Correo> correosSospechoso(long  indice){
        List<Correo>correos=null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();  
        Sospechoso so = manager.find(Sospechoso.class, indice);
         if(so != null){
            so.getTelefonos().size();
            correos = so.getCorreos();
         }
        manager.getTransaction().commit();
        manager.close();
        return correos;
    }
    
    
      public static List<Direccion> direccionesSospechoso(long  indice){
       List<Direccion>direcciones =null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();  
        Sospechoso so = manager.find(Sospechoso.class, indice);
            if(so != null){
            so.getDirecciones().size();
            direcciones= so.getDirecciones();
         }
        manager.getTransaction().commit();
        manager.close();
        return direcciones;
    }    
      
    
    public static List<Sospechoso> devolverSospechosos() {
        List<Sospechoso> sospechosos = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        sospechosos=  manager.createQuery("FROM Sospechoso").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return sospechosos;
    }
    
    
    public static void eliminarSospechoso(long indice){
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso s=manager.find(Sospechoso.class, indice);
        if(s!=null){
          manager.remove(s);
        }
        manager.getTransaction().commit();
        manager.close();
    }
    
    
    public static Sospechoso devloverSospechoso(long indice){
        Sospechoso sospechoso = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        sospechoso = manager.find(Sospechoso.class, indice);    
        manager.getTransaction().commit();
        manager.close();
        return sospechoso;
    }
    
    
    
    
    
    
    
    
    
    
    
    
    
}

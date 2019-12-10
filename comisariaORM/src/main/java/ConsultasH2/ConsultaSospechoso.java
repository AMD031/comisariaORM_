package ConsultasH2;

import com.mycompany.comisariaorm.Modelo.Correo;
import com.mycompany.comisariaorm.Modelo.Direccion;
import com.mycompany.comisariaorm.Modelo.Foto;
import com.mycompany.comisariaorm.Modelo.Matricula;
import com.mycompany.comisariaorm.Modelo.Sospechoso;
import com.mycompany.comisariaorm.Modelo.Telefono;
import Otros.Utilidades;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.util.ArrayList;
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
public class ConsultaSospechoso {

    public static List<Matricula> matriculasSospechoso(long indice) {
        List<Matricula> matriculas = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            so.getMatriculas().size();
            matriculas = so.getMatriculas();
        }
        manager.getTransaction().commit();
        manager.close();
        return matriculas;
    }

    public static List<Telefono> telefonosSospechoso(long indice) {
        List<Telefono> telefonos = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            so.getTelefonos().size();
            telefonos = so.getTelefonos();
        }
        manager.getTransaction().commit();
        manager.close();
        return telefonos;
    }

    public static List<Correo> correosSospechoso(long indice) {
        List<Correo> correos = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            so.getCorreos().size();
            correos = so.getCorreos();
        }
        manager.getTransaction().commit();
        manager.close();
        return correos;
    }

    public static List<Direccion> direccionesSospechoso(long indice) {
        List<Direccion> direcciones = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            so.getDirecciones().size();
            direcciones = so.getDirecciones();
        }
        manager.getTransaction().commit();
        manager.close();
        return direcciones;
    }

    public static List<Sospechoso> devolverSospechosos() {
        List<Sospechoso> sospechosos = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        sospechosos = manager.createQuery("FROM Sospechoso").getResultList();
        manager.getTransaction().commit();
        manager.close();
        return sospechosos;
    }
    
    
    
    
    
     public static List<Sospechoso> BusquedaSospechoso(int campo, String busqueda) {
        List<Sospechoso> sospechosos = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();

       if(campo!=-1){
           
  
        if(campo == Utilidades.NOMBRE ){
            sospechosos = manager.createQuery(" FROM Sospechoso WHERE Nombre LIKE "+"'%"+busqueda+"%'").getResultList();
        }
        
        if(campo == Utilidades.APELLIDOS ){
            sospechosos = manager.createQuery(" FROM Sospechoso WHERE Apellidos lIKE "+"'%"+busqueda+"%'").getResultList();
        }
        
          if(campo == Utilidades.ID ){
            sospechosos = manager.createQuery(" FROM Sospechoso WHERE Id_sospechoso ="+busqueda).getResultList();
        }
        
         if(campo == Utilidades.DOCUMENTO ){
            sospechosos = manager.createQuery(" FROM Sospechoso WHERE Documento LIKE "+"'%"+busqueda+"%'").getResultList();
         }  

         if(campo == Utilidades.MATRICULAS ){
            sospechosos = manager.createQuery("FROM Sospechoso so inner join  fetch so.matriculas as ma where ma.matricula like "+"'%"+busqueda+"%'" ).getResultList();
         }  
         
          if(campo == Utilidades.DOMICILIOS ){
            sospechosos = manager.createQuery("FROM Sospechoso so inner join fetch so.direcciones as ma where ma.direcion like "+"'%"+busqueda+"%'" ).getResultList();
         }  
         
          if(campo == Utilidades.TELEFONOS ){
            sospechosos = manager.createQuery("FROM Sospechoso so inner join fetch so.telefonos as ma where ma.telefono like "+"'%"+busqueda+"%'" ).getResultList();
         }  
          
         if(campo == Utilidades.CORREOS ){
            sospechosos = manager.createQuery("FROM Sospechoso so inner join fetch so.correos as ma where ma.correo like "+"'%"+busqueda+"%'" ).getResultList();
         }  
        
      }
         manager.getTransaction().commit();
        manager.close();
        return sospechosos;
    }
    
    
    

    public static void eliminarSospechoso(long indice) {
        System.out.println(indice);
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso s = manager.find(Sospechoso.class, indice);

        if (s != null) {
            manager.remove(s);
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public static Sospechoso devloverSospechoso(long indice) {
        Sospechoso sospechoso = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        sospechoso = manager.find(Sospechoso.class, indice);
        manager.getTransaction().commit();
        manager.close();
        return sospechoso;
    }

    public static void actulizarCampoMo(Long indice, int campo, String cambio) {

        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            if (campo == Utilidades.NOMBRE) {
                so.setNombre(cambio);
            }
            if (campo == Utilidades.APELLIDOS) {
                so.setApellidos(cambio);
            }

            if (campo == Utilidades.DOCUMENTO) {
                so.setDocumento(cambio);
            }

            if (campo == Utilidades.ANTECEDENTES) {
                so.setAntecedentes(cambio);
            }

            if (campo == Utilidades.HECHOS) {
                so.setHechos(cambio);
            }

        }
        manager.getTransaction().commit();
        manager.close();

    }

    public static void actulizarCampoMul(Long in, int campo, List<String> datos) {
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, in);

        if (so != null) {

            if (campo == Utilidades.MATRICULAS) {
                so.getMatriculas().clear();
                if (datos != null) {
                    for (String s : datos) {
                        so.addMatriculas(new Matricula(s));
                    }
                }
            }

            if (campo == Utilidades.DOMICILIOS) {
                so.getDirecciones().clear();
                if (datos != null) {
                    for (String s : datos) {
                        so.addDireccion(new Direccion(s));
                    }
                }
            }

            if (campo == Utilidades.TELEFONOS) {
                so.getTelefonos().clear();
                if (datos != null) {
                    for (String s : datos) {
                        so.addTelefonos(new Telefono(s));
                    }
                }
            }
            if (campo == Utilidades.CORREOS) {
                so.getCorreos().clear();
                if (datos != null) {
                    for (String s : datos) {
                        so.addCorreo(new Correo(s));
                    }
                }

            }
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public static void actualizaComplices(List<Long> ids, long id) {
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, id);
        if (so != null) {

            Sospechoso comp = null;
            for (long ID : ids) {
                if (ID != id) {
                    comp = manager.find(Sospechoso.class, ID);
                    if (comp != null) {
                        if (so.getAcopagnates().contains(comp)) {
                            manager.remove(comp);
                        }
                    }

                }

            }
        }
        manager.getTransaction().commit();
        manager.close();
    }

    public static void agreagarComplice(long id, long idc) {
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, id);
        if (id != idc) {
            if (so != null) {
                Sospechoso comp = manager.find(Sospechoso.class, idc);
                if (comp != null) {
                    so.addAcopagnate(comp);
                }
            }
        }

        manager.getTransaction().commit();
        manager.close();
    }

    public static void guardarSospechoso(String nombre, String apellidos, String dni, String calle, String Matricula, String correo,
            String antecedentes, String hechos, String telefono) {

        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();

        Sospechoso so = new Sospechoso();
        so.setNombre(nombre);
        so.setApellidos(apellidos);
        so.setDocumento(dni);
        so.addCorreo(new Correo(correo));
        so.addDireccion(new Direccion(calle));
        so.addTelefonos(new Telefono(telefono));
        so.addMatriculas(new Matricula(Matricula));
        so.setAntecedentes(antecedentes);
        so.setHechos(hechos);

        manager.persist(so);
        manager.getTransaction().commit();
        manager.close();
    }

    public static void GuardarFotoSospechoso(Long indice, String ruta) throws Exception {

        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        try {

            File f = new File(ruta); //asociamos el archivo fisico
            InputStream is = new FileInputStream(f); //lo abrimos. Lo importante es que sea un InputStream
            byte[] buffer = new byte[(int) f.length()]; //creamos el buffer
            int readers = is.read(buffer); //leemos el archivo al buffer

            Sospechoso so = manager.find(Sospechoso.class, indice);
            so.setFoto(new Foto(buffer));
            manager.persist(so);

            manager.getTransaction().commit();
            manager.close();
        } catch (Exception e) {
            throw new Exception("error en la foto");
        }

    }

    public static Foto cargarFoto(long indice) {
        Foto foto = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, indice);
        if (so != null) {
            foto = so.getFoto();
        }
        manager.getTransaction().commit();
        manager.close();
        return foto;
    }

    public static void BorrarFoto(long id) {
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, id);
        if (so != null) {
            Foto f = so.getFoto();
            manager.remove(f);
        }

        manager.getTransaction().commit();
        manager.close();

    }

    public static List<Sospechoso> devolverComplices(long id) {
        List<Sospechoso> comp = null;
        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
        Sospechoso so = manager.find(Sospechoso.class, id);
        if (so != null) {
            so.getAcopagnates().size();
            comp = so.getAcopagnates();
        }

        manager.getTransaction().commit();
        manager.close();
        return comp;
    }

    public static void borrarComplice(long idcomplice, long id) {

        EntityManager manager = Conexion.devolverConexion().createEntityManager();
        manager.getTransaction().begin();
  
        Sospechoso so = manager.find(Sospechoso.class,id);
        if(so != null){
           Sospechoso comp = manager.find(Sospechoso.class,idcomplice);
           comp.setIndividuo(null);
     
    
        }
        manager.getTransaction().commit();
        manager.close();
    }

}

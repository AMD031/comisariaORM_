/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.PreRemove;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
@Entity
@Table(name = "sospechosos")
public class Sospechoso implements Serializable {
   private static final long serialVersoinUID=1L;
   
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_sospechoso" , updatable = false, nullable = false)        
    long id;
    
    @Column(name = "documento")
    private String documento;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "antecedentes")
    private String antecedentes;
    
    @Column(name = "hechos")
    private String hechos;
    
    @OneToMany(mappedBy = "sospechoso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Direccion>direcciones;

    @OneToMany(mappedBy = "sospechoso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Correo>correos;
    
    @OneToMany(mappedBy = "sospechoso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Telefono>telefonos;

    @ManyToOne
    @JoinColumn(name="id_individuo")
    private Sospechoso individuo;
    
    @OneToMany(mappedBy = "individuo")
    private List<Sospechoso> acopagnates; 
    
    
    @OneToMany(mappedBy = "sospechoso", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Matricula> matriculas; 
    
    @OneToOne(cascade = {CascadeType.ALL})//todos los cambios en cascada
    @JoinColumn(name = "id_foto")
    private Foto foto;
    


    public Sospechoso() {
        this.direcciones = new ArrayList<>();
        this.correos = new ArrayList<>();
        this.telefonos  = new ArrayList<>();
        this.acopagnates = new ArrayList<>();
        this.matriculas  = new ArrayList<>();       
    }

    public Sospechoso(String documento, String nombre, String apellidos, String antecedentes, String hechos, List<Direccion> direcciones, List<Correo> correos, List<Telefono> telefonos, Sospechoso individuo, List<Sospechoso> acopagnates, List<Matricula> matriculas,Foto foto) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.antecedentes = antecedentes;
        this.hechos = hechos;
        this.direcciones = direcciones;
        this.correos = correos;
        this.telefonos = telefonos;
        this.individuo = individuo;
        this.acopagnates = acopagnates;
        this.matriculas = matriculas;
        this.foto = foto;
    }

    public Sospechoso(String documento, String nombre, String apellidos, String antecedentes, String hechos, Sospechoso individuo,Foto foto) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.antecedentes = antecedentes;
        this.hechos = hechos;
        this.individuo = individuo;
        
        this.direcciones = new ArrayList<>();
        this.correos = new ArrayList<>();
        this.telefonos  = new ArrayList<>();
        this.acopagnates = new ArrayList<>();
        this.matriculas  = new ArrayList<>();
        this.foto = foto;
    }

    public Foto getFoto() {
        return foto;
    }

    public void setFoto(Foto foto) {
        this.foto = foto;
        if(foto !=null){
           foto.setSospechoso(this);
        }  
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setMatriculas(List<Matricula> matriculas) {
        this.matriculas = matriculas;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAntecedentes() {
        return antecedentes;
    }

    public Sospechoso getIndividuo() {
        return individuo;
    }

    public void setIndividuo(Sospechoso individuo) {
        this.individuo = individuo;
    }

    public List<Sospechoso> getAcopagnates() {
        return acopagnates;
    }

    public void setAcopagnates(List<Sospechoso> acopagnates) {
        this.acopagnates = acopagnates;
    }

    public static long getSerialVersoinUID() {
        return serialVersoinUID;
    }

    public List<Matricula> getMatriculas() {
        return matriculas;
    }

    public void setAntecedentes(String antecedentes) {
        this.antecedentes = antecedentes;
    }

    public String getHechos() {
        return hechos;
    }

    public void setHechos(String hechos) {
        this.hechos = hechos;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<Telefono> getTelefonos() {
        return telefonos;
    }

    public void setTelefonos(List<Telefono> telefonos) {
        this.telefonos = telefonos;
    }

    public List<Correo> getCorreos() {
        return correos;
    }

    public void setCorreos(List<Correo> correos) {
        this.correos = correos;
    }
    
  
      public void addAcopagnate(Sospechoso s ){    
        if(!acopagnates.contains(s)){
            acopagnates.add(s); 
            s.setIndividuo(this);
        }
    }

    
    
    public void addDireccion(Direccion d ){    
        if(!direcciones.contains(d)){
            direcciones.add(d); 
            d.setSospechoso(this);  
        }
    }
    
    
    public void addCorreo(Correo d ){    
        if(!correos.contains(d)){
            correos.add(d); 
            d.setSospechoso(this);  
        }
    }
    
    
    public void addMatriculas(Matricula m){
        if(!matriculas.contains(m)){
            matriculas.add(m);
            m.setSospechoso(this);
        }
  
    }
 
    
    
    public void addTelefonos(Telefono t){
        if(!telefonos.contains(t)){
            telefonos.add(t);
            t.setSospechoso(this);
        }
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 53 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 53 * hash + Objects.hashCode(this.documento);
        hash = 53 * hash + Objects.hashCode(this.nombre);
        hash = 53 * hash + Objects.hashCode(this.apellidos);
        hash = 53 * hash + Objects.hashCode(this.antecedentes);
        hash = 53 * hash + Objects.hashCode(this.hechos);
        hash = 53 * hash + Objects.hashCode(this.direcciones);
        hash = 53 * hash + Objects.hashCode(this.correos);
        hash = 53 * hash + Objects.hashCode(this.telefonos);
        hash = 53 * hash + Objects.hashCode(this.individuo);
        hash = 53 * hash + Objects.hashCode(this.acopagnates);
        hash = 53 * hash + Objects.hashCode(this.matriculas);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Sospechoso other = (Sospechoso) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.documento, other.documento)) {
            return false;
        }
        return true;
    }
    
   @PreRemove
   public void nulificarComplices(){
       acopagnates.forEach(
          (v)->v.setIndividuo(null));
      }
    
    
    
    @Override
    public String toString() {
        return "Sospechoso{" + "id=" + id + ", documento=" + documento +
               ", nombre=" + nombre + ", apellidos=" + apellidos +
               ", antecedentes=" + antecedentes + ", hechos=" + hechos + '}';
    }

    
}

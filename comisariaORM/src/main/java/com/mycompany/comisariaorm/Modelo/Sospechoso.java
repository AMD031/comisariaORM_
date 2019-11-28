/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
@Entity
@Table(name = "SOSPECHOSOS")
public class Sospechoso implements Serializable {
   private static final long serialVersoinUID=1L;
    @Id
    //@GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_sospechoso")        
    long id;
    
    @Column(name = "documentos")
    private String documento;
    
    @Column(name = "nombre")
    private String nombre;
    
    @Column(name = "apellidos")
    private String apellidos;
    
    @Column(name = "antecedentes")
    private String antecedentes;
    
    @Column(name = "hechos")
    private String hechos;
    
    @OneToMany(mappedBy = "sospechoso")
    private List<Direccion>direcciones;
    public Sospechoso() {
    }
        public Sospechoso(long id, String documento, String nombre, String apellidos, String antecedentes, String hechos) {
        this.id = id;
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.antecedentes = antecedentes;
        this.hechos = hechos;
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

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getAntecedentes() {
        return antecedentes;
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

    @Override
    public String toString() {
        return "Sospechoso{" + "id=" + id + ", documento=" + documento + ", nombre=" + nombre + ", apellidos=" + apellidos + ", antecedentes=" + antecedentes + ", hechos=" + hechos + '}';
    }

    public Sospechoso(String documento, String nombre, String apellidos, String antecedentes, String hechos) {
        this.documento = documento;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.antecedentes = antecedentes;
        this.hechos = hechos;
    }

    public List<Direccion> getDirecciones() {
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

 
   

    
}

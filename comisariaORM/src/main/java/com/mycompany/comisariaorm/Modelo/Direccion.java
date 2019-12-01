/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
@Entity
@Table(name="direciones")
public class Direccion implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_direcion" , updatable = false, nullable = false)
    private long id_direccion;
    @Column(name="direcion")
    private String direcion;
    
    @ManyToOne(fetch = FetchType.LAZY ) 
    @JoinColumn(name = "id_sospechoso")
    private Sospechoso sospechoso;

    public Direccion() {
    }

    public Direccion(long id_direccion, String direcion, Sospechoso sospechoso) {
        this.id_direccion = id_direccion;
        this.direcion = direcion;
        this.sospechoso = sospechoso;
    }

    public Direccion(String direcion) {
        this.direcion = direcion;
    }

    public Direccion(String direcion, Sospechoso sospechoso) {
        this.direcion = direcion;
        this.sospechoso = sospechoso;
    }

    
    public long getId_direccion() {
        return id_direccion;
    }

    public void setId_direccion(long id_direccion) {
        this.id_direccion = id_direccion;
    }

    public String getDirecion() {
        return direcion;
    }

    public void setDirecion(String direcion) {
        this.direcion = direcion;
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 61 * hash + (int) (this.id_direccion ^ (this.id_direccion >>> 32));
        hash = 61 * hash + Objects.hashCode(this.direcion);
        hash = 61 * hash + Objects.hashCode(this.sospechoso);
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
        final Direccion other = (Direccion) obj;
        return true;
    }


    
    
    @Override
    public String toString() {
        return "Direccion{" + "id_direccion=" + id_direccion + ", direcion=" + direcion + '}';
    }
    
    
}

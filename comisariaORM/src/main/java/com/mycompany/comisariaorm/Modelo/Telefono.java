/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.util.Objects;
import javax.annotation.Generated;
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
@Table(name="telefonos")
public class Telefono {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="id_telefono", updatable = false, nullable = false)
    private long id;

    @Column(name="telefono")
    private String telefono;
   
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sospechoso")
    private Sospechoso sospechoso;

    public Telefono() {
    }

    public Telefono(long id, String telefono, Sospechoso sospechoso) {
        this.id = id;
        this.telefono = telefono;
        this.sospechoso = sospechoso;
    }

    public Telefono(String telefono, Sospechoso sospechoso) {
        this.telefono = telefono;
        this.sospechoso = sospechoso;
    }

    public Telefono(String telefono) {
        this.telefono = telefono;
    }

    
    
    
    
    

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
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
        hash = 79 * hash + (int) (this.id ^ (this.id >>> 32));
        hash = 79 * hash + Objects.hashCode(this.telefono);
        hash = 79 * hash + Objects.hashCode(this.sospechoso);
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
        final Telefono other = (Telefono) obj;
        if (this.id != other.id) {
            return false;
        }
        if (!Objects.equals(this.telefono, other.telefono)) {
            return false;
        }
        if (!Objects.equals(this.sospechoso, other.sospechoso)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return this.telefono ;
    }
    
    
}

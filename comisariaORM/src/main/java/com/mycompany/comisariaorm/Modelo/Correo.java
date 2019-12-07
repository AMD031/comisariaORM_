/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

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
@Table(name="correo")
public class Correo {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   @Column(name="id_correo", updatable = false, nullable = false)
   private long id_correo;
   @Column(name="correo")
   private String correo;
   
   @ManyToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_sospechoso")
   private Sospechoso sospechoso;

    public Correo() {
    }

    
     public Correo(long id_correo, String correo, Sospechoso sospechoso) {
        this.id_correo = id_correo;
        this.correo = correo;
        this.sospechoso = sospechoso;
    }
    public Correo(String correo, Sospechoso sospechoso) {
        this.correo = correo;
        this.sospechoso = sospechoso;
    }

    public Correo(String correo) {
        this.correo = correo;
    }

   
   
   
    public long getId_correo() {
        return id_correo;
    }

    public void setId_correo(long id_correo) {
        this.id_correo = id_correo;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
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
        hash = 97 * hash + (int) (this.id_correo ^ (this.id_correo >>> 32));
        hash = 97 * hash + Objects.hashCode(this.correo);
        hash = 97 * hash + Objects.hashCode(this.sospechoso);
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
        final Correo other = (Correo) obj;
        if (this.id_correo != other.id_correo) {
            return false;
        }
        if (!Objects.equals(this.correo, other.correo)) {
            return false;
        }
        if (!Objects.equals(this.sospechoso, other.sospechoso)) {
            return false;
        }
        return true;
    }

 


   
   
   
   
   
       @Override
    public String toString() {
        return  this.correo;
    }

  
  
  
}

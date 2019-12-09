/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
import java.sql.Blob;
import java.util.Arrays;
import java.util.Objects;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Lob;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
@Entity
@Table(name = "foto")
public class Foto implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id_foto")
    private long id_foto;
    
    @Lob
    @Column(name="imagen")
    private byte[] imagen;

   @OneToOne(mappedBy = "foto",fetch = FetchType.LAZY)
   private Sospechoso sospechoso;

    public Foto(byte[] imagen, Sospechoso sospechoso) {
        this.imagen = imagen;
        this.sospechoso = sospechoso;
    }

    public Foto(byte[] imagen) {
        this.imagen = imagen;
    }

    
    
    
    public Foto(long id_foto, byte[] imagen, Sospechoso sospechoso) {
        this.id_foto = id_foto;
        this.imagen = imagen;
        this.sospechoso = sospechoso;
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }
     public Foto() {
    }

    public long getId_foto() {
        return id_foto;
    }

    public void setId_foto(long id_foto) {
        this.id_foto = id_foto;
    }

    public byte[] getImagen() {
        return imagen;
    }

    public void setImagen(byte[] imagen) {
        this.imagen = imagen;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 89 * hash + (int) (this.id_foto ^ (this.id_foto >>> 32));
        hash = 89 * hash + Arrays.hashCode(this.imagen);
        hash = 89 * hash + Objects.hashCode(this.sospechoso);
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
        final Foto other = (Foto) obj;
        if (this.id_foto != other.id_foto) {
            return false;
        }
        if (!Arrays.equals(this.imagen, other.imagen)) {
            return false;
        }
        if (!Objects.equals(this.sospechoso, other.sospechoso)) {
            return false;
        }
        return true;
    }
    
    

    @Override
    public String toString() {
        return "Foto{" + "id_foto=" + id_foto +'}';
    }



 
    

    
    
    
    
}

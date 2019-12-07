/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
import java.sql.Blob;
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

   @OneToOne(fetch = FetchType.LAZY)
   @JoinColumn(name = "id_sospechoso")
   private Sospechoso sospechoso;

    public Foto(byte[] imagen, Sospechoso sospechoso) {
        this.imagen = imagen;
        this.sospechoso = sospechoso;
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
    public String toString() {
        return "Foto{" + "id_foto=" + id_foto +'}';
    }



 
    

    
    
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */
@Entity
@Table(name="correo")
public class Correo {
   @Id
   @Column(name="id_correo")
   private long id_correo;
  @Column(name="correo")
   private String correo;
   @JoinColumn(name = "id_sospechoso")
   private Sospechoso sospechoso;

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
    public String toString() {
        return "Correo{" + "id_correo=" + id_correo + ", correo=" + correo + ", sospechoso=" + sospechoso + '}';
    }
   
   
   
   
   
  
  
  
}

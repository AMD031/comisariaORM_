/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
    @Column(name="id_telefono")
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
    public String toString() {
        return "Telefono{" + "id=" + id + ", telefono=" + telefono + '}';
    }
    
    
}

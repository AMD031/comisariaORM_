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
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */

@Entity
@Table(name ="matriculas")
public class Matricula implements Serializable{
    @Id
    @Column(name="id_matricula", updatable = false, nullable = false)
    private long id_matricula;
    @Column(name="matricula")
    private String matricula;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sospechoso")
    private Sospechoso sospechoso;

    public Matricula(long id_matricula, String matricula, Sospechoso sospechoso) {
        this.id_matricula = id_matricula;
        this.matricula = matricula;
        this.sospechoso = sospechoso;
    }

    public Matricula(String matricula, Sospechoso sospechoso) {
        this.matricula = matricula;
        this.sospechoso = sospechoso;
    }
    
    public Matricula(String matricula) {
        this.matricula = matricula;
    }

    
    public long getId_matricula() {
        return id_matricula;
    }

    public void setId_matricula(long id_matricula) {
        this.id_matricula = id_matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Sospechoso getSospechoso() {
        return sospechoso;
    }

    public void setSospechoso(Sospechoso sospechoso) {
        this.sospechoso = sospechoso;
    }

    public Matricula() {
    }

    @Override
    public int hashCode() {
        int hash = 5;
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
        final Matricula other = (Matricula) obj;
        if (this.id_matricula != other.id_matricula) {
            return false;
        }
        if (!Objects.equals(this.matricula, other.matricula)) {
            return false;
        }
        if (!Objects.equals(this.sospechoso, other.sospechoso)) {
            return false;
        }
        return true;
    }

    
    
    
    @Override
    public String toString() {
        return "Matricula{" + "id_matricula=" + id_matricula + ", matricula=" + matricula + '}';
    }
    
    
}

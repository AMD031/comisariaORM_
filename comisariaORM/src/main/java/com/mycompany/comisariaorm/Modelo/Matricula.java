/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
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
    @Column(name="id_matricula")
    private long id_matricula;
    @Column(name="matricula")
    private String matricula;
    
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_sospechoso")
    private Sospechoso sospechoso;

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
    public String toString() {
        return "Matricula{" + "id_matricula=" + id_matricula + ", matricula=" + matricula + '}';
    }
    
    
}

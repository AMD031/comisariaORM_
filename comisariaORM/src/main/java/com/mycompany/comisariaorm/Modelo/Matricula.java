/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Modelo;

import java.io.Serializable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 *
 * @author Your Name <Antonio Martinez Diaz>
 */

//@Entity
//@Table(name ="matriculas")
public class Matricula implements Serializable{
    //@Id
    //@Column(name="id_matricula")
    private long id_matricula;
    //@Column(name="matricula")
    private String matricula;
    
}
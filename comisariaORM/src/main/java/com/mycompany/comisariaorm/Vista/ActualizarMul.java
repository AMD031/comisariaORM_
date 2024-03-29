/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.comisariaorm.Vista;

import Otros.Utilidades;
import com.mycompany.comisariaorm.Controlador.Controlador;

import java.util.ArrayList;
import java.util.List;
import javassist.bytecode.analysis.Util;
import javax.swing.JOptionPane;

import javax.swing.event.TableModelEvent;
import javax.swing.event.TableModelListener;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.JTableHeader;
import javax.swing.table.TableColumn;
import javax.swing.table.TableColumnModel;

/**
 * @author Your Name <Antonio Martinez Diaz>
 */
public class ActualizarMul extends javax.swing.JPanel implements TableModelListener {

    private ArrayList<String> datosTabla;
    private DefaultTableModel model;

    /**
     * Creates new form actualizar
     */
    private long id;
    private int campo;

    public ActualizarMul(long id, int campo) {
        datosTabla = new ArrayList();
        initComponents();
        this.id = id;
        this.campo = campo;
        this.Datos.getModel().addTableModelListener(this);
    }

    private List<String> validaTelefono() {
        List<String> datos = null;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) != null && !(((String) model.getValueAt(i, 0)).equals(""))) {
                String dato = (String) model.getValueAt(i, 0);
                if (!Utilidades.esNumerico(dato) && datos == null) {
                    datos = new ArrayList<>();
                    datos.add(String.valueOf((1+i)));
                } else if (!Utilidades.esNumerico(dato)) {
                    datos.add(String.valueOf((1+i)));
                }
            }
        }
        return datos;
    }
    
    
      private List<String> validaCorreo() {
        List<String> datos = null;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) != null && !(((String) model.getValueAt(i, 0)).equals(""))) {
                String dato = (String) model.getValueAt(i, 0);
                if (!Utilidades.validaCorreo(dato) && datos == null) {
                    datos = new ArrayList<>();
                    datos.add(String.valueOf((1+i)));
                } else if (!Utilidades.validaCorreo(dato)) {
                    datos.add(String.valueOf((1+i)));
                }
            }
        }
        return datos;
    }
       private List<String> validaMatricula() {
        List<String> datos = null;
        for (int i = 0; i < model.getRowCount(); i++) {
            if (model.getValueAt(i, 0) != null && !(((String) model.getValueAt(i, 0)).equals(""))) {
                String dato = (String) model.getValueAt(i, 0);
                if (!Utilidades.validaMatricula(dato) && datos == null) {
                    datos = new ArrayList<>();
                    datos.add(String.valueOf((1+i)));
                } else if (!Utilidades.validaMatricula(dato)) {
                    datos.add(String.valueOf((1+i)));
                }
            }
        }
        return datos;
    }
    

    private void dialogfilasErroneas(List<String> errores) {     
         StringBuilder sb = new StringBuilder();
         for (String error : errores) {
               sb.append(" "+error);
        }
         JOptionPane.showMessageDialog(this,
                "Entrada de datos no valida, no se guardara si no se introduce una entrada valida. "
                + "\n las filas no validas son: "+sb.toString(),
                "Error",
                JOptionPane.ERROR_MESSAGE);
        
    }

    private ArrayList<String> obtenerDatosTabla() {

        if (campo == Utilidades.TELEFONOS && validaTelefono() != null) {    
            dialogfilasErroneas(validaTelefono());
        } else if (campo == Utilidades.CORREOS && validaCorreo() != null) {
            dialogfilasErroneas(validaCorreo());
        }else if(campo == Utilidades.MATRICULAS && validaMatricula() != null){
           dialogfilasErroneas(validaMatricula());
        }else{
            for (int i = 0; i < model.getRowCount(); i++) {
                if (model.getValueAt(i, 0) != null && !(((String) model.getValueAt(i, 0)).equals(""))) {
                    datosTabla.add((String) model.getValueAt(i, 0));
                }
            }
        }
        return datosTabla;
    }

    public void nombreColumna1(String s) {
        JTableHeader th = Datos.getTableHeader();
        TableColumnModel tcm = th.getColumnModel();
        TableColumn tc = tcm.getColumn(0);
        tc.setHeaderValue(s);
        th.repaint();
    }

    public void iniciaModelo(List<? extends Object> elementos, int columna) {
        if (Utilidades.MATRICULAS == columna) {
            nombreColumna1("Matricula");
        }
        if (Utilidades.DOMICILIOS == columna) {
            nombreColumna1("Domicilios");
        }

        if (Utilidades.TELEFONOS == columna) {
            nombreColumna1("Telefonos");
        }

        if (Utilidades.CORREOS == columna) {
            nombreColumna1("Correos");
        }
        model = (DefaultTableModel) Datos.getModel();
        for (Object e : elementos) {
            model.addRow(new Object[]{e.toString()});
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        Datos = new javax.swing.JTable();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jButton3 = new javax.swing.JButton();

        Datos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Datos"
            }
        ));
        jScrollPane1.setViewportView(Datos);

        jButton1.setText("Insertar fila");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setText("Guardar cambios");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        jButton3.setText("Eliminar");
        jButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(15, 15, 15)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 241, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 356, Short.MAX_VALUE)
                    .addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(56, 56, 56)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jButton1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton3))
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        model.addRow(new Object[]{null});
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
             obtenerDatosTabla();
             Controlador.actualizarMul(this.id, this.campo, datosTabla);
     
   
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
        model.removeRow(Datos.getSelectionModel().getLeadSelectionIndex());
    }//GEN-LAST:event_jButton3ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTable Datos;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton3;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void tableChanged(TableModelEvent e) {
        System.out.println(e.getFirstRow());
    }

}

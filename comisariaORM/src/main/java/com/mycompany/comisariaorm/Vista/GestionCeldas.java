package com.mycompany.comisariaorm.Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;



public class GestionCeldas extends DefaultTableCellRenderer{
	private String tipo="text";
	private JLabel label = new JLabel();
	//private ImageIcon iconoGuardar = new ImageIcon(getClass().getResource("/recursos/iconos/ico_guardar.png"));
	//private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/recursos/iconos/ico_buscar.png"));
	public GestionCeldas(){
		
	}

	
	public GestionCeldas(String tipo){
		this.tipo=tipo;
	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

      
        if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("PERFIL") )
            {
            	//label.setIcon(iconoBuscar);
            }
            else if( String.valueOf(value).equals("EVENTO") )
            {
            	//label.setIcon(iconoGuardar);
            }
            label.setHorizontalAlignment( JLabel.LEFT );
          label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
          
           return label;
        }
        
      
	return null;
 
        }
}
	

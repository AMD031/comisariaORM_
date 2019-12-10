package com.mycompany.comisariaorm.Vista;

import java.awt.Button;
import java.awt.Color;
import java.awt.Component;
import java.awt.Font;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTree;
import javax.swing.table.DefaultTableCellRenderer;



public class GestionCeldas extends DefaultTableCellRenderer{
	private String tipo="text";
	private JLabel label = new JLabel();
        private JButton boton = new JButton();
        
   
     
	private ImageIcon iconoBorrar = createImageIcon("/res/del.png");
	//private ImageIcon iconoBuscar = new ImageIcon(getClass().getResource("/recursos/iconos/ico_buscar.png"));
	public GestionCeldas(){
         
            
            
	}

	
	public GestionCeldas(String tipo){
		this.tipo=tipo;

	}
	@Override
	public Component getTableCellRendererComponent(JTable table, Object value, boolean selected, boolean focused, int row, int column) {

          // System.out.println(System.getProperty("user.dir"));
        if( tipo.equals("icono"))
        {
            if( String.valueOf(value).equals("PERFIL") )
            {
                  //label.setIcon(iconoBuscar);
               boton.setText("detalles");
            }
            else if( String.valueOf(value).equals("EVENTO") )
            {
                    boton.setText("borrar");
            }   else if( String.valueOf(value).equals("FOTO") )
            {
                boton.setText("foto");
            } else if( String.valueOf(value).equals("COMPLICE") )
            {
                boton.setText("complices");
            }
            label.setHorizontalAlignment( JLabel.LEFT );
         // label.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
          
           return boton;
        }
        
      
	 return null;
 
        }
        
        
   protected ImageIcon createImageIcon(String path) {
    java.net.URL imgURL = getClass().getResource(path);
    if (imgURL != null) {
        return new ImageIcon(imgURL);
    } else {
       // System.err.println("Couldn't find file: " + path);
        return null;
    }
}
}
	

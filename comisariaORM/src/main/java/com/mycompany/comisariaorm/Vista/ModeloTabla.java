package com.mycompany.comisariaorm.Vista;

import javax.swing.table.DefaultTableModel;


public class ModeloTabla extends DefaultTableModel{
	
	String[] titulos;
	Object[][] datos;
	
	/**
	 * Determina el modelo con el que se va a construir la tabla
	 * @param datos
	 * @param titulos
	 */
	public ModeloTabla(Object[][] datos, String[] titulos) {
		super();
		this.titulos=titulos;
		this.datos=datos;
		setDataVector(datos, titulos);
	}
	
	public ModeloTabla() {
		
	}

        
        @Override
	public boolean isCellEditable (int row, int column)
	{
            boolean editable =false;
          if (column==Utilidades.ID || column == Utilidades.PERFIL || column == Utilidades.EVENTO){   
	     return false; 
	    }
            
           return true;
 
	}

}

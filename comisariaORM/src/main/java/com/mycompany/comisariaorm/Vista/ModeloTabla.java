package com.mycompany.comisariaorm.Vista;

import javax.swing.table.DefaultTableModel;


public class ModeloTabla extends DefaultTableModel{
	
	String[] titulos;
	Object[][] datos;
	

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
            boolean editable =true;
          if (column==Utilidades.ID || column == Utilidades.DETALLES || column == Utilidades.BORRAR ||
              column == Utilidades.TELEFONOS || column == Utilidades.MATRICULAS || column == Utilidades.CORREOS ||
              column == Utilidades.DOMICILIOS || column == Utilidades.FOTO){   
                editable =false; 
	    }
            
           return editable;
 
	}

}

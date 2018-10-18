package transport.table;

import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import transport.model.Camion;
import transport.util.Columna;
import transport.util.Columnas;

public class CamionTable extends JTable {
	private DefaultTableModel modeloTabla;
	private Columnas columnas = new Columnas();
	
	public CamionTable() {
		super();
		//this.setAutoResizeMode(JTable.AUTO_RESIZE_OFF);
			
		columnas.agregar(new Columna("ID",35));
		columnas.agregar(new Columna("MATRICULA",150));
		columnas.agregar(new Columna("PESO MAXIMO",150));
		columnas.agregar(new Columna("KM/H",150));
		
		
		modeloTabla = new DefaultTableModel(columnas.getNombresColumnas(),0);
		modeloTabla = new DefaultTableModel();
		modeloTabla.setColumnIdentifiers(columnas.getNombresColumnas());
		
		this.setModel(modeloTabla);
		this.getTableHeader().setResizingAllowed(true);
		
		int[] anchos = columnas.getAnchos();
		
		for(int i = 0; i < this.getColumnCount(); i++) {
			this.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		this.getTableHeader().setFont(new Font("Lucida Sans Demibold", Font.BOLD, 12));
		
	}
	
	public void agregarTodos(List<Camion> camiones) {
		for (Camion camion : camiones)
			modeloTabla.addRow(camion.getObject());
	}
}

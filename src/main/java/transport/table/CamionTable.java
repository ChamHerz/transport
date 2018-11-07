package transport.table;

import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import transport.model.Camion;
import transport.util.Columna;
import transport.util.Columnas;

public class CamionTable extends MiTabla {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiModelTable modeloTabla;
	private Columnas columnas = new Columnas();
	
	public CamionTable() {
		super();
			
		columnas.agregar(new Columna("ID",35));
		columnas.agregar(new Columna("MATRICULA",150));
		columnas.agregar(new Columna("PESO MAXIMO",150));
		columnas.agregar(new Columna("PESO ACTUAL",150));
		columnas.agregar(new Columna("KM/H",150));
		
		modeloTabla = new MiModelTable();
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

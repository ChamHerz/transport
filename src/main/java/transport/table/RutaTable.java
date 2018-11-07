package transport.table;

import java.awt.Font;
import java.util.List;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import transport.model.Ruta;
import transport.util.Columna;
import transport.util.Columnas;

public class RutaTable extends MiTabla {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiModelTable modeloTabla;
	private Columnas columnas = new Columnas();
	
	public RutaTable() {
		super();
			
		columnas.agregar(new Columna("ID",35));
		columnas.agregar(new Columna("DESCRIPCION",150));
			
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
	
	public void agregarTodos(List<Ruta> rutas) {
		for (Ruta ruta : rutas)
			modeloTabla.addRow(ruta.getObject());
	}

}
package transport.table;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import transport.model.Bulto;
import transport.model.Camion;
import transport.model.RutaDetalle;
import transport.util.Columna;
import transport.util.Columnas;

public class RutaDetalleTable extends MiTabla {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiModelTable modeloTabla;
	private Columnas columnas = new Columnas();
	private static final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	
	
	public RutaDetalleTable() {
		super();
			
		//columnas.agregar(new Columna("ID",35));
		//columnas.agregar(new Columna("ID RUTA",150));
		columnas.agregar(new Columna("ORDEN",20));
		columnas.agregar(new Columna("ID CIUDAD",100));
		
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
	
	public void agregarTodos(List<RutaDetalle> rutaDetalles) {
		for (RutaDetalle rutaDetalle : rutaDetalles)
			modeloTabla.addRow(rutaDetalle.getObject());
	}
	
	public void borrarTodoLuegoAgregar(List<RutaDetalle> rutaDetalles) {
		for (int i = 0; i < getRowCount(); i++) {
			modeloTabla.removeRow(i);
			i-=1;
		}
		for (RutaDetalle rutaDetalle : rutaDetalles)
			modeloTabla.addRow(rutaDetalle.getObject());
	}
}

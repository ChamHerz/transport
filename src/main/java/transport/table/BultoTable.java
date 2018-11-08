package transport.table;

import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;

import transport.model.Bulto;
import transport.model.Remolque;
import transport.util.Columna;
import transport.util.Columnas;

public class BultoTable extends MiTabla {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiModelTable modeloTabla;
	private Columnas columnas = new Columnas();
	private static final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	
	public BultoTable() {
		super();
			
		columnas.agregar(new Columna("ID",35));
		columnas.agregar(new Columna("CIUDAD ORIGEN",150));
		columnas.agregar(new Columna("CIUDAD DESTINO",150));
		columnas.agregar(new Columna("ESTADO",100));
		columnas.agregar(new Columna("ID REMOLQUE",35));
		columnas.agregar(new Columna("PESO KG",100));
		columnas.agregar(new Columna("VOLUMEN M3",100));
		columnas.agregar(new Columna("DISTANCIA KM",100));
		columnas.agregar(new Columna("COSTO",100));
			
		modeloTabla = new MiModelTable();
		modeloTabla.setColumnIdentifiers(columnas.getNombresColumnas());
		
		this.setModel(modeloTabla);
		this.getTableHeader().setResizingAllowed(true);
		
		int[] anchos = columnas.getAnchos();
		
		for(int i = 0; i < this.getColumnCount(); i++) {
			this.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
		}
		this.getTableHeader().setFont(new Font("Lucida Sans Demibold", Font.BOLD, 12));
		
		//alinear campos a la derecha
		rightRenderer.setHorizontalAlignment(JLabel.RIGHT);
		getColumnModel().getColumn(this.getColumn("PESO KG").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("VOLUMEN M3").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("DISTANCIA KM").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("COSTO").getModelIndex()).setCellRenderer(rightRenderer);
		
	}
	
	public void agregarTodos(List<Bulto> bultos) {
		for (Bulto bulto : bultos)
			modeloTabla.addRow(bulto.getObject());
	}
	
	public void agregarDesdeRemolques(List<Remolque> remolques) {
		for (Remolque remolque : remolques) {
			this.agregarTodos(remolque.getBultos());
		}
	}
	
	public void borrarTodoLuegoAgregar(List<Bulto> bultos) {
		for (int i = 0; i < getRowCount(); i++) {
			modeloTabla.removeRow(i);
			i-=1;
		}
		for (Bulto bulto : bultos)
			modeloTabla.addRow(bulto.getObject());
	}

}
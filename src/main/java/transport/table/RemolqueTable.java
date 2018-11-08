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

public class RemolqueTable extends MiTabla {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private MiModelTable modeloTabla;
	private Columnas columnas = new Columnas();
	private static final DefaultTableCellRenderer rightRenderer = new DefaultTableCellRenderer();
	
	public RemolqueTable() {
		super();
			
		columnas.agregar(new Columna("ID",35));
		columnas.agregar(new Columna("ID CAMION",35));
		columnas.agregar(new Columna("PESO MAX.",150));
		columnas.agregar(new Columna("PESO ACTUAL",150));
		columnas.agregar(new Columna("VOL. MAX.",150));
		columnas.agregar(new Columna("VOL. ACTUAL",150));
		columnas.agregar(new Columna("CANT BULTOS",150));
			
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
		getColumnModel().getColumn(this.getColumn("PESO MAX.").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("PESO ACTUAL").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("VOL. MAX.").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("VOL. ACTUAL").getModelIndex()).setCellRenderer(rightRenderer);
		getColumnModel().getColumn(this.getColumn("CANT BULTOS").getModelIndex()).setCellRenderer(rightRenderer);
	}
	
	public void agregarTodos(List<Remolque> remolques) {
		for (Remolque remolque : remolques)
			modeloTabla.addRow(remolque.getObject());
	}

	public void borrarTodoLuegoAgregar(List<Remolque> remolques) {
		for (int i = 0; i < getRowCount(); i++) {
			modeloTabla.removeRow(i);
			i-=1;
		}
		for (Remolque remolque : remolques)
			modeloTabla.addRow(remolque.getObject());
	}
}

package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.RutaDAO;
import transport.model.Ruta;
import transport.table.MiScrollTable;
import transport.table.RutaTable;

public class RutaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraRutaTable;
	private RutaTable rutaTable;
	
	public RutaPanel() {
		super();
		rutaTable = new RutaTable();
		barraRutaTable = new MiScrollTable(rutaTable);
		
		this.setName("Rutas");
				
		RutaDAO	rutaDAO = new RutaDAO();
		List<Ruta> rutas = rutaDAO.getRutas();	
		
		this.agregarTodos(rutas);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraRutaTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Ruta> rutas) {
		rutaTable.agregarTodos(rutas);
	}
}

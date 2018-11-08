package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.RutaDetalleDAO;
import transport.model.Ciudad;
import transport.model.RutaDetalle;
import transport.table.CiudadTable;
import transport.table.MiScrollTable;
import transport.table.RutaDetalleTable;

public class RutaDetallePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraRutaDetalle;
	private RutaDetalleTable rutaDetalleTable;
	
	public RutaDetallePanel() {
		super();
		rutaDetalleTable = new RutaDetalleTable();
		barraRutaDetalle = new MiScrollTable(rutaDetalleTable);
		
		this.setName("Detalles de Rutas");
				
		RutaDetalleDAO rutaDetalleDAO = new RutaDetalleDAO();
		List<RutaDetalle> rutaDetalles = rutaDetalleDAO.getRutaDetalles();	
		
		this.agregarTodos(rutaDetalles);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraRutaDetalle, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<RutaDetalle> rutaDetalles) {
		rutaDetalleTable.agregarTodos(rutaDetalles);
	}
}

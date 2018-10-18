package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.CiudadDAO;
import transport.model.Ciudad;
import transport.table.CiudadTable;

public class CiudadPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane barraCiudadTable;
	private CiudadTable ciudadTable;
	
	@SuppressWarnings("unused")
	public CiudadPanel() {
		super();
		ciudadTable = new CiudadTable();
		barraCiudadTable = new JScrollPane(ciudadTable);
		
		this.setName("Ciudades");
				
		CiudadDAO ciudadDAO = new CiudadDAO();
		List<Ciudad> ciudades = ciudadDAO.getCiudades();	
		
		this.agregarTodos(ciudades);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraCiudadTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Ciudad> ciudades) {
		ciudadTable.agregarTodos(ciudades);
	}
}

package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.CamionDAO;
import transport.model.Camion;
import transport.table.CamionTable;
import transport.table.MiScrollTable;

public class CamionPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraCamionTable;
	private CamionTable camionTable;
	
	public CamionPanel() {
		super();
		camionTable = new CamionTable();
		barraCamionTable = new MiScrollTable(camionTable);
		
		this.setName("Camiones");
				
		CamionDAO camionDAO = new CamionDAO();
		List<Camion> camiones = camionDAO.getCamiones();	
		
		this.agregarTodos(camiones);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraCamionTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Camion> camiones) {
		camionTable.agregarTodos(camiones);
	}
}

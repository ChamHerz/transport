package transport.panel;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.ConductorDAO;
import transport.model.Camion;
import transport.model.Conductor;
import transport.table.ConductorTable;

public class ConductorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane barraConductorTable;
	private ConductorTable conductorTable;
	
	@SuppressWarnings("unused")
	public ConductorPanel() {
		super();
		conductorTable = new ConductorTable();
		barraConductorTable = new JScrollPane(conductorTable);
		
		this.setName("Conductores");
				
		ConductorDAO conductorDAO = new ConductorDAO();
		List<Conductor> conductores = conductorDAO.getConductores();	
		
		this.agregarTodos(conductores);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraConductorTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Conductor> conductores) {
		conductorTable.agregarTodos(conductores);
	}


}

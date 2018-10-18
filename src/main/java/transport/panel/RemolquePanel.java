package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.RemolqueDAO;
import transport.model.Remolque;
import transport.table.RemolqueTable;


public class RemolquePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane barraRemolqueTable;
	private RemolqueTable remolqueTable;
	
	@SuppressWarnings("unused")
	public RemolquePanel() {
		super();
		remolqueTable = new RemolqueTable();
		barraRemolqueTable = new JScrollPane(remolqueTable);
		
		this.setName("Remolques");
				
		RemolqueDAO remolqueDAO = new RemolqueDAO();
		List<Remolque> remolques = remolqueDAO.getRemolques();	
		
		this.agregarTodos(remolques);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraRemolqueTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Remolque> remolques) {
		remolqueTable.agregarTodos(remolques);
	}
}

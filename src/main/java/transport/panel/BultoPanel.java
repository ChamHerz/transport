package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.BultoDAO;
import transport.model.Bulto;
import transport.table.BultoTable;
import transport.table.MiScrollTable;

public class BultoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraBultoTable;
	private BultoTable bultoTable;
	
	public BultoPanel() {
		super();
		bultoTable = new BultoTable();
		barraBultoTable = new MiScrollTable(bultoTable);
		
		this.setName("Bultos");
				
		BultoDAO bultoDAO = new BultoDAO();
		List<Bulto> bultos = bultoDAO.getBultos();	
		
		this.agregarTodos(bultos);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraBultoTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Bulto> bultos) {
		bultoTable.agregarTodos(bultos);
	}
}

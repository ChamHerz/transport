package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.ClienteDAO;
import transport.model.Cliente;
import transport.table.ClienteTable;
import transport.table.MiScrollTable;

public class ClientePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraClienteTable;
	private ClienteTable clienteTable;
	
	@SuppressWarnings("unused")
	public ClientePanel() {
		super();
		clienteTable = new ClienteTable();
		barraClienteTable = new MiScrollTable(clienteTable);
		
		this.setName("Clientes");
				
		ClienteDAO clienteDAO = new ClienteDAO();
		List<Cliente> clientes = clienteDAO.getClientes();	
		
		this.agregarTodos(clientes);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraClienteTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Cliente> clientes) {
		clienteTable.agregarTodos(clientes);
	}
}

package transport.panel;

import java.awt.BorderLayout;
import java.util.List;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.dao.PedidoDAO;
import transport.model.Pedido;
import transport.table.PedidoTable;

public class PedidoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private JScrollPane barraClienteTable;
	private PedidoTable pedidoTable;
	
	@SuppressWarnings("unused")
	public PedidoPanel() {
		super();
		pedidoTable = new PedidoTable();
		barraClienteTable = new JScrollPane(pedidoTable);
		
		this.setName("Pedidos");
				
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> pedidos = pedidoDAO.getPedidos();	
		
		this.agregarTodos(pedidos);
		
		setLayout(new BorderLayout());
		add(new JLabel("ok"), BorderLayout.SOUTH);
		add(barraClienteTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Pedido> pedidos) {
		pedidoTable.agregarTodos(pedidos);
	}
}

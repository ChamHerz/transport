package transport.panel;

import java.awt.BorderLayout;
import java.awt.Cursor;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import transport.control.BotonNormal;
import transport.dao.PedidoDAO;
import transport.form.FormPedidoAgregar;
import transport.form.FormPedidoDetalle;
import transport.main.Transport;
import transport.model.Pedido;
import transport.table.MiScrollTable;
import transport.table.PedidoTable;

public class PedidoPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraClienteTable;
	private PedidoTable pedidoTable;
	private JPanel panelDerecho = new JPanel();
	private BotonNormal botonDetalle = new BotonNormal("Detalle","/images/icon-detalle.png");
	private BotonNormal botonAdd = new BotonNormal("Agregar","/images/icon-add.png");
	
	public PedidoPanel() {
		super();
		pedidoTable = new PedidoTable();
		barraClienteTable = new MiScrollTable(pedidoTable);
		
		this.setName("Pedidos");
				
		PedidoDAO pedidoDAO = new PedidoDAO();
		List<Pedido> pedidos = pedidoDAO.getPedidos();	
		
		this.agregarTodos(pedidos);
		
		setLayout(new BorderLayout());
		panelDerecho.setLayout(new BorderLayout());
		add(panelDerecho, BorderLayout.EAST);
		JPanel panelBotones = new JPanel(new BorderLayout());
		//panelBotones.setLayout(new BoxLayout(panelBotones, BoxLayout.Y_AXIS));
		panelBotones.add(botonDetalle,BorderLayout.NORTH);
		panelBotones.add(botonAdd,BorderLayout.SOUTH);
		panelDerecho.add(panelBotones,BorderLayout.NORTH);
		botonDetalle.addActionListener(eventoBotonDetalle());
		botonAdd.addActionListener(eventoBotonAdd());
		add(barraClienteTable, BorderLayout.CENTER);
	}
	
	public void agregarTodos(List<Pedido> pedidos) {
		pedidoTable.agregarTodos(pedidos);
	}
	
	public ActionListener eventoBotonDetalle(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idPedido = pedidoTable.getIdSelected();
            	if (idPedido == null)
            		return;
            	FormPedidoDetalle formPedidoDetalle = new FormPedidoDetalle(idPedido);
            	
            }
        };
    }
	
	public ActionListener eventoBotonAdd(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	FormPedidoAgregar formPedidoAgregar = new FormPedidoAgregar();
            	PedidoDAO pedidoDAO = new PedidoDAO();
        		List<Pedido> pedidos = pedidoDAO.getPedidos();
        		pedidoTable.vaciarTabla();
        		agregarTodos(pedidos);
            }
        };
    }
}
package transport.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.BevelBorder;

import transport.control.BotonNormal;
import transport.dao.BultoDAO;
import transport.dao.ClienteDAO;
import transport.dao.PedidoDAO;
import transport.main.Transport;
import transport.model.Bulto;
import transport.model.Cliente;
import transport.model.Pedido;
import transport.table.BultoTable;
import transport.table.MiScrollTable;

public class FormPedidoDetalle extends MiForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel panelSuperior;
	private JPanel panelCliente;
	private JPanel panelPedido;
	private JPanel panelCenter;
	private JPanel panelBultosDerecha;
	private JPanel panelBultosCenter;
	private JPanel panelBultosTotales;
	private static String titulo = "Detalle de Pedido";
	private Pedido pedido;
	private Cliente cliente;
	private JTextField tbIdCliente = new JTextField();
	private JTextField tbNombreApellido = new JTextField();
	private JTextField tbDireccion = new JTextField();
	private JTextField tbTelefono = new JTextField();
	private JTextField tbIdPedido = new JTextField();
	private JTextField tbFechaPedido = new JTextField();
	private BotonNormal botonAgregar = new BotonNormal("Agregar","/images/icon-detalle.png");
	private JTextField tbPedidoTotal = new JTextField();
	
	//tabla Bultos
	private MiScrollTable barraBultoTable;
	private BultoTable bultoTable;
	
	public FormPedidoDetalle(Integer idPedido) {
		super(titulo);
		
		PedidoDAO pedidoDAO = new PedidoDAO();
		pedido = pedidoDAO.getPedido(idPedido);
		cliente = pedido.getCliente();
		tbIdCliente.setText(cliente.getIdCliente().toString());
		tbNombreApellido.setText(String.format("%s, %s",
				cliente.getNombre(),
				cliente.getApellido()
				));
		tbDireccion.setText(cliente.getDireccion());
		tbTelefono.setText(cliente.getTelefono());
		
		//paneles
		panelSuperior = new JPanel(new BorderLayout());
		add(panelSuperior, BorderLayout.NORTH);
		panelCenter = new JPanel(new BorderLayout());
		add(panelCenter, BorderLayout.CENTER);
		panelCenter.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Bultos:"));
		
		
		//panel Cliente
		panelCliente = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(panelCliente, BorderLayout.NORTH);
		panelCliente.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Cliente:"));
		panelCliente.add(new JLabel("Id Cliente:"));
		tbIdCliente.setEditable(false);
		panelCliente.add(tbIdCliente);
		panelCliente.add(new JLabel("Nombre y Apellido:"));
		tbNombreApellido.setEditable(false);
		panelCliente.add(tbNombreApellido);
		tbDireccion.setEditable(false);
		panelCliente.add(new JLabel("Direccion:"));
		panelCliente.add(tbDireccion);
		panelCliente.add(new JLabel("Telefono:"));
		tbTelefono.setEditable(false);
		panelCliente.add(tbTelefono);
		
		//panel pedido
		panelPedido = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(panelPedido, BorderLayout.SOUTH);
		panelPedido.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Pedido:"));
		panelPedido.add(new JLabel("Id Pedido:"));
		tbIdPedido = new JTextField();
		tbIdPedido.setText(pedido.getIdPedido().toString());
		tbIdPedido.setEditable(false);
		panelPedido.add(tbIdPedido);
		tbFechaPedido = new JTextField();
		tbFechaPedido.setText(pedido.getFechaLatino());
		tbFechaPedido.setEditable(false);
		panelPedido.add(new JLabel("Fecha y Hora:"));
		panelPedido.add(tbFechaPedido);
		
		//botonera de bultos
		panelBultosDerecha = new JPanel();
		panelCenter.add(panelBultosDerecha, BorderLayout.EAST);
		panelBultosDerecha.add(botonAgregar);
		botonAgregar.setEnabled(false);
		//tabla de bultos
		bultoTable = new BultoTable();
		barraBultoTable = new MiScrollTable(bultoTable);
		
		BultoDAO bultoDAO = new BultoDAO();
		List<Bulto> bultos = bultoDAO.getBultos(pedido.getIdPedido());
		bultoTable.agregarTodos(bultos);
		panelBultosCenter = new JPanel(new BorderLayout());
		panelBultosCenter.add(barraBultoTable, BorderLayout.CENTER);
		panelCenter.add(panelBultosCenter, BorderLayout.CENTER);
		
		panelBultosTotales = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBultosCenter.add(panelBultosTotales, BorderLayout.SOUTH);
		panelBultosTotales.add(new JLabel("Total: $"));
		tbPedidoTotal.setEditable(false);
		tbPedidoTotal.setText(pedido.getCostoPedido().toString());
		panelBultosTotales.add(tbPedidoTotal);
		
		pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	setVisible(true);
	}

}

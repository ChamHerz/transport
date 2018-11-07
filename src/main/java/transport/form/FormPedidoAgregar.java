package transport.form;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
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
import transport.dialog.DialogBultoAgregar;
import transport.dialog.DialogBultoDetalle;
import transport.dialog.DialogClienteSeleccionar;
import transport.main.Transport;
import transport.model.Bulto;
import transport.model.Cliente;
import transport.model.Pedido;
import transport.table.BultoTable;
import transport.table.MiScrollTable;

public class FormPedidoAgregar extends MiForm {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormPedidoAgregar formPedidoAgregar;
	private JPanel panelSuperior;
	private JPanel panelCliente;
	private JPanel panelPedido;
	private JPanel panelCenter;
	private JPanel panelBultosDerecha;
	private JPanel panelBultosCenter;
	private JPanel panelBultosTotales;
	private static String titulo = "Agregar Pedido";
	private Cliente cliente;
	private JTextField tbIdCliente = new JTextField();
	private JTextField tbNombreApellido = new JTextField();
	private JTextField tbDireccion = new JTextField();
	private JTextField tbTelefono = new JTextField();
	private JTextField tbIdPedido = new JTextField();
	private JTextField tbFechaPedido = new JTextField();
	private BotonNormal botonAgregarBulto = new BotonNormal("Agregar","/images/icon-bulto-20.png");
	private BotonNormal seleccionarCliente = new BotonNormal("Seleccionar","/images/icon-add-24.png");
	private BotonNormal botonConfirmar = new BotonNormal("Confirmar","/images/icon-add-24.png");
	private JTextField tbPedidoTotal = new JTextField();
	BigDecimal totalCostoPedido = new BigDecimal(0);
	
	//tabla Bultos
	private List<Bulto> bultos = new ArrayList<Bulto>();
	private MiScrollTable barraBultoTable;
	private BultoTable bultoTable;
	
	public FormPedidoAgregar() {
		super(titulo);
		formPedidoAgregar = this;
		
		//PedidoDAO pedidoDAO = new PedidoDAO();
		//pedido = pedidoDAO.getPedido(idPedido);
		//cliente = pedido.getCliente();
		//tbIdCliente.setText(cliente.getIdCliente().toString());
		//tbNombreApellido.setText(String.format("%s, %s",
		//		cliente.getNombre(),
		//		cliente.getApellido()
		//		));
		//tbDireccion.setText(cliente.getDireccion());
		//tbTelefono.setText(cliente.getTelefono());
		
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
		tbIdCliente.setPreferredSize(new Dimension( 30, 24 ));
		panelCliente.add(tbIdCliente);
		panelCliente.add(new JLabel("Nombre y Apellido:"));
		tbNombreApellido.setEditable(false);
		tbNombreApellido.setPreferredSize(new Dimension( 100, 24 ));
		panelCliente.add(tbNombreApellido);
		tbDireccion.setEditable(false);
		tbDireccion.setPreferredSize(new Dimension( 100, 24 ));
		panelCliente.add(new JLabel("Direccion:"));
		panelCliente.add(tbDireccion);
		panelCliente.add(new JLabel("Telefono:"));
		tbTelefono.setEditable(false);
		tbTelefono.setPreferredSize(new Dimension( 100, 24 ));
		panelCliente.add(tbTelefono);
		panelCliente.add(seleccionarCliente);
		seleccionarCliente.addActionListener(eventoBotonClienteSeleccionar());
		botonAgregarBulto.addActionListener(eventoBotonBultoAgregar());
		
		//panel pedido
		panelPedido = new JPanel(new FlowLayout(FlowLayout.LEFT));
		panelSuperior.add(panelPedido, BorderLayout.SOUTH);
		panelPedido.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Pedido:"));
		panelPedido.add(new JLabel("Id Pedido:"));
		tbIdPedido = new JTextField();
		//tbIdPedido.setText(pedido.getIdPedido().toString());
		tbIdPedido.setEditable(false);
		panelPedido.add(tbIdPedido);
		tbFechaPedido = new JTextField();
		//tbFechaPedido.setText(pedido.getFechaLatino());
		tbFechaPedido.setEditable(false);
		panelPedido.add(new JLabel("Fecha y Hora:"));
		panelPedido.add(tbFechaPedido);
		
		//botonera de bultos
		panelBultosDerecha = new JPanel(new BorderLayout());
		panelCenter.add(panelBultosDerecha, BorderLayout.EAST);
		panelBultosDerecha.add(botonAgregarBulto,BorderLayout.NORTH);
		panelBultosDerecha.add(botonConfirmar,BorderLayout.SOUTH);
		botonConfirmar.addActionListener(eventoBotonConfirmar());
		//botonAgregar.setEnabled(false);
		//tabla de bultos
		bultoTable = new BultoTable();
		barraBultoTable = new MiScrollTable(bultoTable);
		
		//BultoDAO bultoDAO = new BultoDAO();
		//List<Bulto> bultos = bultoDAO.getBultos(pedido.getIdPedido());
		//bultoTable.agregarTodos(bultos);
		panelBultosCenter = new JPanel(new BorderLayout());
		panelBultosCenter.add(barraBultoTable, BorderLayout.CENTER);
		panelCenter.add(panelBultosCenter, BorderLayout.CENTER);

		panelBultosTotales = new JPanel(new FlowLayout(FlowLayout.RIGHT));
		panelBultosCenter.add(panelBultosTotales, BorderLayout.SOUTH);
		panelBultosTotales.add(new JLabel("Total: $"));
		tbPedidoTotal.setEditable(false);
		tbPedidoTotal.setPreferredSize(new Dimension( 250, 24 ));
		//tbPedidoTotal.setText(pedido.getCostoPedido().toString());
		panelBultosTotales.add(tbPedidoTotal);
		
		pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	setVisible(true);
	}
	
	public void clienteSeleccionado(int idClienteSelect) {
		ClienteDAO clienteDAO = new ClienteDAO();
		cliente = clienteDAO.getCliente(idClienteSelect);
		tbIdCliente.setText(cliente.getIdCliente().toString());
		tbNombreApellido.setText(cliente.getNombreApellido());
		tbDireccion.setText(cliente.getDireccion());
		tbTelefono.setText(cliente.getTelefono());
	}
	
	public ActionListener eventoBotonClienteSeleccionar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogClienteSeleccionar dialogClienteSeleccionar = new DialogClienteSeleccionar(formPedidoAgregar);
            	int idClienteSelect = dialogClienteSeleccionar.showDialog();
            	if (idClienteSelect != -1)
            		clienteSeleccionado(idClienteSelect);
            }
        };
    }
	
	public ActionListener eventoBotonBultoAgregar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogBultoAgregar dialogBultoAgregar = new DialogBultoAgregar(formPedidoAgregar);
            	Bulto bulto = dialogBultoAgregar.showDialog();
            	if (bulto != null) {
            		bultos.add(bulto);
            		bultoTable.borrarTodoLuegoAgregar(bultos);
            		calcularTotal();
            	}
            }
        };
    }
	
	private void calcularTotal() {
		totalCostoPedido = BigDecimal.ZERO; 
		for (Bulto bulto : bultos) {
			totalCostoPedido = totalCostoPedido.add(bulto.getCosto());
		}
		tbPedidoTotal.setText(totalCostoPedido.toString());
	}

	public ActionListener eventoBotonConfirmar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	Pedido pedido = new Pedido();
            	pedido.setIdCliente(cliente.getIdCliente());
            	pedido.setFechaPedido(new Date());
            	pedido.setCostoPedido(totalCostoPedido);
            	PedidoDAO pedidoDAO = new PedidoDAO();
            	Integer idPedido = pedidoDAO.addPedido(pedido);
            	
            	BultoDAO bultoDAO = new BultoDAO();
            	for (Bulto bulto : bultos) {
            		bulto.setIdPedido(idPedido);
            		bulto.setIdCiudadOrigen(bulto.getCiudadOrigen().getIdCiudad());
            		bulto.setIdCiudadDestino(bulto.getCiudadDestino().getIdCiudad());
            		bultoDAO.addBulto(bulto);
            	}
            	
            	formPedidoAgregar.setVisible(false);
            	formPedidoAgregar.dispose();
            }
        };
    }
}

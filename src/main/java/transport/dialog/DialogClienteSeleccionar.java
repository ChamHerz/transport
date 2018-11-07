package transport.dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;

import transport.control.BotonNormal;
import transport.dao.ClienteDAO;
import transport.form.FormPedidoDetalle;
import transport.model.Cliente;
import transport.table.ClienteTable;
import transport.table.MiScrollTable;

public class DialogClienteSeleccionar extends MiDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogClienteSeleccionar dialogClienteSeleccionar = this;
	private JPanel panelInferior;
	private MiScrollTable barraClienteTable;
	private ClienteTable clienteTable;
	private List<Cliente> listaClientes;
	private BotonNormal botonSeleccionar = new BotonNormal("Seleccionar","/images/icon-select.png");
	private int idCliente = -1;
	
	public DialogClienteSeleccionar(Dialog owner) {
		super(owner,"Seleccionar Cliente");
		
		setModal(true);
		
		setLayout(new BorderLayout());
		clienteTable = new ClienteTable();
		barraClienteTable = new MiScrollTable(clienteTable);
		add(barraClienteTable, BorderLayout.CENTER);
		ClienteDAO clienteDAO = new ClienteDAO();
		listaClientes = clienteDAO.getClientes();
		clienteTable.agregarTodos(listaClientes);
		panelInferior = new JPanel();
		add(panelInferior,BorderLayout.SOUTH);
		panelInferior.add(botonSeleccionar);
		botonSeleccionar.addActionListener(eventoBotonSeleccionar());
		
		pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	//setVisible(true);
	}
	
	public int showDialog() {
	    setVisible(true);
	    return idCliente;
	}
	
	public ActionListener eventoBotonSeleccionar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idSelect = clienteTable.getIdSelected();
            	if (idSelect == null)
            		return;
            	idCliente = idSelect;
            	dialogClienteSeleccionar.setVisible(false);
            	dialogClienteSeleccionar.dispose();
            }
        };
    }
	
}

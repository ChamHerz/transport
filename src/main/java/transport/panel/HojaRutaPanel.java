package transport.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.HojaRutaDAO;
import transport.form.FormHojaRutaAgregar;
import transport.form.FormHojaRutaDetalle;
import transport.model.HojaRuta;
import transport.table.HojaRutaTable;
import transport.table.MiScrollTable;

public class HojaRutaPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private MiScrollTable barraClienteTable;
	private HojaRutaTable hojaRutaTable;
	private JPanel panelDerecho = new JPanel();
	private BotonNormal botonDetalle = new BotonNormal("Detalle","/images/icon-detalle.png");
	private BotonNormal botonAdd = new BotonNormal("Agregar","/images/icon-add.png");
	
	public HojaRutaPanel() {
		super();
		hojaRutaTable = new HojaRutaTable();
		barraClienteTable = new MiScrollTable(hojaRutaTable);
		
		this.setName("Hojas de Ruta");
		
		HojaRutaDAO hojaRutaDAO = new HojaRutaDAO();
		List<HojaRuta> hojaRutas = hojaRutaDAO.getHojaRutas();	
		
		this.agregarTodos(hojaRutas);
		
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
	
	public void agregarTodos(List<HojaRuta> hojaRutas) {
		hojaRutaTable.agregarTodos(hojaRutas);
	}
	
	public ActionListener eventoBotonDetalle(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idHojaRuta = hojaRutaTable.getIdSelected();
            	if (idHojaRuta == null)
            		return;
            	FormHojaRutaDetalle formHojaRutaDetalle = new FormHojaRutaDetalle(idHojaRuta);
            	
            }
        };
    }
	
	public ActionListener eventoBotonAdd(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	//FormPedidoAgregar formPedidoAgregar = new FormPedidoAgregar();
            	FormHojaRutaAgregar formHojaRutaAgregar = new FormHojaRutaAgregar();
            	//PedidoDAO pedidoDAO = new PedidoDAO();
        		//List<Pedido> pedidos = pedidoDAO.getPedidos();
        		//pedidoTable.vaciarTabla();
        		//agregarTodos(pedidos);
            }
        };
    }
}
package transport.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.ConductorDAO;
import transport.dao.RutaDAO;
import transport.dialog.DialogConductorSeleccionar;
import transport.dialog.DialogDespacharBulto;
import transport.dialog.DialogRutaSeleccionar;
import transport.model.Camion;
import transport.model.Conductor;
import transport.model.Remolque;
import transport.model.Ruta;
import transport.model.RutaDetalle;
import transport.model.Tarifa;
import transport.table.BultoTable;
import transport.table.MiScrollTable;
import transport.table.RemolqueTable;
import transport.table.RutaDetalleTable;

public class FormHojaRutaAgregar extends MiForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private FormHojaRutaAgregar formHojaRutaAgregar = this;
	private static final String titulo = "Nueva Hoja de Ruta";
	//REMOLQUES ACTUALES;
	List<Remolque> remolques;
	
	private JPanel panelSuperior = new JPanel();
	private JPanel panelIzquierdo = new JPanel();
	private JPanel panelCentral = new JPanel();
	private JPanel panelInferior = new JPanel();
	
	//PANEL SUPERIOR
	private JPanel panelSuperiorArriba = new JPanel();
	private JPanel panelSuperiorAbajo = new JPanel();
	private BotonNormal botonSeleccionarConductor = new BotonNormal("Seleccionar Chofer","/images/icon-add-24.png");
	private JLabel labelDatosConductor = new JLabel();
	private JLabel labelDatosTarifa = new JLabel();
	
	//PANEL IZQUIEDO
	private JPanel panelIzquierdoArriba = new JPanel();
	private BotonNormal botonSeleccionarRuta = new BotonNormal("Seleccionar Ruta","/images/icon-add-24.png");
	private MiScrollTable barraRutaDetalle;
	private RutaDetalleTable rutaDetalleTable;
	
	//PANEL CENTRAL
	private JPanel panelCentralArriba = new JPanel();
	private JPanel panelCentralCentral= new JPanel();
	
	//PANEL CAMION Y REMOLQUES
	private JPanel panelCamion = new JPanel();
	private JPanel panelRemolques = new JPanel();
	private JLabel labelCamion = new JLabel();
	private MiScrollTable barraRemolqueTable;
	private RemolqueTable remolqueTable;
	
	//PANEL DE BULTOS
	private JPanel panelBultosDerecha = new JPanel();
	private MiScrollTable barraBultoTable;
	private BultoTable bultoTable;
	private BotonNormal botonSeleccionarBulto = new BotonNormal("Seleccionar Bulto","/images/icon-add-24.png");
	
	public FormHojaRutaAgregar() {
		super(titulo);
		
		//HojaRutaDAO hojaRutaDAO = new HojaRutaDAO();
		//hojaRuta = hojaRutaDAO.get(idHojaRuta);
		
		
		setLayout(new BorderLayout());
		add(panelSuperior,BorderLayout.NORTH);
		add(panelIzquierdo,BorderLayout.WEST);
		add(panelCentral,BorderLayout.CENTER);
		add(panelInferior,BorderLayout.SOUTH);
		
		panelInferior.add(new JLabel("panelInferior"));
		
		//PANEL SUPERIOS
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.add(panelSuperiorArriba,BorderLayout.NORTH);
		panelSuperior.add(panelSuperiorAbajo,BorderLayout.SOUTH);
		
		panelSuperiorArriba.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSuperiorArriba.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Chofer:"));
		panelSuperiorArriba.add(botonSeleccionarConductor);
		botonSeleccionarConductor.addActionListener(eventoSelecionarChofer());
		panelSuperiorArriba.add(labelDatosConductor);
		
		panelSuperiorAbajo.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSuperiorAbajo.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de la Tarifa:"));
		panelSuperiorAbajo.add(labelDatosTarifa);
		
		//PANEL IZQUIERDO
		panelIzquierdo.setLayout(new BorderLayout());
		panelIzquierdo.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Ruta:"));
		panelIzquierdo.add(panelIzquierdoArriba,BorderLayout.NORTH);
		panelIzquierdoArriba.add(botonSeleccionarRuta);
		botonSeleccionarRuta.addActionListener(eventoSelecionarRuta());
		
		rutaDetalleTable = new RutaDetalleTable();
		barraRutaDetalle = new MiScrollTable(rutaDetalleTable);
			
		barraRutaDetalle.setPreferredSize(new Dimension(200, 190));
		panelIzquierdo.add(barraRutaDetalle,BorderLayout.CENTER);
		
		//PANELCENTRAL
		panelCentral.setLayout(new BorderLayout());
		panelCentral.add(panelCentralArriba,BorderLayout.NORTH);
		panelCentral.add(panelCentralCentral,BorderLayout.CENTER);
		
		//PANEL DE CAMION
		panelCentralArriba.setLayout(new BorderLayout());
		panelCentralArriba.add(panelCamion,BorderLayout.NORTH);
		panelCamion.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Camion:"));
		panelCamion.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelCamion.add(labelCamion);
		
		
		//PANEL DE REMOLQUES
		panelCentralArriba.add(panelRemolques,BorderLayout.SOUTH);
		panelRemolques.setLayout(new BorderLayout());
		panelRemolques.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de los Remolques:"));
		remolqueTable = new RemolqueTable();
		barraRemolqueTable = new MiScrollTable(remolqueTable);
		barraRemolqueTable.setPreferredSize(new Dimension(450, 90));
		panelRemolques.add(barraRemolqueTable,BorderLayout.NORTH);
		
		//PNELES DEL BULTO
		panelCentralCentral.setLayout(new BorderLayout());
		panelCentralCentral.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de los Bultos:"));
		panelCentralCentral.add(panelBultosDerecha,BorderLayout.EAST);
		
		bultoTable = new BultoTable();
		barraBultoTable = new MiScrollTable(bultoTable);
		//bultoTable.agregarDesdeRemolques(remolques);
		panelCentralCentral.add(barraBultoTable,BorderLayout.CENTER);
		panelBultosDerecha.add(botonSeleccionarBulto);
		botonSeleccionarBulto.addActionListener(eventoSelecionarBulto());
		
		
		pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	setVisible(true);
	}
	
	public ActionListener eventoSelecionarChofer(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogConductorSeleccionar dialogConductorSeleccionar = new DialogConductorSeleccionar(formHojaRutaAgregar);
            	int idConductorSelect = dialogConductorSeleccionar.showDialog();
            	if (idConductorSelect != -1)
            		conductorSeleecionado(idConductorSelect);
            }
        };
    }
	
	public void conductorSeleecionado(int idConductorSelect) {
		ConductorDAO conductorDAO = new ConductorDAO();
		Conductor conductor = conductorDAO.getConductor(idConductorSelect);
		labelDatosConductor.setText(
				String.format("idChofer: %d, nombre: %s, apellido: %s, dni: %s, telefono: %s",
						conductor.getIdConductor(),
						conductor.getNombre(),
						conductor.getApellido(),
						conductor.getDni(),
						conductor.getTelefono()
						));
		Tarifa tarifa = conductor.getTarifa();
		labelDatosTarifa.setText(
		String.format("idTarifa: %d, precio Por Peso (KG): %s, Precio Por Volumen (M3): %s, Precio Por Distancia: %s",
				tarifa.getIdTarifa(),
				tarifa.getPrecioPorPesoKG().toString(),
				tarifa.getPrecioPorVolumenM3().toString(),
				tarifa.getPrecioPorDistanciaKM().toString()
				));
		Camion camion = conductor.getCamion();
		labelCamion.setText(String.format(
				"idCamion: %d, matricula: %s, peso maximo (KG): %s, peso actual (KG): %s, velocidad (KM/H): %s", 
				camion.getIdCamion(),
				camion.getMatricula(),
				camion.getPesoMaximo().toString(),
				camion.getPesoActual().toString(),
				camion.getKmPorHoraMedio().toString()
				));
		remolques = camion.getRemolques();
		remolqueTable.borrarTodoLuegoAgregar(remolques);
	}
	
	public ActionListener eventoSelecionarRuta(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogRutaSeleccionar dialogRutaSeleccionar = new DialogRutaSeleccionar(formHojaRutaAgregar);
            	int idRutaSelect = dialogRutaSeleccionar.showDialog();
            	if (idRutaSelect != -1)
            		rutaSelecionada(idRutaSelect);
            }
        };
    }
	
	public void rutaSelecionada(int idRutaSelect) {
		RutaDAO rutaDAO = new RutaDAO();
		Ruta ruta = rutaDAO.getRuta(idRutaSelect);
		List<RutaDetalle> rutaDetalles = ruta.getRutaDetalle();
		rutaDetalleTable.borrarTodoLuegoAgregar(rutaDetalles);
	}
	
	public ActionListener eventoSelecionarBulto(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogDespacharBulto dialogDespacharBulto = new DialogDespacharBulto(formHojaRutaAgregar,remolques);
            	int idBultoSelect = dialogDespacharBulto.showDialog();
            	if (idBultoSelect != -1)
            		bultoDespachado(idBultoSelect);
            }
        };
    }
	
	public void bultoDespachado(int idBultoDespachado) {
		
	}
}

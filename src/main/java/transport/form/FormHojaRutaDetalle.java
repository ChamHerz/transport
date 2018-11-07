package transport.form;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.HojaRutaDAO;
import transport.model.Camion;
import transport.model.Conductor;
import transport.model.HojaRuta;
import transport.model.Tarifa;

public class FormHojaRutaDetalle extends MiForm{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private static final String titulo = "Detalles de Hoja de Ruta";
	HojaRuta hojaRuta;
	
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
	private JPanel panelIzquierdoAbajo = new JPanel();
	private BotonNormal botonSeleccionarRuta = new BotonNormal("Seleccionar Ruta","/images/icon-add-24.png");
	
	//PANEL CENTRAL
	private JPanel panelCentralArriba = new JPanel();
	private JPanel panelCentralCentral= new JPanel();
	
	//PANEL CAMION Y REMOLQUES
	private JPanel panelCamion = new JPanel();
	private JPanel panelRemolques = new JPanel();
	private JLabel labelCamion = new JLabel();
	
	//PANEL DE BULTOS
	private JPanel panelBultosCenter = new JPanel();
	private JPanel panelBultosDerecha = new JPanel();
	
	public FormHojaRutaDetalle(Integer idHojaRuta) {
		super(titulo);
		
		HojaRutaDAO hojaRutaDAO = new HojaRutaDAO();
		hojaRuta = hojaRutaDAO.get(idHojaRuta);
		
		
		setLayout(new BorderLayout());
		add(panelSuperior,BorderLayout.NORTH);
		add(panelIzquierdo,BorderLayout.WEST);
		add(panelCentral,BorderLayout.CENTER);
		add(panelInferior,BorderLayout.SOUTH);
		
		//panelSuperior.add(new JLabel("panelSuperior"));
		//panelIzquierdo.add(new JLabel("panelIzquierdo"));
		//panelCentral.add(new JLabel("panelCentral"));
		panelInferior.add(new JLabel("panelInferior"));
		
		//PANEL SUPERIOS
		panelSuperior.setLayout(new BorderLayout());
		panelSuperior.add(panelSuperiorArriba,BorderLayout.NORTH);
		panelSuperior.add(panelSuperiorAbajo,BorderLayout.SOUTH);
		
		panelSuperiorArriba.setLayout(new FlowLayout(FlowLayout.LEFT));
		panelSuperiorArriba.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Chofer:"));
		panelSuperiorArriba.add(botonSeleccionarConductor);
		Conductor conductor = hojaRuta.getConductor();
		labelDatosConductor.setText(
				String.format("idChofer: %d, nombre: %s, apellido: %s, dni: %s, telefono: %s",
						conductor.getIdConductor(),
						conductor.getNombre(),
						conductor.getApellido(),
						conductor.getDni(),
						conductor.getTelefono()
						));
		panelSuperiorArriba.add(labelDatosConductor);
		
		Tarifa tarifa = conductor.getTarifa();
		panelSuperiorAbajo.setLayout(new FlowLayout(FlowLayout.LEFT));
		labelDatosTarifa.setText(
				String.format("idTarifa: %d, precio Por Peso (KG): %s, Precio Por Volumen (M3): %s, Precio Por Distancia: %s",
						tarifa.getIdTarifa(),
						tarifa.getPrecioPorPesoKG().toString(),
						tarifa.getPrecioPorVolumenM3().toString(),
						tarifa.getPrecioPorDistanciaKM().toString()
						));
		panelSuperiorAbajo.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de la Tarifa:"));
		panelSuperiorAbajo.add(labelDatosTarifa);
		
		//PANEL IZQUIERDO
		panelIzquierdo.setLayout(new BorderLayout());
		panelIzquierdo.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos del Ruta:"));
		panelIzquierdo.add(panelIzquierdoArriba,BorderLayout.NORTH);
		panelIzquierdo.add(panelIzquierdoAbajo,BorderLayout.SOUTH);
		panelIzquierdoArriba.add(botonSeleccionarRuta);
		panelIzquierdoAbajo.add(new JLabel("IzquierdoAbajo"));
		
		
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
		
		Camion camion = hojaRuta.getConductor().getCamion();
		labelCamion.setText(camion.getMatricula());
		
		
		//PANEL DE REMOLQUES
		panelCentralArriba.add(panelRemolques,BorderLayout.SOUTH);
		panelRemolques.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de los Remolques:"));
		panelRemolques.add(new JLabel("Datos de los remolques"));
		
		//PNELES DEL BULTO
		panelCentralCentral.setLayout(new BorderLayout());
		panelCentralCentral.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Datos de los Bultos:"));
		panelCentralCentral.add(panelBultosCenter,BorderLayout.CENTER);
		panelCentralCentral.add(panelBultosDerecha,BorderLayout.EAST);
		panelBultosCenter.add(new JLabel("aqui va la tabla de bultos"));
		panelBultosDerecha.add(new JLabel("aqui van los comandos"));
		
		
		pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	setVisible(true);
	}
	

}

package transport.dialog;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.math.BigDecimal;

import javax.swing.JLabel;
import javax.swing.JTextField;

import transport.control.BotonNormal;
import transport.dao.CarreteraDAO;
import transport.dao.CiudadDAO;
import transport.dao.TarifaDAO;
import transport.model.Bulto;
import transport.model.Ciudad;
import transport.model.Tarifa;

public class DialogBultoAgregar extends MiDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogBultoAgregar dialogBultoAgregar = this;
	private Ciudad ciudadOrigen = null;
	private JTextField tbCiudadOrigen = new JTextField();
	private Ciudad ciudadDestino = null;
	private JTextField tbCiudadDestino = new JTextField();
	private BotonNormal botonSelectOrigen = new BotonNormal("Origen","/images/icon-add-24.png");
	private BotonNormal botonSelectDestino = new BotonNormal("Destino","/images/icon-add-24.png");
	private JTextField tbPesoKG = new JTextField();
	private JTextField tbVolumenM3 = new JTextField();
	private JTextField tbDistanciaKM = new JTextField();
	private JTextField tbCosto = new JTextField();
	private BotonNormal botonCalcular = new BotonNormal("Calcular","/images/icon-add-24.png");
	private Bulto bulto = null;
	private JLabel labelTarifa = new JLabel();
	private BotonNormal botonAceptar = new BotonNormal("Confirmar","/images/icon-add-24.png");

	public DialogBultoAgregar(Dialog owner) {
		super(owner, "Nuevo Bulto");
		this.setSize(300, 450);
		//this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		//BultoDAO bultoDAO = new BultoDAO();
		//Bulto bulto = bultoDAO.get(idBulto);
		
		//ciudadOrigen = bulto.getCiudadOrigen();
		//tbCiudadOrigen.setText(ciudadOrigen.getNombre());
		tbCiudadOrigen.setPreferredSize(new Dimension( 200, 24 ));
		//ciudadDestino = bulto.getCiudadDestino();
		//tbCiudadDestino.setText(ciudadDestino.getNombre());
		tbCiudadDestino.setPreferredSize(new Dimension( 200, 24 ));
		//tbPesoKG.setText(bulto.getPesoKG().toString());
		tbPesoKG.setPreferredSize(new Dimension( 250, 24 ));
		//tbVolumenM3.setText(bulto.getVolumenM3().toString());
		tbVolumenM3.setPreferredSize(new Dimension( 250, 24 ));
		//tbDistanciaKM.setText(bulto.getDistanciaKM().toString());
		tbDistanciaKM.setPreferredSize(new Dimension( 250, 24 ));
		//tbCosto.setText(bulto.getCosto().toString());
		tbCosto.setPreferredSize(new Dimension( 250, 24 ));
		
		
		
		add(new JLabel("Ciudad Origen:"));
		add(tbCiudadOrigen);
		add(botonSelectOrigen);
		botonSelectOrigen.addActionListener(eventoCiudadOrigen());
		add(new JLabel("Ciudad Destino:"));
		add(tbCiudadDestino);
		add(botonSelectDestino);
		botonSelectDestino.addActionListener(eventoCiudadDestino());
		add(new JLabel("Peso (KG):"));
		add(tbPesoKG);
		add(new JLabel("Volumen (M3):"));
		add(tbVolumenM3);
		add(new JLabel("Distancia (KM):"));
		add(tbDistanciaKM);
		add(new JLabel("Costo (PESOS):"));
		add(tbCosto);
		add(botonCalcular);
		botonCalcular.addActionListener(eventoBotonCalcular());
		add(labelTarifa);
		add(botonAceptar);
		botonAceptar.addActionListener(eventoConfirmar());
		
		
		
		//pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
	}
	
	public ActionListener eventoCiudadOrigen(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogCiudadSeleccionar dialogCiudadSeleccionar = new DialogCiudadSeleccionar(dialogBultoAgregar);
            	int idCiudadSelect = dialogCiudadSeleccionar.showDialog();
            	if (idCiudadSelect != -1) {
            		CiudadDAO ciudadDAO = new CiudadDAO();
            		ciudadOrigen = ciudadDAO.get(idCiudadSelect);
            		tbCiudadOrigen.setText(ciudadOrigen.getNombre());
            		calcularDistancia();
            	}
            }
        };
    }
	
	public ActionListener eventoCiudadDestino(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {         	
            	DialogCiudadSeleccionar dialogCiudadSeleccionar = new DialogCiudadSeleccionar(dialogBultoAgregar);
            	int idCiudadSelect = dialogCiudadSeleccionar.showDialog();
            	if (idCiudadSelect != -1) {
            		CiudadDAO ciudadDAO = new CiudadDAO();
            		ciudadDestino = ciudadDAO.get(idCiudadSelect);
            		tbCiudadDestino.setText(ciudadDestino.getNombre());
            		calcularDistancia();
            	}
            }
        };
    }
	
	private void calcularDistancia() {
		if (ciudadOrigen != null && ciudadDestino != null) {
			CarreteraDAO carreteraDAO = new CarreteraDAO();
			BigDecimal kilometros = carreteraDAO.getDistancia(ciudadOrigen, ciudadDestino);
			tbDistanciaKM.setText(kilometros.toString());
		}
	}
	
	public ActionListener eventoBotonCalcular(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	bulto = new Bulto();
            	bulto.setCiudadOrigen(ciudadOrigen);
            	bulto.setCiudadDestino(ciudadDestino);
            	
            	bulto.setPesoKG(new BigDecimal(tbPesoKG.getText()));
            	bulto.setVolumenM3(new BigDecimal(tbVolumenM3.getText()));
            	bulto.setDistanciaKM(new BigDecimal(tbDistanciaKM.getText()));
            	
            	TarifaDAO tarifaDAO = new TarifaDAO();
            	Tarifa tarifa = tarifaDAO.get(1);
            	
            	labelTarifa.setText(String.format("Tarifa: porPeso: %s, porVolumen: %s. porDistancia: %s",
            			tarifa.getPrecioPorPesoKG().toString(),
            			tarifa.getPrecioPorVolumenM3().toString(),
            			tarifa.getPrecioPorDistanciaKM().toString()
            			));
            	
            	BigDecimal costoPeso = bulto.getPesoKG().multiply(tarifa.getPrecioPorPesoKG());
            	BigDecimal costoVolumen = bulto.getVolumenM3().multiply(tarifa.getPrecioPorVolumenM3());
            	BigDecimal costoDistancia = bulto.getDistanciaKM().multiply(tarifa.getPrecioPorDistanciaKM());
            	
            	BigDecimal costoTotal = costoPeso.add(costoVolumen).add(costoDistancia);
            	tbCosto.setText(costoTotal.toString());
            	bulto.setCosto(costoTotal);
            }
        };
    }
	
	public Bulto showDialog() {
	    setVisible(true);
	    return this.bulto;
	}
	
	public ActionListener eventoConfirmar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dialogBultoAgregar.setVisible(false);
            	dialogBultoAgregar.dispose();
            }
        };
    }
}

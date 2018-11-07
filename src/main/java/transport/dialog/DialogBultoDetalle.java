package transport.dialog;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import transport.control.BotonNormal;
import transport.dao.BultoDAO;
import transport.model.Bulto;
import transport.model.Ciudad;

public class DialogBultoDetalle extends MiDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Ciudad ciudadOrigen;
	private JTextField tbCiudadOrigen = new JTextField();
	private Ciudad ciudadDestino;
	private JTextField tbCiudadDestino = new JTextField();
	private BotonNormal botonSelectOrigen = new BotonNormal("Origen","/images/icon-add-24.png");
	private BotonNormal botonSelectDestino = new BotonNormal("Destino","/images/icon-add-24.png");
	private JTextField tbPesoKG = new JTextField();
	private JTextField tbVolumenM3 = new JTextField();
	private JTextField tbDistanciaKM = new JTextField();
	private JTextField tbCosto = new JTextField();
	private BotonNormal botonGuardar = new BotonNormal("Guardar","/images/icon-add-24.png");

	public DialogBultoDetalle(Dialog owner, int idBulto) {
		super(owner, "Nuevo Bulto");
		this.setSize(300, 450);
		//this.setResizable(false);
		this.setLayout(new FlowLayout());
		
		BultoDAO bultoDAO = new BultoDAO();
		Bulto bulto = bultoDAO.get(idBulto);
		
		ciudadOrigen = bulto.getCiudadOrigen();
		tbCiudadOrigen.setText(ciudadOrigen.getNombre());
		tbCiudadOrigen.setPreferredSize(new Dimension( 200, 24 ));
		ciudadDestino = bulto.getCiudadDestino();
		tbCiudadDestino.setText(ciudadDestino.getNombre());
		tbCiudadDestino.setPreferredSize(new Dimension( 200, 24 ));
		tbPesoKG.setText(bulto.getPesoKG().toString());
		tbPesoKG.setPreferredSize(new Dimension( 250, 24 ));
		tbVolumenM3.setText(bulto.getVolumenM3().toString());
		tbVolumenM3.setPreferredSize(new Dimension( 250, 24 ));
		tbDistanciaKM.setText(bulto.getDistanciaKM().toString());
		tbDistanciaKM.setPreferredSize(new Dimension( 250, 24 ));
		tbCosto.setText(bulto.getCosto().toString());
		tbCosto.setPreferredSize(new Dimension( 250, 24 ));
		
		
		
		add(new JLabel("Ciudad Origen:"));
		add(tbCiudadOrigen);
		add(botonSelectOrigen);
		add(new JLabel("Ciudad Destino:"));
		add(tbCiudadDestino);
		add(botonSelectDestino);
		add(new JLabel("Peso (KG):"));
		add(tbPesoKG);
		add(new JLabel("Volumen (M3):"));
		add(tbVolumenM3);
		add(new JLabel("Distancia (KM):"));
		add(tbDistanciaKM);
		add(new JLabel("Costo (PESOS):"));
		add(tbCosto);
		add(botonGuardar);
		
		
		
		//pack();
		Dimension dimension = getSize();
		setLocation(
				getLocation().x - dimension.width / 2,
				getLocation().y - dimension.height / 2
				);
		
    	setVisible(true);
	}
	
}

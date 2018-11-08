package transport.dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.ClienteDAO;
import transport.dao.RutaDAO;
import transport.model.Ruta;
import transport.table.MiScrollTable;
import transport.table.RutaTable;

public class DialogRutaSeleccionar extends MiDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogRutaSeleccionar dialogRutaSeleccionar = this;
	private JPanel panelInferior;
	private MiScrollTable barraRutaTable;
	private RutaTable rutaTable;
	private List<Ruta> listaRutas;
	private BotonNormal botonSeleccionar = new BotonNormal("Seleccionar","/images/icon-select.png");
	private int idRuta = -1;
	
	public DialogRutaSeleccionar(Dialog owner) {
		super(owner,"Seleccionar Cliente");
		
		setModal(true);
		
		setLayout(new BorderLayout());
		rutaTable = new RutaTable();
		barraRutaTable = new MiScrollTable(rutaTable);
		add(barraRutaTable, BorderLayout.CENTER);
		RutaDAO rutaDAO = new RutaDAO();
		listaRutas = rutaDAO.getRutas();
		rutaTable.agregarTodos(listaRutas);
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
	    return idRuta;
	}
	
	public ActionListener eventoBotonSeleccionar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idSelect = rutaTable.getIdSelected();
            	if (idSelect == null)
            		return;
            	idRuta = idSelect;
            	dialogRutaSeleccionar.setVisible(false);
            	dialogRutaSeleccionar.dispose();
            }
        };
    }
	
}

package transport.dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.CiudadDAO;
import transport.dao.ClienteDAO;
import transport.model.Ciudad;
import transport.table.CiudadTable;
import transport.table.MiScrollTable;

public class DialogCiudadSeleccionar extends MiDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogCiudadSeleccionar dialogCiudadSeleccionar = this;
	private JPanel panelInferior;
	private MiScrollTable barraCiudadTable;
	private CiudadTable ciudadTable;
	private List<Ciudad> listaCiudades;
	private BotonNormal botonSeleccionar = new BotonNormal("Seleccionar","/images/icon-select.png");
	private int idCiudad = -1;
	
	public DialogCiudadSeleccionar(Dialog owner) {
		super(owner,"Seleccionar Ciudad");
		
		setModal(true);
		
		setLayout(new BorderLayout());
		ciudadTable = new CiudadTable();
		barraCiudadTable = new MiScrollTable(ciudadTable);
		add(barraCiudadTable, BorderLayout.CENTER);
		CiudadDAO ciudadDAO = new CiudadDAO();
		listaCiudades = ciudadDAO.getCiudades();
		ciudadTable.agregarTodos(listaCiudades);
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
	    return idCiudad;
	}
	
	public ActionListener eventoBotonSeleccionar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idSelect = ciudadTable.getIdSelected();
            	if (idSelect == null)
            		return;
            	idCiudad = idSelect;
            	dialogCiudadSeleccionar.setVisible(false);
            	dialogCiudadSeleccionar.dispose();
            }
        };
    }
	
}

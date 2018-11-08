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
import transport.dao.ConductorDAO;
import transport.model.Conductor;
import transport.table.ConductorTable;
import transport.table.MiScrollTable;

public class DialogConductorSeleccionar extends MiDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogConductorSeleccionar dialogConductorSeleccionar = this;
	private JPanel panelInferior;
	private MiScrollTable barraConductorTable;
	private ConductorTable conductorTable;
	private List<Conductor> listaConductores;
	private BotonNormal botonSeleccionar = new BotonNormal("Seleccionar","/images/icon-select.png");
	private int idCliente = -1;
	
	public DialogConductorSeleccionar(Dialog owner) {
		super(owner,"Seleccionar Conductor");
		
		setModal(true);
		
		setLayout(new BorderLayout());
		conductorTable = new ConductorTable();
		barraConductorTable = new MiScrollTable(conductorTable);
		add(barraConductorTable, BorderLayout.CENTER);
		ConductorDAO conductorDAO = new ConductorDAO();
		listaConductores = conductorDAO.getConductores();
		conductorTable.agregarTodos(listaConductores);
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
            	Integer idSelect = conductorTable.getIdSelected();
            	if (idSelect == null)
            		return;
            	idCliente = idSelect;
            	dialogConductorSeleccionar.setVisible(false);
            	dialogConductorSeleccionar.dispose();
            }
        };
    }
	
}

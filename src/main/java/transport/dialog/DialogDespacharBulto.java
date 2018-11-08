package transport.dialog;

import java.awt.BorderLayout;
import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JPanel;

import transport.control.BotonNormal;
import transport.dao.BultoDAO;
import transport.model.Bulto;
import transport.model.Remolque;
import transport.table.BultoTable;
import transport.table.MiScrollTable;
import transport.table.RemolqueTable;

public class DialogDespacharBulto extends MiDialog{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private DialogDespacharBulto dialogDespacharSeleccionar = this;
	private JPanel panelInferior;
	private JPanel panelCentral;
	private JPanel panelRemolques;
	private MiScrollTable barraBultoTable;
	private BultoTable bultoTable;
	private List<Bulto> listaBultos;
	private BotonNormal botonSeleccionar = new BotonNormal("Seleccionar","/images/icon-select.png");
	private int idBulto = -1;
	
	//REMOLQUES
	private MiScrollTable barraRemolqueTable;
	private RemolqueTable remolqueTable;
	
	public DialogDespacharBulto(Dialog owner, List<Remolque> remolques) {
		super(owner,"Seleccionar Ciudad");
		
		setModal(true);
		
		setLayout(new BorderLayout());
		bultoTable = new BultoTable();
		barraBultoTable = new MiScrollTable(bultoTable);
		
		//add(barraBultoTable, BorderLayout.CENTER);
		panelCentral = new JPanel();
		panelCentral.setLayout(new BorderLayout());
		panelCentral.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Bultos sin remolques:"));
		panelCentral.add(barraBultoTable, BorderLayout.CENTER);
		
		panelRemolques = new JPanel();
		panelRemolques.setLayout(new BorderLayout());
		panelRemolques.setBorder(BorderFactory.createTitledBorder(
		        BorderFactory.createEtchedBorder(), "Remolques del camion actual:"));
		panelCentral.add(panelRemolques, BorderLayout.SOUTH);
		remolqueTable = new RemolqueTable();
		barraRemolqueTable = new MiScrollTable(remolqueTable);
		barraRemolqueTable.setPreferredSize(new Dimension(450, 90));
		panelRemolques.add(barraRemolqueTable, BorderLayout.CENTER);
		
		add(panelCentral, BorderLayout.CENTER);
		BultoDAO bultoDAO = new BultoDAO();
		listaBultos = bultoDAO.getBultosSinRemolques();
		bultoTable.agregarTodos(listaBultos);
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
	    return idBulto;
	}
	
	public ActionListener eventoBotonSeleccionar(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	Integer idSelect = bultoTable.getIdSelected();
            	if (idSelect == null)
            		return;
            	idBulto = idSelect;
            	dialogDespacharSeleccionar.setVisible(false);
            	dialogDespacharSeleccionar.dispose();
            }
        };
    }
	
}

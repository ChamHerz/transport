package transport.main;

import transport.dao.SistemaDAO;
import transport.form.FormPrincipal;
import transport.model.Sistema;

public class Transport {
	//OBJETOS
	private Sistema sistema;
	//FORMULARIOS
	private static FormPrincipal formPrincipal;
	
	public Transport() {
		SistemaDAO sistemaDAO = new SistemaDAO();
		this.sistema = sistemaDAO.getSistema();
		
		Transport.formPrincipal = new FormPrincipal();
	}

	public void iniciar() {
		System.out.println(this.sistema.getAutor());
		
		Transport.formPrincipal.setVisible(true);
	}
	
	public static FormPrincipal getFormPrincipal() {
		return formPrincipal;
	}
}

package transport.form;

import java.awt.Dialog;
import java.awt.Dimension;
import java.awt.Point;
import java.util.Locale;

import javax.swing.JDialog;

import transport.main.Transport;

public class MiForm extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiForm(String titulo) {
		super (Transport.getFormPrincipal(),titulo,Dialog.ModalityType.DOCUMENT_MODAL);
		setLocationRelativeTo(Transport.getFormPrincipal());
		setResizable(true);
	}

}

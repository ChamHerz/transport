package transport.dialog;

import java.awt.Dialog;

import javax.swing.JDialog;

import transport.main.Transport;

public class MiDialog extends JDialog {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiDialog(Dialog owner, String titulo) {
		super(owner,titulo,Dialog.ModalityType.DOCUMENT_MODAL);
		setTitle(titulo);
		setLocationRelativeTo(Transport.getFormPrincipal());
		setResizable(true);
	}

	
	
}

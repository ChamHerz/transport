package transport.panel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConductorPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String titulo = "Conductores";

	public ConductorPanel() {
		super();
		this.setName("Conductores");
		this.add(new JLabel("soy Conductor"), BorderLayout.NORTH);
	}
	
	public String getTitulo() {
		return titulo;
	}

}

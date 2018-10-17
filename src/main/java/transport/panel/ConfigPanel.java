package transport.panel;

import java.awt.BorderLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;

public class ConfigPanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private static final String titulo = "Configuracion";

	public ConfigPanel() {
		super();
		this.setName("Configuracion");
		this.add(new JLabel("soy configuracion"), BorderLayout.NORTH);
	}
	
	public String getTitulo() {
		return titulo;
	}
}

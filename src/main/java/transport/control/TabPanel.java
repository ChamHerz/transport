package transport.control;

import java.awt.BorderLayout;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;

import transport.panel.ConductorPanel;
import transport.panel.PanelDe;

public class TabPanel {
	private JTabbedPane jTabbedPane;
	private JFrame jFrameParent;
	private JDesktopPane desktopPanel;
	private BarraHerramienta barraHerramientas;

	public TabPanel() {
		jTabbedPane = new JTabbedPane();
	}
	
	public void setParent(JFrame jFrameParent) {
		this.jFrameParent = jFrameParent;
	}
	
	public void setDeskTop(JDesktopPane desktopPanel) {
		this.desktopPanel = desktopPanel;
	}
	
	public void setHerramienta(BarraHerramienta barraHerramientas) {
		this.barraHerramientas = barraHerramientas;
	}
	
	public JTabbedPane getTabbedPane() {
		return this.jTabbedPane;
	}
	
	public void showPanel(JPanel panel) {
		int indexSiEsta = jTabbedPane.indexOfComponent(panel);
		if (indexSiEsta != -1) {
			//no hago nada si esta.
			jTabbedPane.setSelectedIndex(indexSiEsta);
			return;
		}
		
		int cantidad = jTabbedPane.getTabCount();
		if (cantidad == 0) {
			jFrameParent.getContentPane().removeAll();
			jFrameParent.getContentPane().add(barraHerramientas, BorderLayout.NORTH);
			jTabbedPane.add(panel.getName(), panel);
			jTabbedPane.setTabComponentAt(jTabbedPane.indexOfComponent(panel)
					,new ButtonTabComponent(jTabbedPane, this));
			jFrameParent.getContentPane().add(jTabbedPane, BorderLayout.CENTER);
			jFrameParent.getContentPane().revalidate();
			jFrameParent.getContentPane().repaint();
		}
		else {
			jTabbedPane.add(panel.getName(), panel);
			jTabbedPane.setTabComponentAt(jTabbedPane.indexOfComponent(panel)
					,new ButtonTabComponent(jTabbedPane, this));
		}
		jTabbedPane.setSelectedComponent(panel);
	}
	
	public void colocarDestokSiEstaVacio() {
		if (jTabbedPane.getTabCount() == 0) {
			jFrameParent.getContentPane().removeAll();
			jFrameParent.getContentPane().add(barraHerramientas, BorderLayout.NORTH);
			jFrameParent.getContentPane().add(desktopPanel, BorderLayout.CENTER);
			jFrameParent.getContentPane().revalidate();
			jFrameParent.getContentPane().repaint();
		}
	}
	
	public void agregarSetting() {
		String title = "Otro ";
		jTabbedPane.add(title, new JLabel(title));
	}
	
	public void agregarTab() {
		String title = "Tab ";
		jTabbedPane.add(title, new JLabel(title));
	}
}

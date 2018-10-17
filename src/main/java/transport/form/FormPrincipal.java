package transport.form;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTabbedPane;
import javax.swing.SwingUtilities;

import transport.control.BarraHerramienta;
import transport.control.TabPanel;
import transport.panel.ConductorPanel;
import transport.panel.ConfigPanel;
import transport.panel.PanelDe;

public class FormPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPanel;
	private TabPanel tabPanel;
	private BarraHerramienta barraHerramientas;
	
	private ConductorPanel conductorPanel;
	private ConfigPanel configPanel;
	
	public FormPrincipal() throws HeadlessException {
        this.setTitle("Transport");
        this.setExtendedState(MAXIMIZED_BOTH);

        this.addWindowListener( new SalirSistema() );

        desktopPanel = new JDesktopPane();
        this.getContentPane().add(desktopPanel);
        
        barraHerramientas = new BarraHerramienta();
        barraHerramientas.setEventoBotonChofer(eventoClickBarraConductor());
        barraHerramientas.setEventoBotonSetting(eventoClickBarraSetting());
        this.getContentPane().add(barraHerramientas, BorderLayout.NORTH);
        
        tabPanel = new TabPanel();
        tabPanel.setDeskTop(desktopPanel);
        tabPanel.setHerramienta(barraHerramientas);
        tabPanel.setParent(this);
        
        conductorPanel = new ConductorPanel();
        configPanel = new ConfigPanel();
	}
	
	
	public ActionListener eventoClickBarraConductor(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto el boton chofer de barra herramientas");
                tabPanel.showPanel(conductorPanel);
            }
        };
    }

    public ActionListener eventoClickBarraSetting(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto el boton chofer de barra configuracion");
                tabPanel.showPanel(configPanel);
            }
        };
    }
}


class SalirSistema extends WindowAdapter {
    public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
    }
}
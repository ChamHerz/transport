package transport.form;

import java.awt.BorderLayout;
import java.awt.HeadlessException;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JDesktopPane;
import javax.swing.JFrame;



import transport.control.BarraHerramienta;
import transport.control.TabPanel;
import transport.panel.BultoPanel;
import transport.panel.CamionPanel;
import transport.panel.CiudadPanel;
import transport.panel.ClientePanel;
import transport.panel.ConductorPanel;
import transport.panel.ConfigPanel;
import transport.panel.HojaRutaPanel;
import transport.panel.PedidoPanel;
import transport.panel.RemolquePanel;
import transport.panel.RutaPanel;

public class FormPrincipal extends JFrame {
	private static final long serialVersionUID = 1L;
	
	private JDesktopPane desktopPanel;
	private TabPanel tabPanel;
	private BarraHerramienta barraHerramientas;
	
	private ConductorPanel conductorPanel;
	private ConfigPanel configPanel;
	private CamionPanel camionPanel;
	private RemolquePanel remolquePanel;
	private BultoPanel bultoPanel;
	private CiudadPanel ciudadPanel;
	private ClientePanel clientePanel;
	private PedidoPanel pedidoPanel;
	private RutaPanel rutaPanel;
	private HojaRutaPanel hojaRutaPanel;
	
	public FormPrincipal() throws HeadlessException {
        this.setTitle("Transport");
        //this.setExtendedState(MAXIMIZED_BOTH);
        this.setSize(800, 600);
        this.setLocation(2400, 100);

        this.addWindowListener( new SalirSistema() );

        desktopPanel = new JDesktopPane();
        this.getContentPane().add(desktopPanel);
        
        barraHerramientas = new BarraHerramienta();
        barraHerramientas.setEventoBotonChofer(eventoClickBarraConductor());
        barraHerramientas.setEventoBotonSetting(eventoClickBarraSetting());
        barraHerramientas.setEventoBotonCamion(eventoClickBarraCamion());
        barraHerramientas.setEventoBotonRemoque(eventoClickBarraRemolque());
        barraHerramientas.setEventoBotonBulto(eventoClickBarraBulto());
        barraHerramientas.setEventoBotonCiudad(eventoClickBarraCiudad());
        barraHerramientas.setEventoBotonCliente(eventoClickBarraCliente());
        barraHerramientas.setEventoBotonPedido(eventoClickBarraPedido());
        barraHerramientas.setEventoBotonRuta(eventoClickBarraRuta());
        barraHerramientas.setEventoBotonHojaRuta(eventoClickBarraHojaRuta());
        this.getContentPane().add(barraHerramientas, BorderLayout.NORTH);
        
        tabPanel = new TabPanel();
        tabPanel.setDeskTop(desktopPanel);
        tabPanel.setHerramienta(barraHerramientas);
        tabPanel.setParent(this);
        
        conductorPanel = new ConductorPanel();
        configPanel = new ConfigPanel();
        camionPanel = new CamionPanel();
        remolquePanel = new RemolquePanel();
        bultoPanel = new BultoPanel();
        ciudadPanel = new CiudadPanel();
        clientePanel = new ClientePanel();
        pedidoPanel = new PedidoPanel();
        rutaPanel = new RutaPanel();
        hojaRutaPanel = new HojaRutaPanel();
	}
	
	
	public ActionListener eventoClickBarraConductor(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(conductorPanel);
            }
        };
    }

    public ActionListener eventoClickBarraSetting(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(configPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraCamion(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(camionPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraRemolque(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(remolquePanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraBulto(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(bultoPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraCiudad(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(ciudadPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraCliente(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(clientePanel);
            }
        };
    }

    public ActionListener eventoClickBarraPedido(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(pedidoPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraRuta(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(rutaPanel);
            }
        };
    }
    
    public ActionListener eventoClickBarraHojaRuta(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                tabPanel.showPanel(hojaRutaPanel);
            }
        };
    }
}


class SalirSistema extends WindowAdapter {
    public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
    }
}
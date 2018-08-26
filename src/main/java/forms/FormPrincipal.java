package forms;

import controles.BarraHerramientas;
import controles.Ventana;
import util.VentanaUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FormPrincipal extends JFrame {
    private JDesktopPane desktopPanel;
    private FormChofer formChofer;
    private FormConfiguracion formConfiguracion;

    public FormPrincipal() throws HeadlessException {
        this.setTitle("Transport");
        this.setExtendedState(MAXIMIZED_BOTH);

        this.addWindowListener( new SalirSistema() );

        desktopPanel = new JDesktopPane();
        this.getContentPane().add(desktopPanel);

        BarraHerramientas barraHerramientas = new BarraHerramientas();
        barraHerramientas.setEventoBotonChofer(eventoClickBarraConductor());
        barraHerramientas.setEventoBotonSetting(eventoClickBarraSetting());
        this.getContentPane().add(barraHerramientas, BorderLayout.NORTH);

    }

    public ActionListener eventoClickBarraConductor(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto el boton chofer de barra herramientas");
                if (formChofer == null) {
                    formChofer = new FormChofer();
                }
                VentanaUtil.monstrarVentana(desktopPanel,formChofer);
            }
        };
    }

    public ActionListener eventoClickBarraSetting(){
        return new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.out.println("apreto el boton chofer de barra configuracion");
                if (formConfiguracion == null) {
                    formConfiguracion = new FormConfiguracion();
                }
                VentanaUtil.monstrarVentana(desktopPanel,formConfiguracion);
            }
        };
    }
}

class SalirSistema extends WindowAdapter {
    public void windowClosing( WindowEvent evt ) {
        System.exit( 0 );
    }
}
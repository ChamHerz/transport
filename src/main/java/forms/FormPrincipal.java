package forms;

import controles.BarraHerramientas;

import javax.swing.*;
import java.awt.*;
import java.net.URL;

public class FormPrincipal extends JFrame {

    private JDesktopPane desktopPanel;
    private JButton botonEjemplo;

    public FormPrincipal() throws HeadlessException {
        this.setTitle("Transport");
        this.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);

        desktopPanel = new JDesktopPane();
        this.getContentPane().add(desktopPanel);

        BarraHerramientas barraHerramientas = new BarraHerramientas();
        this.getContentPane().add(barraHerramientas, BorderLayout.NORTH);


    }
}

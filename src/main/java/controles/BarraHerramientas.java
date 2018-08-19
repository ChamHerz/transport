package controles;

import javax.swing.*;

public class BarraHerramientas extends JToolBar {

    private BarraBoton botonConductor;

    public BarraHerramientas() {
        botonConductor = new BarraBoton("Conductor","/images/icon-driver.png");

        this.add(botonConductor);
    }
}
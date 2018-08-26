package controles;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.file.FileSystemNotFoundException;

public class BarraHerramientas extends JToolBar {

    private BarraBoton botonConductor;
    private BarraBoton botonSetting;

    public BarraHerramientas() {
        botonConductor = new BarraBoton("Conductor","/images/icon-driver.png");
        botonSetting = new BarraBoton("Configuracion","/images/icon-setting.png");

        this.add(botonConductor);
        this.add(botonSetting);
    }

    public void setEventoBotonChofer(ActionListener unActionListener) {
        botonConductor.addActionListener(unActionListener);
    }

    public void setEventoBotonSetting(ActionListener unActionListener) {
        botonSetting.addActionListener(unActionListener);
    }
}
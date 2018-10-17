package transport.control;

import java.awt.event.ActionListener;

import javax.swing.JToolBar;

public class BarraHerramienta extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	private BarraBoton botonConductor;
    private BarraBoton botonSetting;

    public BarraHerramienta() {
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

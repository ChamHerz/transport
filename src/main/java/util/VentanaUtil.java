package util;

import controles.Ventana;

import javax.swing.*;
import java.beans.PropertyVetoException;

public class VentanaUtil {

    public static void monstrarVentana(JDesktopPane desktopPanel, Ventana ventana){
        if ( ventana.isVisible() == false) {
            ventana.setVisible(true);
            desktopPanel.add(ventana);
            setFocus(ventana);
            return;
        }
        setFocus(ventana);
    }

    private static void setFocus(Ventana ventana){
        try {
            ventana.setSelected(true);
        } catch (PropertyVetoException e) {
            e.printStackTrace();
        }
    }
}

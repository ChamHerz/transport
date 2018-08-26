package controles;

import objetos.Listas;

import javax.swing.*;

public class Ventana extends JInternalFrame {
    protected static final Listas listas = new Listas();

    public Ventana() {
        super();
    }

    public Ventana(String title, boolean resizable, boolean closable, boolean maximizable, boolean iconifiable) {
        super(title, resizable, closable, maximizable, iconifiable);
        System.out.println("Creacion - Ventana: " + title);
    }
}

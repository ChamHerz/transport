package forms;

import controles.Ventana;
import objetos.Listas;

public class FormChofer extends Ventana {

    public FormChofer() {
        super(Listas.getNombre(), true, true, true, true);
        this.setSize(400,400);
    }

}

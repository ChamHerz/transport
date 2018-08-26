package forms;

import controles.Ventana;
import objetos.Listas;

public class FormConfiguracion extends Ventana {

    public FormConfiguracion() {
        super(Listas.getNombre(), true, true, true, true);
        this.setSize(400,400);
    }
}

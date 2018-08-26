package objetos;

import java.util.ArrayList;
import java.util.List;

public class Listas {

    private static final List<Chofer> listaChofer = new ArrayList<Chofer>();

    public Listas() {
        listaChofer.add(new Chofer("Adriel"));
    }

    public static String getNombre(){
        return listaChofer.get(0).getNombre();
    }
}

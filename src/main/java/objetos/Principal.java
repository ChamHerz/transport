package objetos;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Principal {

    public static void main(String[] args)
    {
        //Seleccion de Piel
        LookAndFeelInfo[] infoLAF;
        infoLAF = UIManager.getInstalledLookAndFeels();
        int seleccion = 1;
        try {
            UIManager.setLookAndFeel(infoLAF[seleccion].getClassName());
        }
        catch (Exception e) {
            //se produjo un error
        }

        //Creacion del Sistema
        Sistema sistema = new Sistema();
        sistema.iniciar();
    }
}

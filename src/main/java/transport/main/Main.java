package transport.main;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Main 
{
    public static void main( String[] args )
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
        
        Transport transport = new Transport();
        transport.iniciar();
    }
}

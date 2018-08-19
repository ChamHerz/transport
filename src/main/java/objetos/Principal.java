package objetos;

import forms.FormPrincipal;

import javax.swing.UIManager;
import javax.swing.UIManager.LookAndFeelInfo;

public class Principal {

    public static void main(String[] args)
    {
        System.out.println("Hola mundo");

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

        //Creacion de MDI
        FormPrincipal formPrincipal = new FormPrincipal();
        formPrincipal.setVisible(true);
    }
}

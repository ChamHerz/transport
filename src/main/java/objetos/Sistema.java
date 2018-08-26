package objetos;

import forms.FormPrincipal;

public class Sistema {
    private String nombre;
    private FormPrincipal formPrincipal;

    public Sistema() {
        System.out.println("se crea Clase Sistema");
        this.nombre = "Sistema de Transporte";

        //Creacion de MDI
        this.formPrincipal = new FormPrincipal();
    }

    public String getNombre(){
        return this.nombre;
    }

    public void iniciar(){
        this.formPrincipal.setVisible(true);
    }
}

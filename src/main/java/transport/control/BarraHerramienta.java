package transport.control;

import java.awt.event.ActionListener;

import javax.swing.JToolBar;

public class BarraHerramienta extends JToolBar {
	
	private static final long serialVersionUID = 1L;
	private BarraBoton botonConductor;
    private BarraBoton botonSetting;
    private BarraBoton botonCamion;
    private BarraBoton botonRemolque;
    private BarraBoton botonBulto;
    private BarraBoton botonPedido;
    private BarraBoton botonCliente;
    private BarraBoton botonCiudad;
    private BarraBoton botonCarretera;
    private BarraBoton botonRuta;
    private BarraBoton botonHojaRuta;
    private BarraBoton botonMovCaja;
    private BarraBoton botonTarifa;

    public BarraHerramienta() {
        botonConductor = new BarraBoton("Conductor","/images/icon-driver.png");
        botonSetting = new BarraBoton("Configuracion","/images/icon-setting.png");
        botonCamion = new BarraBoton("Camion","/images/icon-camion.png");
        botonRemolque = new BarraBoton("Remolque","/images/icon-remolque.png");
        botonBulto = new BarraBoton("Bulto","/images/icon-bulto.png");
        botonPedido = new BarraBoton("Pedido","/images/icon-pedido.png");
        botonCliente = new BarraBoton("Cliente","/images/icon-cliente.png");
        botonCiudad = new BarraBoton("Ciudad","/images/icon-ciudad.png");
        botonCarretera = new BarraBoton("Carretera","/images/icon-carretera.png");
        botonRuta = new BarraBoton("Ruta","/images/icon-ruta.png");
        botonHojaRuta = new BarraBoton("Hoja de Ruta","/images/icon-hoja-de-ruta.png");
        botonMovCaja = new BarraBoton("Movimiento de Caja","/images/icon-caja.png");
        botonTarifa = new BarraBoton("Tarifa","/images/icon-tarifa.png");

        this.add(botonPedido);
        this.add(botonHojaRuta);
        this.add(botonConductor);
        this.add(botonCamion);
        this.add(botonRemolque);
        this.add(botonBulto);
        this.add(botonCliente);
        this.add(botonCiudad);
        this.add(botonCarretera);
        this.add(botonRuta);
        this.add(botonMovCaja);
        this.add(botonTarifa);
        this.add(botonSetting);
    }

    public void setEventoBotonChofer(ActionListener unActionListener) {
        botonConductor.addActionListener(unActionListener);
    }

    public void setEventoBotonSetting(ActionListener unActionListener) {
        botonSetting.addActionListener(unActionListener);
    }
    
    public void setEventoBotonCamion(ActionListener unActionListener) {
        botonCamion.addActionListener(unActionListener);
    }
    
    public void setEventoBotonRemoque(ActionListener unActionListener) {
        botonRemolque.addActionListener(unActionListener);
    }
    
    public void setEventoBotonBulto(ActionListener unActionListener) {
        botonBulto.addActionListener(unActionListener);
    }
    
    public void setEventoBotonPedido(ActionListener unActionListener) {
        botonPedido.addActionListener(unActionListener);
    }
    
    public void setEventoBotonCliente(ActionListener unActionListener) {
        botonCliente.addActionListener(unActionListener);
    }
    
    public void setEventoBotonCiudad(ActionListener unActionListener) {
        botonCiudad.addActionListener(unActionListener);
    }
    
    public void setEventoBotonCarretera(ActionListener unActionListener) {
        botonCarretera.addActionListener(unActionListener);
    }
    
    public void setEventoBotonRuta(ActionListener unActionListener) {
        botonRuta.addActionListener(unActionListener);
    }
    
    public void setEventoBotonHojaRuta(ActionListener unActionListener) {
        botonHojaRuta.addActionListener(unActionListener);
    }
    
    public void setEventoBotonMovCaja(ActionListener unActionListener) {
        botonMovCaja.addActionListener(unActionListener);
    }
    
    public void setEventoBotonTarifa(ActionListener unActionListener) {
        botonTarifa.addActionListener(unActionListener);
    }
}

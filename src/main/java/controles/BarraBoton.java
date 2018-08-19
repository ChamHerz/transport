package controles;

import util.Imagen;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class BarraBoton extends JButton implements MouseListener {

    private Cursor defaultCursor;
    private Cursor handCursor;

    private ImageIcon icon;

    public BarraBoton(String unNombre, String unPathIcon) {
        icon = Imagen.createImageIcon(unPathIcon);
        this.setIcon(icon);
        this.setToolTipText(unNombre);

        defaultCursor = this.getCursor();
        handCursor = new Cursor(Cursor.HAND_CURSOR);

        addMouseListener(this);
    }

    public void mouseClicked(MouseEvent e) {

    }

    public void mousePressed(MouseEvent e) {

    }

    public void mouseReleased(MouseEvent e) {

    }

    public void mouseEntered(MouseEvent e) {
        this.setCursor(handCursor);
    }

    public void mouseExited(MouseEvent e) {
        this.setCursor(defaultCursor);
    }
}

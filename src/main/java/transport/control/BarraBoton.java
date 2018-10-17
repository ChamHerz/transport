package transport.control;

import java.awt.Cursor;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import transport.util.ImagenUtil;

public class BarraBoton extends JButton implements MouseListener {
	private static final long serialVersionUID = 1L;
	private Cursor defaultCursor;
    private Cursor handCursor;

    private ImageIcon icon;

    public BarraBoton(String unNombre, String unPathIcon) {
        icon = ImagenUtil.createImageIcon(unPathIcon);
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

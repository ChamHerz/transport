package transport.control;

import java.awt.Cursor;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import transport.util.ImagenUtil;

public class BotonNormal extends JButton implements MouseListener {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private ImageIcon icon;
	private Cursor defaultCursor;
    private Cursor handCursor;
	
	public BotonNormal(String unNombre, String unPathIcon) {
		icon = ImagenUtil.createImageIcon(unPathIcon);
        this.setIcon(icon);
        this.setText(unNombre);
        this.setHorizontalTextPosition( SwingConstants.RIGHT );
        this.setVerticalTextPosition( SwingConstants.CENTER );
        this.setFont(new Font("Arial", Font.BOLD, 20));
        defaultCursor = this.getCursor();
        handCursor = new Cursor(Cursor.HAND_CURSOR);
        addMouseListener(this);
	}

	@Override
	public void mouseClicked(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setCursor(handCursor);
	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub
		this.setCursor(defaultCursor);
	}

}

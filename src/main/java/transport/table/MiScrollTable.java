package transport.table;

import java.awt.Component;
import java.awt.Cursor;

import javax.swing.JScrollPane;

public class MiScrollTable extends JScrollPane {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiScrollTable(Component view) {
		super(view);
		setCursor(Cursor.getPredefinedCursor(Cursor.HAND_CURSOR));
	}
	
	

}

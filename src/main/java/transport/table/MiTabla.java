package transport.table;

import javax.swing.DefaultListSelectionModel;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;

public class MiTabla extends JTable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public MiTabla() {
		super();
		setSelectionModel(new ForcedListSelectionModel());
	}
	
	public Integer getIdSelected() {
		int column = 0;
    	int row = getSelectedRow();
    	if (row == -1) {
    		JOptionPane.showMessageDialog(this, "No selecciono nada", "Error", JOptionPane.ERROR_MESSAGE);
    		return null;
    	}
    	else {
    		Integer idRow = (Integer) getModel().getValueAt(row, column);
    		return idRow;
    	}
	}

	public void vaciarTabla() {
		MiModelTable miModel = (MiModelTable) getModel();
		for (int i = 0; i < getRowCount(); i++) {
			miModel.removeRow(i);
			i-=1;
		}
	}
}

class ForcedListSelectionModel extends DefaultListSelectionModel {

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public ForcedListSelectionModel () {
        setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
    }

    @Override
    public void clearSelection() {
    }

    @Override
    public void removeSelectionInterval(int index0, int index1) {
    }

}
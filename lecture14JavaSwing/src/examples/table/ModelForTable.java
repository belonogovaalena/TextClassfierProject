package examples.table;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Alena
 */
public class ModelForTable implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private ArrayList<String[]> inner;

    public ModelForTable(ArrayList<String[]> inner) {
        this.inner = inner;
    }
   
    @Override
    public int getRowCount() {
        return inner.size();
    }

    @Override
    public int getColumnCount() {
        return 3;
    }

    @Override
    public String getColumnName(int columnIndex) {
        switch(columnIndex) {
            case 0:
                return "Artist";
            case 1:
                return "Album";
            case 2:
                return "Song";
        }
        return "";
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
            return String.class;
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        String[] thisRow = inner.get(rowIndex);
        return thisRow[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex) {
        String[] thisRow = inner.get(rowIndex);
        thisRow[columnIndex] = (String) aValue;
        inner.set(rowIndex, thisRow);
    }

    @Override
    public void addTableModelListener(TableModelListener l) {
        listeners.add(l);
    }

    @Override
    public void removeTableModelListener(TableModelListener l) {
        listeners.remove(l);
    } 
}
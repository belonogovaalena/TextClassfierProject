/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package JDBC;

import java.util.HashSet;
import java.util.List;
import java.util.Set;
import javax.swing.event.TableModelListener;
import javax.swing.table.TableModel;

/**
 *
 * @author Алена
 */
public class SwingModelForTable implements TableModel{
    private Set<TableModelListener> listeners = new HashSet<TableModelListener>();
    private List<String[]> inner;

    public SwingModelForTable(List<String[]> inner) {
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
                return "ID";
            case 1:
                return "Логин";
            case 2:
                return "Возраст";
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
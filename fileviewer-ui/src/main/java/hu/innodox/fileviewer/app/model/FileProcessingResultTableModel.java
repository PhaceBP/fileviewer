/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.innodox.fileviewer.app.model;

import hu.innodox.fileviewer.dto.ProcessedLine;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 * 
 * @author Attila
 */
public class FileProcessingResultTableModel extends AbstractTableModel {

    private final Class[] colClasses = {String.class, String.class, String.class};

    private final String[] colNames = {"Processing time", "Processor Thread name", "Processed line"};

    private final List<ProcessedLine> processedLines;

    public FileProcessingResultTableModel() {

        this.processedLines = new ArrayList<>();
    }

    @Override
    public int getRowCount() {
        return processedLines.size();
    }

    @Override
    public int getColumnCount() {
        return colNames.length;
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {

        ProcessedLine actualLine = processedLines.get(rowIndex);

        switch (columnIndex) {
            case 0:
                return actualLine.getProcessingDate();
            case 1:
                return actualLine.getThreadName();
            case 2:
                return actualLine.getLine();
            default:
                throw new IllegalArgumentException("Invalid column index!");
        }
    }

    @Override
    public Class<?> getColumnClass(int columnIndex) {
        return colClasses[columnIndex];
    }

    @Override
    public void setValueAt(Object aValue, int row, int column) {
        throw new UnsupportedOperationException("Not implemented yet!");
    }

    @Override
    public String getColumnName(int column) {
        return colNames[column];
    }

    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex) {
        return false;
    }

    public void clearModel(){
        this.processedLines.clear();
    }
    
    public void addToModel(List<ProcessedLine> lines){
        this.processedLines.addAll(lines);
        this.fireTableDataChanged();
    }
}

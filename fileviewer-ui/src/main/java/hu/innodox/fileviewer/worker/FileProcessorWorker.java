/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.innodox.fileviewer.worker;

import hu.innodox.fileviewer.app.model.FileProcessingResultTableModel;
import hu.innodox.fileviewer.dto.ProcessedLine;
import hu.innodox.fileviewer.utils.FileProcessorUtils;
import java.io.File;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingWorker;


public final class FileProcessorWorker extends SwingWorker<List<ProcessedLine>,Void> {

    
    private final File actualFile;
    
    private final FileProcessingResultTableModel model;
    
    private final UIRefreshWorker worker;
    
    public FileProcessorWorker(File file, FileProcessingResultTableModel tableModel,UIRefreshWorker worker){
        this.actualFile = file;
        this.model = tableModel;
        this.worker = worker;
    }
    
    @Override
    protected List<ProcessedLine> doInBackground() throws Exception {
        
        Thread.sleep(4000); // For the tesing
        return FileProcessorUtils.readAndProcessFilePerLine(actualFile);
    }

    @Override
    protected void done() {
        
        try {
            List<ProcessedLine> result = get();
            this.model.addToModel(result);
            worker.increaseNumOfExecutedTasks();
        } catch (InterruptedException | ExecutionException ex) {
            Logger.getLogger(FileProcessorWorker.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
    
}

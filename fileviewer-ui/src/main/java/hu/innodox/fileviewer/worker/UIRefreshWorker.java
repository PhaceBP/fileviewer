/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.innodox.fileviewer.worker;

import hu.innodox.fileviewer.app.UIRefreshCallback;
import java.util.concurrent.atomic.AtomicInteger;
import javax.swing.SwingWorker;

/**
 *
 * @author 212470319
 */
public class UIRefreshWorker extends SwingWorker<Void, Void> {
    
    
    
    private final AtomicInteger numOfExecutedTaks;
    
    private final Integer numOfTasks;
    
    private final UIRefreshCallback callback;
    
    
    
    public UIRefreshWorker(Integer numOfTask, UIRefreshCallback callback){
        
        this.numOfTasks = numOfTask;
        this.numOfExecutedTaks = new AtomicInteger(0);
        this.callback = callback;
        
    }

    @Override
    protected Void doInBackground() throws Exception {
        
        while(numOfTasks != numOfExecutedTaks.intValue()){
            
            System.out.println("We are waiting for the finising of process....");
        }
        
        return null;
    }

    @Override
    protected void done() {
        callback.refreshUI();
    }
    
    
    public void increaseNumOfExecutedTasks(){
        this.numOfExecutedTaks.incrementAndGet();
    }
    
}

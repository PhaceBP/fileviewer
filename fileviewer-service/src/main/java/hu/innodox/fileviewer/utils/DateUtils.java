/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hu.innodox.fileviewer.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author 212470319
 */
public final class DateUtils {
 
    
    
    private DateUtils(){
        
    }
    
    public static String getCurrentTimeStamp() {
        SimpleDateFormat sdfDate = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//dd/MM/yyyy
        Date now = new Date();
        String strDate = sdfDate.format(now);
        return strDate;
    }
}

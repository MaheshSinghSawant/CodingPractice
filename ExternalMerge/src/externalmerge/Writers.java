/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalmerge;

import java.io.File;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mahesh
 */
public class Writers {
    
    public final int PAGESIZE = 2000;
    public int x[] = new int [PAGESIZE];
    
    private Formatter output;
    
    
     public void openFile(){
        
        try{
           
            output = new Formatter("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/output.txt");
            
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }
     
     
     
     public void addRecords(){
         
     
        {
            
            
        }
     }
         public void closeFile(){
        
        output.close();
    }
}

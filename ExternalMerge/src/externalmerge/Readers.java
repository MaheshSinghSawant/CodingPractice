/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package externalmerge;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Mahesh
 */
public class Readers {
    
      public final int PAGESIZE = 2000;
      public Scanner input;
      public Scanner output;
      public int firstBuffer[]  = new int [PAGESIZE];
      public int secondBuffer[]  = new int [PAGESIZE];
      public int outputBuffer[]  = new int [PAGESIZE*10];
      
      
     

    public void openFile(){
        
        
        try{
            input = new Scanner(new File("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/age.txt"));
            
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }
    
    public void writeToFile()
    {
        Writers w =  new Writers();
        w.openFile();
        
//        w.closeFile();
    }
    
    public void readFile(){
        
        try
        {
            FileWriter fw = new FileWriter("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/output.txt", true);
            BufferedWriter bw = new BufferedWriter(fw);
            PrintWriter out = new PrintWriter(bw);
        }
        catch (Exception e) {}
        
        
        input.useDelimiter(",");
        int i;
        while(input.hasNext())
        { 
            
                for(i=0;i<PAGESIZE;i++)
                {
                   int a = input.nextInt();
                    firstBuffer[i] = a; 
                        
                }
                
//                for (i=0;i<PAGESIZE;i++)
//                {
//                   int a = input.nextInt();
//                    secondBuffer[i] = a; 
//                }

        }
        
 
        // creating obj of quicksort class and calling sort()
        MyQuickSort sorter = new MyQuickSort();
        sorter.sort(firstBuffer);

            for ( i = 0; i<PAGESIZE; i++){
                
                outputBuffer[i] = firstBuffer[i];
                 
            }
    }
    
    public int[] sendToWrite(){ 
        return outputBuffer;
    }
    
//    public void writeToFile()
//    {
//        Writers w =  new Writers();
//        w.openFile();
//        w.x =this.sendToWrite();
//        w.addRecords();
//        w.closeFile();
//    }


    public void closeFile(){
        
        input.close();
    }
    
}

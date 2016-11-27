package exmachina;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Formatter;
import java.util.Scanner;

public class ExMachina {
    
    public final String PATH = "/Users/Mahesh/NetBeansProjects/ExMachina/src/exmachina/";
    public byte[] b = new byte[4096];
    public final int parseZeroBuffer[] = new int[b.length];
    public Scanner input;
    public Formatter output;
    
    public void doFile(){
        
        
        try{
            input = new Scanner(new File(PATH+"mage.txt"));
            
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
        
        input.useDelimiter(",");
        int i;
        int n=0;
        int y = b.length;
        System.out.println(y);
        while(input.hasNext())
        { 
            
                for(i=0;i<b.length;i++)
                {
                   int a = input.nextInt();
                    parseZeroBuffer[i] = a;         
                }
                writeFile(parseZeroBuffer,n);
                n++;  
        }
    }
    
    public void writeFile(int outputBuffer[], int n){
        
        try{
            output = new Formatter(PATH+n+".txt");
            for(int i =0;i<b.length;i++){
            output.format("%d,", outputBuffer[i]);
            }
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }
    
    
    public static void main(String[] args) {
        
        ExMachina x = new ExMachina();
        x.doFile();
        
    }
    
}

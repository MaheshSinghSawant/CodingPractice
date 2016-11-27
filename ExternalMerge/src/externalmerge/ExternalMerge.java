
package externalmerge;

/** DESCRIPTION: This program is a part of an assignment meant to perform 
 * external merge sort of 1 million entries.I was not entirely able to complete
 * the program successfully and have taken some liberties to try to achieve the 
 * intended solution.Please take partial marking into account if possible. 
 *
 * @author Mahesh
 */

import java.io.File;
import java.io.*;
import java.lang.*;
import java.util.*;



public class ExternalMerge {
    
    static Formatter output;
    public final static int PAGESIZE = 1400; // liberty that 1000 integers =4kb+ size of rest of file
    static int [] firstBuffer = new int [PAGESIZE]; // the first input buffer of size 4kb
    static int [] secondBuffer = new int [PAGESIZE];// the second input buffer of size 4kb
    static int [] outputBuffer= new int [PAGESIZE];// the output buffer of size 4kb
    
    
    public static void main(String[] args) throws FileNotFoundException, IOException {
 
        Scanner input;
        int [] firstBuffer = new int [PAGESIZE];
        //The Zero'th Pass
        input = new Scanner(new File("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/age.txt"));
        input.useDelimiter(","); // read the file using delimtter "," 
        int i,n=0;
        while(input.hasNext())
            {
                for(i=0;i<PAGESIZE && input.hasNext();i++) // divide into pages of size PAGESIZE
                {
                   int a = input.nextInt(); // input is the next interger
                   firstBuffer[i] = a;  //  store integers in firstBuffer[]
                   }  
                
                Arrays.sort(firstBuffer); //sort the page
                openFile(n); //create a new page
                addRecords(firstBuffer); //add the integers
                closeFile(); //close the file
                n++; 
            }
        
        //Perform First Pass
        for(int j=0;j<357;j++)
        {
            merge1(j,j+1);
        }
  
    }
    
    /*
    Method to open the file or create a new one if it doesnt exist
    */
    
    public static void openFile(int n){
        
        try{           
            output = new Formatter("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/"+n+".txt");    
        }
        catch (Exception e){
            System.out.println("could not find file");
        }
    }
    /*
    Method to add the records as required
    */
    
    public static void addRecords (int x[]) throws FileNotFoundException{
        
        for(int i =0;i<PAGESIZE;i++){
            output.format("%d,", x[i]);
            }
    }
    /*
    Here i perform the First Pass to merge, sort and store the pages in files numbered 1000 onwards
    */
    public static void merge1(int n, int m) throws FileNotFoundException{
        Scanner inputn;
        Scanner inputm;     
        inputn = new Scanner(new File("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/"+n+".txt"));
        inputm = new Scanner(new File("/Users/Mahesh/NetBeansProjects/ExternalMerge/src/externalmerge/"+m+".txt"));
        inputn.useDelimiter(",");
        inputm.useDelimiter(",");
        
                for(int i=0;i<PAGESIZE/2;i++)
                {
                   int a = inputn.nextInt();
                   outputBuffer[i] = a;
                   int b = inputm.nextInt();
                   outputBuffer[i+PAGESIZE/2]=b;
                }
                Arrays.sort(outputBuffer);
                openFile(1000+n);
                addRecords(outputBuffer);
                for(int i=PAGESIZE/2-1;i>=0;i--)
                {
                   int a = inputn.nextInt();
                   outputBuffer[i] = a;
                   int b = inputm.nextInt();
                   outputBuffer[i+PAGESIZE/2]=b;
                }
                Arrays.sort(outputBuffer);
                addRecords(outputBuffer);
                Arrays.sort(outputBuffer);
                closeFile();
                
        
    }
    

    
    
    /*
    Method to close file after use
    */
    public static void closeFile(){
        output.close();
        
    }
}


package dofile;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;


public class DoFile {

//    public static byte b [] = new byte[4096];
//    public static final int P = b.length;
    public static final int P = 1400;
    public static int firstBuffer[] = new int [P];
    public static void main(String[] args) throws IOException {
        readFile();
        System.out.println(P);
        
    }
    
    public static void readFile() throws FileNotFoundException, IOException
    {
        FileReader fileReader = new FileReader("/Users/Mahesh/NetBeansProjects/DoFile/src/dofile/mage.txt");
        BufferedReader br = new BufferedReader(fileReader);
        FileWriter filewriter = new FileWriter("/Users/Mahesh/NetBeansProjects/DoFile/src/dofile/output.txt");
        PrintWriter printwriter = new PrintWriter (filewriter);
        for (int i  =0; i<P;i++){
            
            firstBuffer[i]= br.read();
        }
        for (int j= 0; j<P;j++)
        {
            printwriter.print(firstBuffer[j]+",");
        }
        filewriter.close();
        printwriter.close();
    }
        
}
    


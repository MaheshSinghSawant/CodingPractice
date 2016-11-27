/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package easeup;

import java.util.Arrays;

/**
 *
 * @author Mahesh
 */
public class Easeup {

    
    public static void main(String[] args) {
        
        int i;
        int n =2;
        int count;
        
        int a[] = {1,2,3,4,5,6,7,8};
        int b[] = {9,9,9,9,9,9,9,9};
        int limit = (a.length)/(2*n);
        System.out.println(limit);
        int c[] = new int [4];
        
            for(int k=0;k<8;k++)
            {
                for(i=0;i<2;i++)
                {
                    for (int j=2;j<4;j++){
                    
                    c[i] = a[k];
                    c[j] =b[k];
                    }
                         
                }
        
        output(c);
        }
    }
       
        
    
    public static void output(int x[])
    {
        int i;
      for(i=0;i<4;i++){
            
            System.out.print(x[i]+",");
        }  
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication27;

import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author Mahesh
 */
public class JavaApplication27 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    
      boolean a = isPermutation("abcs","caba"); 
      if (a)
      {
          System.out.println("is permutation");
          
      }
      else
          System.out.println("NOT");
      
      changeToChar("wobuffet");
      
      
        
        
  }    
    
    public static boolean isPermutation(String s, String t){
        
        if(s.length()!=t.length())
            return false;
        
        int letters[] = new int[128];
        for (int i= 0; i<s.length(); i++)
        {
            letters[s.charAt(i)]++;
            
        }
        
        
        for (int i= 0; i<t.length(); i++)
        {
            letters[t.charAt(i)]--;
            if(letters[t.charAt(i)]<0)
                return false;
            
        }
       
        return true;
    }
    
    public static void changeToChar(String s){
    
    char [] c = s.toCharArray();
    Arrays.sort(c);
    for(int i = 0; i<c.length; i++){
            
            System.out.print(c[i]);
        }
    
    }
}

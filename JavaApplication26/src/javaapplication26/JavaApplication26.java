/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication26;

import java.util.Scanner;

/**
 *
 * @author Mahesh
 */
public class JavaApplication26 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter a string");
        String input = sc.nextLine();
        boolean a = isUnique(input);
        if(a)
            System.out.println("Unique");
        if(!a){
            System.out.println("Not Unique");
        }
    }
    
    public static boolean isUnique(String str){
        
        if(str.length()>128)
            return false;
        
        boolean charSet[] = new boolean[128];
        
        for(int i=0;i<str.length(); i++)
        {
            int val = str.charAt(i);
            System.out.println(val);
            if (charSet[val])
                return false;
            charSet[val] = true;    
        }
                
        return true;
       
    }
    
   
    
}

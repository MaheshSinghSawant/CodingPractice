/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication28;

import java.util.*;


public class JavaApplication28 {

    
    public static void main(String[] args) {
        
        LinkedList<String> list = new LinkedList<String>();
        String stuff[] = {"a", "b", "c", "d"};
        
        for(int i=0; i < stuff.length; i++){
            
            list.add(stuff[i]);
        }
        
        reverseMe(list);
        
    }
    
    public static void printMe(List<String> l)
    {
        for (int i=0; i<l.size();i++)
        {
            System.out.printf("%s ", l.get(i));
        }
        System.out.println();
    }
    
    public static void reverseMe(List<String> l){
    
       ListIterator<String> it= l.listIterator(l.size());
       while(it.hasPrevious())
       {
           System.out.printf("%s ", it.previous());
       }
        
    } 
    
    
    
}

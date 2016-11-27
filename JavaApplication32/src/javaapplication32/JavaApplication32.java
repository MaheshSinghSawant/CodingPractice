/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication32;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.*;

/**
 *
 * @author Mahesh
 */
public class JavaApplication32 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        Character [] arr = {'a','b','c'};
        
        LinkedList<Character> list = new LinkedList<Character>(Arrays.asList(arr));
        
        list.addFirst('d');
        
        Collections.sort(list, Collections.reverseOrder());
        
        
        String [] arr2 =  list.toArray(new String [list.size()]);
        
        for(int i= 0; i<arr2.length;i++)
        {
            System.out.print(arr2[i]+" ");
        }
        
    }
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication31;

/**
 *
 * @author Mahesh
 */

import java.util.*;
import java.io.*;

public class JavaApplication31 {

    
    public static void main(String[] args) {
       
        Scanner sc = new Scanner(System.in);
        String input = sc.nextLine();
        count(input);       
    }
    
    public static int count(String str)
    {
        List<String> subs = new ArrayList<String>();
        List<String> subsmod = new ArrayList<String>();
        List<String> subsequal = new ArrayList<String>();
        List<String> subsfinal = new ArrayList<String>();
        
        String sub;
        int  length = str.length();
        int hasht[] = new int [2]; 
        
        for( int c = 0 ; c < length ; c++ )
        {
         for( int i = 1 ; i <= length - c ; i++ )
         {
            sub = str.substring(c, i+c);
            subs.add(sub);
            
         }
        }
        
        for(String x: subs)
        {
            if(x.length() %2 == 0)
            {
                subsmod.add(x);
            }
        }
        
        
        
        
        for (int i =0; i<subsmod.size();i++)
        {
            String z = subsmod.get(i);
            
            if ((z.indexOf('0')>=0) && (z.indexOf('1')>=0))
            {
            
            char [] arr = z.toCharArray();
            
            for (int j= 0; j<arr.length; j++)
            {
                if (arr[j]=='0')
                {
                    hasht[0]++;
                    
                }
                if (arr[j]=='1'){
                    hasht[1]++;
                }
            }
            
            int sum = hasht[0] - hasht[1];
            
            if(sum==0)
            {
                subsequal.add(z);
            }
            
            hasht[0]=0;
            hasht[1]=0;
            }
            
            else{
                continue;
            }
            
        }
        

        
        System.out.println();
        
        
        for(String z: subsequal)
        {
            char [] arr = z.toCharArray();
            int a = z.indexOf('0');
            int b = z.indexOf('1');
            
            if(a<b)
            {
                int c = z.indexOf('0',b);
                if(c== -1)
                {
                    subsfinal.add(z);
                }
            }
            
            if(a>b)
            {
                int c = z.indexOf('1',a);
                if(c== -1)
                {
                    subsfinal.add(z);
                }
            }
                    
        }
        
        Set<String> set = new HashSet<String>(subsfinal);
        
        for(String y: set)
        {
            System.out.print(y + " ");
        }
        
        System.out.println();
        
        return subsfinal.size();
    }
    
    
    
}

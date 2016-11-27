/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hashbrowns;

import java.util.*;

public class Hashbrowns {

    
    public static void main(String[] args) {

       String [] meh = {"dog", "cat", "dog", "parrot"};
        HashMap<String, Integer> table = dict(meh);
        getfre(table);
        
        
    }
    
    static HashMap<String, Integer> dict (String [] book){
        
        HashMap<String, Integer> table = new HashMap<String, Integer>();
        
        for (String word: book) {
            
            word.toLowerCase();
            if(word.trim()!=""){
                
                if(!table.containsKey(word))
                {
                    table.put(word, 0);
                }
                
                table.put(word, table.get(word) + 1);
            }
            
        }
        
        return table;
    }
        
    static int getfre(HashMap<String, Integer> table ){
        
        for(String word: table.keySet())
        {
            System.out.println(word + ":" + table.get(word));
        }
        
         System.out.println(table.size());
        
    return 0;
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package palindromeperm;


public class PalindromePerm {

    public static void main(String[] args) {
        
        String s = "madam im adam";
        boolean meh = isPalinperm(s);
        
        if(meh)
        {
            System.out.println("PalinPermutation");
        }
        
        else
        {
            System.out.println("NOT");
        }
        
           
    }
    
    public static boolean isPalinperm(String s)
    {
    
    int tableu[] = createTable(s);
    return checkmaxodd(tableu);
    }
    
    public static boolean checkmaxodd(int [] table)
    {
        boolean isOdd =false;
        for (int count : table)
        {
            if(count%2==1)
            {
                if(isOdd)
                {   
                    return false;
                }
                
                isOdd= true;
            }
        }
        
    return true;
    }
    
    public static int getNumericValue(char x){
    
        int a = Character.getNumericValue('a');
        int z = Character.getNumericValue('z');
        int val = Character.getNumericValue(x);
        
        if(val>=a && val<=z)
            return val-a;
        
        return -1;
    }
    
    public static int[] createTable(String s){
    
    int table[] = new int[Character.getNumericValue('z') - Character.getNumericValue('a') + 1];
    for (char x : s.toCharArray())
    {
        int alpha = getNumericValue(x);
        
        if(alpha!=-1)
            table[alpha]++;
        
    }
        
    return table;
    
    
    }
    
}

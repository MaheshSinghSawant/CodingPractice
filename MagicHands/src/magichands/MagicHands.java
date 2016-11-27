/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package magichands;

import java.util.Random;

/**
 *
 * @author Mahesh
 */
public class MagicHands {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        
        Random a = new Random();
        Random b = new Random();
        int mahesh;
        int adam;
        String mdeck="a ";
        String adeck="a ";
        
       
        mahesh  = 1 + a.nextInt(7);
        adam  = 1 + b.nextInt(7);
        
        switch(mahesh){
                case 1: mdeck = "White Red";
                    break;
                case 2: mdeck = "Blue Black";
                    break;
                case 3: mdeck = "Black Green";
                    break;
                case 4: mdeck = "Black White";
                    break;
                case 5: mdeck = "Blue Red";
                    break;
                case 6: mdeck = "Mono Red";
                    break;
                case 7: mdeck = "White Blue";
                    break;      
        }
        
        switch(adam){
                case 1: adeck = "White Red";
                    break;
                case 2: adeck = "Blue Black";
                    break;
                case 3: adeck = "Black Green";
                    break;
                case 4: adeck = "Black White";
                    break;
                case 5: adeck = "Blue Red";
                    break;
                case 6: adeck = "Mono Red";
                    break;
                case 7: adeck = "White Blue";
                    break;      
        }
        
        if (mahesh == adam){
          System.out.println("Same Deck, Run Again ");   
        }
        else{
        System.out.println("Mahesh's Deck is going to be: " + mdeck); 
        System.out.println("Adam's Deck is going to be: "+ adeck);
        }
    }
    
}

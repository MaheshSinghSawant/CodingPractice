/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cellularautomation;
import java.util.Scanner;

/**Description: This project performs cellular automation, ie , after each step
 * the cellular arrangement is changed according to a set of rules.
 *
 * @author Linda
 * @version:4/27/2016 
 */
public class CellularAutomation {

    public static void main(String[] args) {  
        Scanner input = new Scanner(System.in);
        int C; //the number of cells
        int N; //the number of timesteps
        int check; // to check for which of the indices of cell[] to put 1 into
        System.out.println("Welcome to the cellular automaton simulation!");
        System.out.println("Enter number of cells (<= 80): ");
        C = input.nextInt(); //input number of cells
        int cell[] = new int[C]; // array of C length
        int indices[] = new int [C]; // array to check for indices
        System.out.println("Enter number of time steps:");
        N = input.nextInt(); //input timesteps
        System.out.println("Enter the index of occupied cells (negative index to end):");
        for(int i = 0; i<C;i++){
            
            check = input.nextInt(); //check next input if <0 break
            if(check<0)
            {
                break;
            }
            else{
                indices[i]=check;
                cell[check] = 1;
            }     
        }

        
        for(int i = 0; i<C;i++){            
            System.out.print(i%10);     // print ruler for the cell indices        
        }
        System.out.println();
        displayCells(cell); // print initial arrangement
        for(int i= 0; i<N;i++)
            updateCells(cell); //call update cells to perform cellular automation
    }
    /**
    *This method is used to display # where the cell cell array has 1 and space
    *if it has 0. It has argument data[] to know which array to print.
    * 
    */
    public static void displayCells(int data[]){
        
        for(int i= 0; i<data.length;i++){

            if (data[i]==1)
            {
                System.out.print("#");
            }
            else
              {
                System.out.print(" ");
            }  
        }
        System.out.println();
    }
    
    /**
     *This method is used to update the cell[] according to the rules, 
     * it has input argument as the cell array at first and then the updated 
     * arrays,  it also calls the displayCells method with the updated array. 
     *
     */
    
    public static void updateCells(int data[]){
        
        int tempArray[] = new int [data.length];
        
        for(int i=0; i<data.length; i++){
            
        tempArray[i] = data[i];   
        }
        
        for(int i=1; i<data.length-1; i++){
            
            if(data[i-1]==1 && data[i]==1 &&data[i+1]==1){
                
                tempArray[i]=0;
            }
            if(data[i-1]==1 && data[i]==1 &&data[i+1]==0){
                
                tempArray[i]=1;
            }
            if(data[i-1]==1 && data[i]==0 &&data[i+1]==1){
                
                tempArray[i]=1;
            }
            if(data[i-1]==1 && data[i]==0 &&data[i+1]==0){
                
                tempArray[i]=0;
            }
            if(data[i-1]==0 && data[i]==1 &&data[i+1]==1){
                
                tempArray[i]=1;
            }
            if(data[i-1]==0 && data[i]==1 &&data[i+1]==1){
                
                tempArray[i]=1;
            }
            if(data[i-1]==0 && data[i]==0 &&data[i+1]==1){
                
                tempArray[i]=1;
            }
            if(data[i-1]==0 && data[i]==0 &&data[i+1]==0){
                
                tempArray[i]=0;
            }
            
            
        }
        
        displayCells(tempArray);
        
        for(int i=0; i<data.length; i++){
            
            data[i] = tempArray[i] ;   
        }
        
    }
    
}

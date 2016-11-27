package conway;

import java.util.Scanner;

/**Description: This project performs Conway Game of Life, following its rules.
 * @author Linda
 * @version:5/03/2016
 */
public class Conway {

    public static void main(String[] args) 
    {
        int grid[][] = new int [10][10]; 
        Scanner input = new Scanner(System.in);
        System.out.println(" Enter a list of (i,j) pairs, both non­negative integers \n" +
                           "(stop when a negative integer is read for either i or j): ");
        int indexi = input.nextInt();   //input i of grid
        int indexj = input.nextInt();   //input j of grid
        while(indexi >0 && indexj>0)
        {
            grid[indexi][indexj] =1;    //insert 1 for the indexes entered 
            indexi = input.nextInt();   //check next indexes
            indexj = input.nextInt();   
        }
        int steps;  //time steps
        System.out.println("Enter the number of time steps: ");
        steps = input.nextInt();
        int allsteps= steps;
        System.out.println("Initial Grid ");
        displayGrid(grid); //call display which displays grid
        while (steps>0)
        {
            System.out.println("Time step " + (-(steps-allsteps)+1)); 
            updateGrid(grid); // call the updategrid method
            steps--;
        }    
    }
    
    /**
    *This method is used to display # where the grid element has 1 and space
    *if it has 0. It has argument grid[][] to know which grid element to print. 
    * @param grid
    */
    public static void displayGrid(int grid[][])
    {
        for(int k = 0; k<10;k++)
        {
        System.out.print(k);
        }
        System.out.println();
        for (int i =0; i<10;i++)
        {
            for(int j = 0; j<10;j++)
            {
                if (grid[i][j]==1)
                    System.out.print("#");
                else 
                    System.out.print(" ");
            }
        System.out.println(i);
        }
    }
    
    /**
    *This method is used to update grid according to Conways rules and calls display  
    * @param grid
    */
    public static void updateGrid(int grid[][])
    {

        int tempGrid [][] = new int [10][10];
        for (int i =0; i<10;i++)
        {
            for (int j = 0; j<10;j++)
            {
                tempGrid[i][j] = grid[i][j];
            }
        }
         for (int i =1; i<9;i++)
        {
            for (int j = 1; j<9;j++)
            {
                //check neighbors
                int neighbors = grid[i-1][j-1]+grid[i-1][j]+grid[i-1][j+1]+grid[i][j-1]+grid[i][j+1]+grid[i+1][j-1]+grid[i+1][j]+grid[i+1][j+1];
                if (grid[i][j]==1 && ((neighbors>=4 || neighbors<=1))) // check rules
                {
                    tempGrid[i][j] =0;
                }
                else if (grid[i][j]==0 && neighbors==3) //check rules
                {
                    tempGrid[i][j] =1;
                }
            }
        }
        displayGrid(tempGrid);  //display the grid
        for (int i =0; i<10;i++)
        {
            for (int j = 0; j<10;j++)
            {
                grid[i][j]=tempGrid[i][j];  //change the original grid
            }
        }
        
    }
}

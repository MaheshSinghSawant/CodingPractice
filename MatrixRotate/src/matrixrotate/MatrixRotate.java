/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package matrixrotate;

import java.util.Scanner;


public class MatrixRotate {

    
    public static void main(String[] args) {
        
     int m,n;
     Scanner sc = new Scanner(System.in);
     m = sc.nextInt();
     n= sc.nextInt();
     int [][] matrix = new int[m][n];
     
     System.out.print("Enter space separated intergers for matrix");
     
     for (int i=0; i<m;i++)
     {
         for(int j=0; j<n;j++){
             
             matrix[i][j]= sc.nextInt();
         }
     }
     
     show(matrix,m,n);
     System.out.println();
     rotatematrix(matrix);
        
        
    }
    
    public static void show(int [][] matrix, int m, int n){
    
    for (int i=0; i <m; i++){
        for (int j=0; j<n;j++)
        {
            System.out.print(matrix[i][j]+ " ");
        }
        System.out.println();
    }
    }
    
    public static void rotatematrix(int [][] matrix){
            
        int n = matrix.length;
        
        
        for(int layer=0; layer<n/2; layer++)
        {
            int first= layer;
            int last= n-layer-1;
            
            for (int i= first; i<last; i++)
            {
                int offset = i- first;
                int top = matrix[first][i];
                matrix[first][i] = matrix[last-offset][first];
                matrix[last-offset][first] = matrix[last][last-offset];
                matrix[last][last-offset] = matrix[i][last];
                matrix[i][last] = top;
                
            }
        }
        
        show(matrix,n,n);
        
    }
    
    
}

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package treesss;

/**
 *
 * @author Mahesh
 */
public class BinaryTree {

    static class Node{
    
        int key;
        Node left, right;
        
        public Node(int item){
            key= item;
            left=right=null;
        }
    
    }
    
    Node root;
    
    BinaryTree(int item){
    
        root.key = item;
    
    }
    
    public static void main(String[] args) {
        
        
        BinaryTree tree = new BinaryTree(1);
        tree.root = new Node(2);
        
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        System.out.println();
             
        
    }
    
    

    
}

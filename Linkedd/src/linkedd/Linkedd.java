
package linkedd;

import java.util.*;

public class Linkedd {

    public static void main(String[] args) {
        // TODO code application logic here

        Stack<Integer> stack = new Stack<Integer>();
        
        stack.push(99);
        stack.push(62);
        stack.push(84);
        stack.push(76);
        stack.push(90);
        
        
        
        Collections.sort(stack);
        
        System.out.printf("%s", stack);
        
    }
     
}

class LinkedListNode{
    
    public LinkedListNode next = null;
    public Object data;
    
    public LinkedListNode(Object d){
        
        this.data = d;
        this.next = null;
        
    }
    
    void appendToTail(Object d){
        
        LinkedListNode end = new LinkedListNode(d);
        LinkedListNode n = this;
        while (n.next!=null)
        {
            n = n.next;
        }
        
        n.next= end;
        //end.next = null;
        
        
    }
    
}

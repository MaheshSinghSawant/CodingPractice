
package boston;

import java.util.*; 

public class Boston {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        String[] things = {"apples", "bananas", "mangoes"};
        
        List<String> list1 = new ArrayList<String>();
        List<String> list2 = new ArrayList<String>();
        
        for (String x: things){
            
            list1.add(x);
        }
        
        list2.add(0,"apples");
        list2.add(1,"veg");
        list2.add(2,"nonveg");

        
        copy(list1,list2);
        
        for (int i=0; i<list1.size();i++)
        {
            System.out.println(list1.get(i));
        }
          
        
        
    }
    
    
    static void copy (Collection<String> l1, Collection<String> l2){
            
       Iterator<String> it = l1.iterator();
        while(it.hasNext())
        {
            if(l2.contains(it.next()))
                it.remove();
        }
            
        }
    
    
}

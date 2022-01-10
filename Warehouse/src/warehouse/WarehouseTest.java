
package warehouse;

import java.util.Arrays;

/**
 *
 * @author Owner
 */
public class WarehouseTest {
    
     private static <T> void addSeries(BagInterface<T> aBag, T[] content)
    {
        //System.out.print("Adding the following " + content.length + " strings to the bag: ");
        for(int i = 0; i < content.length; i++)
        {
            aBag.add(content[i]);
               //System.out.print(content[i] + " ");
            //else 
                //System.out.print("\nUnable to add " + content[i] + " to the bag.");
        }
        //System.out.println();
        
    }
     

    public static void main (String[] args)
    {
        
        Object[] a1 = new Object[15];
        Object[] a2 = new Object[10];
        Object[] a3 = new Object[10];
        
        BagInterface<Object> bag1 = new Warehouse(a1);
        
        Product p1 = new Product("soap", "Dove", 7.99, 1);
        Product p2 = new Product("soap", "Olay", 8.99, 2);
        Product p3 = new Product("soap", "Nexus", 12.99, 3);
        
        for(int i = 0; i < 3; i++)
        {
            a1[i] = p1;
        }
        for(int i = 3; i < 8; i++)
        {
            a1[i] = p2;
        }
        for(int i = 8; i < 10; i++)
        {
            a1[i] = p3;
        }
        
        
        a2[0] = p2;
        addSeries(bag1, a1);
        addSeries(bag1, a2);
        
       
       
        
        
        Object [] b1 = bag1.toArray();
        for(int i = 0; i < b1.length ; i++)
            System.out.println(b1[i]);
        

        
        System.out.println(bag1.getFrequencyOf(p1));
        System.out.println(bag1.getFrequencyOf(p2));
        System.out.println(p1.getID());
        
        
        
    }
    
    
}

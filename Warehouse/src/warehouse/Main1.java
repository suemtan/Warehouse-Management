
package warehouse;

import java.util.Arrays;

/**
 *
 * @author Owner
 */


public class Main1 
{
    
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
     
    public static void main(String[] args)
    {
        //create product
        //addremove product, sAQVING prioce
        //return total at end
        double total = 0;
        Product[] a1 = new Product[100];
        
        BagInterface<Object> bag1 = new Warehouse(a1);
        
        Product p1 = new Product("soap", "Dove", 7.99, 1);
        Product p2 = new Product("soap", "Olay", 8.99, 2);
        Product p3 = new Product("soap", "Nexxus", 12.99, 3);
        Product p4 = new Product("conditioner", "Horse Hair", 10.99, 4);
        Product p5 = new Product("shampoo", "Nexxus", 34.99, 5);
        Product p6 = new Product("shampoo", "Revlon", 6.99, 6);
        
        for(int i = 0; i < 15; i++)
        {
            a1[i] = p1;
        }
        for(int i = 15; i < 30; i++)
        {
            a1[i] = p2;
        }
        for(int i = 30; i < 40; i++)
        {
            a1[i] = p3;
        }
        for(int i = 40; i < 60; i++)
        {
            a1[i] = p4;
        }
        for(int i = 60; i < 65; i++)
        {
            a1[i] = p5;
        }
        for(int i = 65; i < 100; i++)
        {
            a1[i] = p6;
        }
        
        addSeries(bag1, a1);
        
        //
        Object [] b1 = bag1.toArray();
        for(int i = 0; i < b1.length ; i++)
            System.out.println(b1[i]);
        
        System.out.println(bag1.add(p2));
        System.out.println(bag1.remove(p3));
        total = total + p3.getPrice();
        
        System.out.println(bag1.add(p2));
        System.out.println(bag1.getFrequencyOf(p2));
        System.out.println();
            
        Warehouse.mergeSort(a1, 0, 99);
        
        Object [] b3 = bag1.toArray();
        for(int i = 0; i < b3.length ; i++)
            {
                System.out.println(b3[i]);
            }
        
        System.out.println();
        System.out.println(total);
        
        
           
    }

}


package warehouse;

/**
 *
 * @author Owner
 */
public class ProductManagement {
    

	private static void findtotalQuantities(int id,QueueInterface<Product> tempbag)
	{
            int total =0;
            int quantity = 0;
            //user's find the product by id
   	    int index = tempbag.TotalEntry();
   	    String product= null,brand=null;
   	    double price=0.0,size=0.0;
   	    
		
   	 for (int i =0; i < index; i ++ )
       	{
       		Product tempProduct = tempbag.getFront();
       		if(tempProduct.id == id )
       		{
       			brand = tempProduct.brand;
       			product = tempProduct.product;
       			price = tempProduct.price;
       			size = tempProduct.size;
       			//quantity = tempProduct.quantity;
       			//System.out.println(tempProduct);
       			total = total + tempProduct.quantity;
       		}
       		tempbag.dequeue();
       				        		
       	}
   	 
   	  System.out.printf("%d\t%s\t\t %s\t\t\t %.2f\t\t  %.2f \t\t %d\n",id,brand, product, price, size, total);
   
	
	}
	public static void main(String[] args)
	{
		QueueInterface<Product> bag1 = new ArrayQueueBag(100);
    
	
		//Product(String product, String brand, double price, int id, double size, int qty)
		Product p1= new Product("bodysoap", "Dove", 7.99, 1001, 2);
		Product p2 = new Product("bodysoap", "Olay", 8.99, 1002, 3);
		Product p3 = new Product("bodysoap", "Nexxus", 12.99, 1003, 3);
    
		// add products to warehouse
		bag1.enqueue(p1);
		bag1.enqueue(p2);
		bag1.enqueue(p3);
		
		Product p4 = new Product("bodysoap", "Olay", 8.99, 1002, 3);
		bag1.enqueue(p4);
		
		Product p5= new Product("bodysoap", "Dove", 7.99, 1001, 2);
		bag1.enqueue(p5);
		
		Product p6 = new Product("conditioner","Olay", 15.99, 1004, 3);
		bag1.enqueue(p6);
    
		//current number of items in the queue bag
		int index = bag1.TotalEntry();
		System.out.println("Total number of items/index in the queue bag: " + index);
    
		QueueInterface<Product> tempbag = new ArrayQueueBag(50);
		QueueInterface<Product> tempbag1 = new ArrayQueueBag(50);
    
		//copy of bag1 to tempbag
   
    	for (int i=0; i < index; i ++ )
    	{
    		Product tempProduct =bag1.getFront();
    		System.out.println(tempProduct);
    		//System.out.println("Bag1 Queue: ");
    		bag1.dequeue();
    		tempbag.enqueue(tempProduct);
    		tempbag1.enqueue(tempProduct);
    		
    	}
    	
    	QueueInterface<Product> tempbag3 = new ArrayQueueBag(100);
    	//restore tempbag1 to bag1
    	for (int i=0; i < index; i ++ )
    	{
    		Product tempProduct =tempbag1.getFront();
    		//System.out.println(tempProduct);
    		tempbag1.dequeue();
    		bag1.enqueue(tempProduct);
    		tempbag3.enqueue(tempProduct);
    		
    		bag1.getFront();
    	}
    	
    	
    	
    	
    	
    	  //display total number of products according to the ids
    	 //find total quantities in the queue according to Product id 1002 and print out
    	 System.out.printf("\nid\tBrand\t\t Product\t\t\t Price\t\t Size\t\t Total");
    	 					
      	 System.out.println("\n----------------------------------------------------------------------------------------------");	
    	  
      	
    	 findtotalQuantities(1001, tempbag); //find the total quantities according to same id
    	 
      	
    	 
    	 	QueueInterface<Product> tempbag2 = new ArrayQueueBag(100);
    	 	
    	 	for (int i=0; i < index; i ++ )
        	{
        		Product tempProduct =tempbag3.getFront();
        		//System.out.println(tempProduct);
        		tempbag3.dequeue();
        		tempbag2.enqueue(tempProduct);
        		tempbag.enqueue(tempProduct);
        		
        	}
    	 
    	 	//System.out.println(bag1.getFront()+"is on the top.");
    	 	
    	 	findtotalQuantities(1002, tempbag2);
    	 	
    	 	QueueInterface<Product> tempbag4 = new ArrayQueueBag(100);
    	 	QueueInterface<Product> tempbag5 = new ArrayQueueBag(100);
    	 	 
    	 	for (int i=0; i < index; i ++ )
        	{
        		Product tempProduct =tempbag.getFront();
        		//System.out.println(tempProduct);
        		tempbag.dequeue();
        		tempbag4.enqueue(tempProduct);
        		tempbag5.enqueue(tempProduct);
        		//System.out.println(tempbag2.getFront());
        		
        	}
    	 	findtotalQuantities(1003, tempbag4);
    	 	
    	 	QueueInterface<Product> tempbag6 = new ArrayQueueBag(100);
    	 	QueueInterface<Product> tempbag7 = new ArrayQueueBag(100);
    	 	
    	 	for (int i=0; i < index; i ++ )
        	{
        		Product tempProduct =tempbag5.getFront();
        		//System.out.println(tempProduct);
        		tempbag5.dequeue();
        		tempbag6.enqueue(tempProduct);
        		tempbag7.enqueue(tempProduct);
        		//System.out.println(tempb5ag2.getFront());
        		
        	}
    	 	
    	 	findtotalQuantities(1004, tempbag6);
    	 
}


}


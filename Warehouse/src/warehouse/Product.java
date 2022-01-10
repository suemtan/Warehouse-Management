package warehouse;

public class Product implements Comparable<Product>
{
    String product, brand;
    int id, size;
    double price;
    int quantity;
    
    public Product(){
    
    }
    public Product(String product, String brand, double price, int id){
        this.product = product;
        this.brand = brand;
        this.price = price;
        this.id = id;
        
    }


   public Product(String product, String brand, double price, int id, int size){
        this.product = product;
        this.brand = brand;
        this.price = price;
        this.id = id;
        this.size = size;
        
    }


    
    public void setProduct(String product){
        this.product = product;
    }
            
    public void setBrand(String brand){
        this.brand = brand;
    }
    
    public void setPrice(double price){
        this.price = price;
    }
    
    public void setID(int id) {
        this.id = id;
    }
    
    public void setSize(int size){
        this.size = size;
        
    }
    public String getProduct(){
        return product;
    }
            
    public String getBrand(){
        return brand;
    }
    
    public double getPrice(){
        return price;
    }
    
    public int getID() {
        return id;
    }
    
    public int getSize() {
        return size;
    }
    
    
    @Override
    public String toString(){
        return "product: " + product + " brand: " + brand + " price: " + price
                + " ID: " + id;
    }

    @Override
    public int compareTo(Product other) {
        int min = this.id;        
        if (min < other.id)
        {
            return -1;           
        }
        else if (min > other.id)
        {
           return 1; 
        }
        else 
            return 0;
    }

    
}
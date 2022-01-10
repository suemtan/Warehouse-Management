
package warehouse;

/**
 *
 * @author Owner
 */
public class TestClass {
    
    public static void main(String[] args) {
        Product p1 = new Product("soap", "Dove", 7.99, 1);
        
        System.out.println(p1.getBrand());
        System.out.println(p1.getPrice());
        System.out.println(p1.getProduct());
        System.out.println(p1.getID());
        System.out.println(p1.toString());
        
        p1.setBrand("Olay");
        p1.setPrice(12.99);
        p1.setProduct("Food");
        p1.setID(3);
        System.out.println();
        
        System.out.println(p1.getBrand());
        System.out.println(p1.getPrice());
        System.out.println(p1.getProduct());
        System.out.println(p1.getID());
        System.out.println(p1.toString());
        
        
    }

}

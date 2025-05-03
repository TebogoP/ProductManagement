/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package labs.pm.app;

import java.math.BigDecimal;
import labs.pm.data.Product;

/**
 *
 * @author User
 */
public class Shop {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Product p1 = new Product();
        
        p1.setId(101);
        p1.setName("Tea");
        p1.setPrice(BigDecimal.valueOf(1.99));
        
        System.out.println(p1.getId()+" "+ p1.getName()+" "+p1.getPrice());
        
    }
    
}

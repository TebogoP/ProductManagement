/*
 * Copyright (C) 2025 User
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package labs.pm.app;

import java.math.BigDecimal;
import java.time.LocalDate;
import labs.pm.data.Drink;
import labs.pm.data.Food;
import labs.pm.data.Product;
import labs.pm.data.Rating;

/**
 * {@code Shop} class represents an application that manages Products
 *
 * @version 4
 * @author User
 */
public class Shop {

    /**
     * Main method that serves as the entry point for the application.
     * Initializes the product management system and performs operations.
     *
     * @param args the command line arguments provided to the application
     */
    public static void main(String[] args) {
        // TODO code application logic here
//        Product p1 = new Product();
//        p1.setId(101);
//        p1.setName("Tea");
//        p1.setPrice(BigDecimal.valueOf(1.99));
        Product p1 = new Drink(101, "Tea", BigDecimal.valueOf(1.99), Rating.THREE_STAR); //Changed due to abstract class. Can't have an instance of an abstract class
        Product p2 = new Drink(102, "Coffee", BigDecimal.valueOf(1.99), Rating.FOUR_STAR);
        Product p3 = new Food(103, "Cake", BigDecimal.valueOf(3.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        Product p4 = new Food(105, "Cookie", BigDecimal.valueOf(3.99), Rating.TWO_STAR, LocalDate.now());//Changed due to abstract class. Can't have an instance of an abstract class
        Product p5 = p3.applyRating(Rating.NOT_RATED);
        Product p6 = new Drink(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FOUR_STAR);
        Product p7 = new Food(104, "Chocolate", BigDecimal.valueOf(2.99), Rating.FIVE_STAR, LocalDate.now().plusDays(2));
        System.out.println(p6.equals(p7)); // Will return True if check instance of Product but return False if comparing classes
        Product p8 = p4.applyRating(Rating.FIVE_STAR);
        Product p9 = p1.applyRating(Rating.TWO_STAR);
        
        if (p3 instanceof Food){ //getBestBefore exists only in Food and not in Product
            ((Food)p3).getBestBefore(); // This can only be used because getBestBefore is only in Food
        }
//        System.out.println("====================================================");
//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount());
//        System.out.println(p1); // Uses the toString method in Product

        System.out.println("====================================================");
//        System.out.println(p1.getId() + " " + p1.getName() + " " + p1.getPrice() + " " + p1.getDiscount() + " " + p1.getRating().getStars());
//        System.out.println(p2.getId() + " " + p2.getName() + " " + p2.getPrice() + " " + p2.getDiscount() + " " + p2.getRating().getStars());
//        System.out.println(p3.getId() + " " + p3.getName() + " " + p3.getPrice() + " " + p3.getDiscount() + " " + p3.getRating().getStars());
//        System.out.println(p4.getId() + " " + p4.getName() + " " + p4.getPrice() + " " + p4.getDiscount() + " " + p4.getRating().getStars());
//        System.out.println(p5.getId() + " " + p5.getName() + " " + p5.getPrice() + " " + p5.getDiscount() + " " + p5.getRating().getStars());

        System.out.println(p1); // Uses the toString method in Drink
        System.out.println(p2); // Uses the toString method in Drink
        System.out.println(p3); // Uses the toString method in Food
        System.out.println(p4); // Uses the toString method in Food
        System.out.println(p5); // Uses the toString method in Food
        System.out.println(p6); // Uses the toString method in Drink
        System.out.println(p7); // Uses the toString method in Food
        System.out.println(p8); // Uses the toString method in Food
        System.out.println(p9); // Uses the toString method in Drink
    }

}

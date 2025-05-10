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
package labs.pm.data;

import java.math.BigDecimal;
import java.time.LocalDate;

/**
 * A class that manages the creation of various product types through factory
 * methods. This implementation demonstrates method overloading to create
 * different product subtypes.
 *
 * @author User
 */
public class ProductManager {

    /**
     * The current product being managed
     */
    private Product product;

    /**
     * The current review
     */
    private Review review;

    /**
     * Creates a Food product with an expiration date.
     *
     * @param id The unique identifier for the product
     * @param name The name of the product
     * @param price The price of the product
     * @param rating The product rating
     * @param bestBefore The expiration date of the food product
     * @return A new Food product instance
     */
    public Product createProduct(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        product = new Food(id, name, price, rating, bestBefore);
        return product;
    }

    /**
     * Creates a Drink product without an expiration date.
     *
     * @param id The unique identifier for the product
     * @param name The name of the product
     * @param price The price of the product
     * @param rating The product rating
     * @return A new Drink product instance
     */
    public Product createProduct(int id, String name, BigDecimal price, Rating rating) {
        product = new Drink(id, name, price, rating);
        return product;
    }

    /**
     * Creates a review for a product and applies the rating to the product.
     * This method creates a new Review instance and updates the product's
     * rating.
     *
     * @param product The product to be reviewed
     * @param rating The rating to assign to the product
     * @param comments The review comments
     * @return The updated product with the new rating applied
     */
    public Product reviewProduct(Product product, Rating rating, String comments) {
        review = new Review(rating, comments);
        this.product = product.applyRating(rating);
        return this.product;
    }
}

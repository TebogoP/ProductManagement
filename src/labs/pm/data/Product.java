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
import static java.math.RoundingMode.HALF_UP;

/**
 * {@code Product} class represents properties of product objects in a Product
 * Management system
 * <br>
 * Each product has an id, name, and price
 * <br>
 * Each product can have a discount, calculated based on a
 * {@link DISCOUNT_RATE discount rate }
 *
 * @version 4
 * @author User
 */
public class Product {

    private int id; //Default value 0
    private String name; //Default value null
    private BigDecimal price = BigDecimal.ZERO; //Default value null. Intialized so that getDiscount doesn't present NullPointerException at runtime
    private Rating rating;

    /**
     * A constant that defines a {@link java.math.BigDecimal BigDecimal} value
     * of the discount rate.
     * <br>
     * Discount rate is 10%
     */
    public static final BigDecimal DISCOUNT_RATE = BigDecimal.valueOf(0.1);

    /**
     * Calculates discount based on a product price and
     * {@link DISCOUNT_RATE discount rate}.
     *
     * @return a {@link java.math.BigDecimal BigDecimal} value of the discount
     */
    public BigDecimal getDiscount() {
        return price.multiply(DISCOUNT_RATE).setScale(2, HALF_UP);
    }

    /**
     * Default constructor for creating a Product instance.
     * Initializes a product with default values.
     */
    public Product() {
        this.rating = Rating.NOT_RATED;
    }
    
    /**
     * Gets the rating of this product.
     * 
     * @return the product rating
     */
    public Rating getRating() {
        return rating;
    }
    
    /**
     * Sets the rating for this product.
     * 
     * @param rating the product rating to set
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }

    /**
     * Gets the unique identifier of this product.
     * 
     * @return the product id
     */
    public int getId() {
        return id;
    }

    /**
     * Sets the unique identifier for this product.
     * 
     * @param id the product id to set
     */
    public void setId(final int id) {
        this.id = id;
    }

    /**
     * Gets the name of this product.
     * 
     * @return the product name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the name for this product.
     * 
     * @param name the product name to set
     */
    public void setName(final String name) {
        this.name = name;
    }

    /**
     * Gets the price of this product.
     *
     * @return the product price
     */
    public BigDecimal getPrice() {
        return price;
    }

    /**
     * Sets the price for this product.
     *
     * @param price the product price to set
     */
    public void setPrice(final BigDecimal price) {
//        price = BigDecimal.ONE; This overrides whatever value is set to 1. Making it a constant price of 1
        this.price = price;
    }

}

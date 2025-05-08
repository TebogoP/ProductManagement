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
import java.util.Objects;

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
    private BigDecimal price; //Default value null. 
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
     * Default constructor for creating a Product instance. Initializes a
     * product with default values (id=0, name="no name", price=0). Initializes
     * price so that getDiscount doesn't present NullPointerException at
     * runtime.
     */
    public Product() {
        this(0, "no name", BigDecimal.ZERO);
    }

    /**
     * Constructor for creating a Product with specified id, name, and price.
     * The rating is set to NOT_RATED by default.
     *
     * @param id The unique identifier for the product
     * @param name The name of the product
     * @param price The price of the product
     */
    public Product(int id, String name, BigDecimal price) {
        this(id, name, price, Rating.NOT_RATED);
    }

    /**
     * Constructor for creating a Product with all attributes specified.
     *
     * @param id The unique identifier for the product
     * @param name The name of the product
     * @param price The price of the product
     * @param rating The rating of the product
     */
    public Product(int id, String name, BigDecimal price, Rating rating) {
        this.id = id;
        this.name = name;
        this.price = price;
        this.rating = rating;
    }

    /**
     * Updates the rating of this product.
     *
     * @param rating The new rating to apply to the product
     * @return a new Product
     */
    public Product applyRating(Rating rating) {
        return new Product(getId(), getName(), getPrice(), rating);
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

    /**
     * Returns a string representation of this product.
     *
     * @return a string with product details
     */
    @Override
    public String toString() {
        return id + ", " + name + ", " + price + ", " + getDiscount() + ", " + rating;
    }

    /**
     * Generates a hash code for this product. The hash code is based on the
     * product's ID. This implementation is consistent with the equals method,
     * ensuring that equal objects produce the same hash code.
     *
     * @return The hash code value for this product
     */
    @Override
    public int hashCode() {
        int hash = 7;
        hash = 41 * hash + this.id;
        return hash;
    }

    /**
     * Compares this product with another object for equality. Products are
     * considered equal if they have the same ID and the same name. This method
     * follows the general contract for Object.equals: - It is reflexive: an
     * object is equal to itself - It is symmetric: if a.equals(b) then
     * b.equals(a) - It is transitive: if a.equals(b) and b.equals(c) then
     * a.equals(c) - It is consistent: repeated calls with unchanged objects
     * return the same result - It returns false when comparing with null
     *
     * @param obj The object to compare with this product
     * @return true if the objects are equal, false otherwise
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj != null && getClass() == obj.getClass()) {
            final Product other = (Product) obj;
            return this.id == other.id && Objects.equals(this.name, other.name);
        }
        return false;
        
    }
//    public boolean equals(Object obj) {
//        if (this == obj) {
//            return true;
//        }
//        if (obj == null) {
//            return false;
//        }
//        if (getClass() != obj.getClass()) {
//            return false;
//        }
//        final Product other = (Product) obj;
//        if (this.id != other.id) {
//            return false;
//        }
//        return Objects.equals(this.name, other.name);
//    }

}

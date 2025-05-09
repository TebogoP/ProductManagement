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
 * Represents a food product in the inventory system. Extends the base Product
 * class with additional attributes specific to food items.
 *
 * @author User
 */
public class Food extends Product {

    private LocalDate bestBefore;

    /**
     * Get the value of bestBefore date of the product
     *
     * @return the value of bestBefore
     */
    public LocalDate getBestBefore() {
        return bestBefore;
    }

    /**
     * Constructor for creating a Food product with specified attributes. The
     * rating is set to NOT_RATED by default.
     *
     * @param id The unique identifier for the food product
     * @param name The name of the food product
     * @param price The price of the food product
     * @param rating The rating of the food product
     * @param bestBefore The expiration date of the food product
     */
    public Food(int id, String name, BigDecimal price, Rating rating, LocalDate bestBefore) {
        super(id, name, price, rating);
        this.bestBefore = bestBefore;
    }

    /**
     * Calculates the discount for this food product based on its best-before
     * date. A discount is offered only on the day the product reaches its
     * best-before date. On this day, the discount from the parent class is
     * applied. On all other days, no discount (zero) is applied.
     *
     * @return The discount amount as a BigDecimal, or BigDecimal.ZERO if not on
     * best-before date
     */
    @Override
    public BigDecimal getDiscount() {
        return (bestBefore.isEqual(LocalDate.now())) ? super.getDiscount() : BigDecimal.ZERO;
    }

    /**
     * Returns a string representation of food product.
     *
     * @return a string with food details
     */
    @Override
    public String toString() {
        return super.toString() + ", " + bestBefore;
    }

    /**
     * Applies the specified rating to this Food product. Instead of modifying
     * the current instance, this implementation follows the immutable object
     * pattern by creating and returning a new Food object with the updated
     * rating.
     *
     * @param newRating The rating to apply to this food product
     * @return A new Food instance with all the same properties but the updated
     * rating
     */
    @Override
    public Product applyRating(Rating newRating) {
        return new Food(getId(), getName(), getPrice(), newRating, bestBefore);
    }

}

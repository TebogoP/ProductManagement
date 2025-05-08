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
 * Represents a food product in the inventory system.
 * Extends the base Product class with additional attributes specific to food items.
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
     * Constructor for creating a Food product with specified attributes.
     * The rating is set to NOT_RATED by default.
     *
     * @param id         The unique identifier for the food product
     * @param name       The name of the food product
     * @param price      The price of the food product
     * @param bestBefore The expiration date of the food product
     */
    public Food(int id, String name, BigDecimal price, LocalDate bestBefore) {
        super(id, name, price);
        this.bestBefore = bestBefore;
    }

}

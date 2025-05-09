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
import java.time.LocalTime;

/**
 * Represents a drink product in the inventory system. Extends the base Product
 * class.
 *
 * @author User
 */
public class Drink extends Product {

    /**
     * Constructor for creating a Drink with specified attributes.
     *
     * @param id The unique identifier for the drink
     * @param name The name of the drink
     * @param price The price of the drink
     * @param rating The rating of the drink
     */
    public Drink(int id, String name, BigDecimal price, Rating rating) {
        super(id, name, price, rating);
    }

    /**
     * Calculates the discount for this product based on the current time. A
     * discount is offered only during the "happy hour" between 17:30 and 18:30.
     * During this time, the discount from the parent class is applied. At all
     * other times, no discount (zero) is applied.
     *
     * @return The discount amount as a BigDecimal, or BigDecimal.ZERO if
     * outside happy hour
     */
    @Override
    public BigDecimal getDiscount() {
        LocalTime now = LocalTime.now();
        return (now.isAfter(LocalTime.of(17, 30))
                && now.isBefore(LocalTime.of(18, 30)))
                ? super.getDiscount() : BigDecimal.ZERO;
    }

}

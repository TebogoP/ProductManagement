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

/**
 * Represents product rating as a system of stars with values from 0 to 5 stars.
 * Each {@code Rating} value has an associated Unicode star representation.
 * <br>
 * This enumeration provides constants for product ratings:
 * {@code NOT_RATED} (0 stars) for products without reviews,
 * {@code ONE_STAR} through {@code FIVE_STAR} for rated products.
 * 
 * @author User
 * @version 1.0
 */
 
public enum Rating {
    
    
     private String stars;
     /**
     * Constructs a {@code Rating} with the specified Unicode star representation.
     * 
     * @param stars Unicode characters representing the rating stars
     */
    private Rating(String stars) {
        this.stars = stars;
    }
    
    /**
     * Gets the Unicode star representation of this rating.
     * 
     * @return the Unicode stars as a string
     */
    public String getStars() {
        return stars;
    }
    
}

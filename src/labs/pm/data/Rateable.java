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
 * A generic interface that defines the contract for objects that can be rated.
 * Classes implementing this interface can be evaluated or scored according to
 * defined criteria. The generic type parameter <T> typically represents the
 * type of the implementing class itself to enable method chaining and fluent
 * interfaces.
 *
 * @param <T> The type of object that implements this interface, typically used
 * for method chaining
 * @author User
 */
public interface Rateable<T> {
    
    /**
     * The default rating to be used when no rating is specified.
     */
    public static final Rating DEFAULT_RATING = Rating.NOT_RATED;
    
    /**
     * Applies a rating to this object.
     * This is the core abstract method that implementing classes must provide.
     *
     * @param rating The rating to apply
     * @return The object instance for method chaining
     */
    T applyRating(Rating rating);// By default methods are public abstract
    
    /**
     * Gets the current rating of this object.
     * By default, returns the DEFAULT_RATING.
     * Implementing classes should override this method to return their actual rating.
     *
     * @return The current rating value
     */
    public default Rating getRating() {
        return DEFAULT_RATING;
    }
    
    
}

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
 * Represents a user review consisting of a rating and optional comments.
 * This class stores evaluation information about a product or service.
 *
 * @author User
 */
public class Review {

        
    /**
     * The rating assigned in this review
     */
    private Rating rating;
    
    /**
     * The textual comments associated with this review
     */
    private String comments;

    /**
     * Gets the rating assigned in this review.
     *
     * @return The rating
     */
    public Rating getRating() {
        return rating;
    }
    
     /**
     * Constructs a new Review with the specified rating and comments.
     *
     * @param rating The rating for this review
     * @param comments The comments for this review
     */
    public Review(Rating rating, String comments) {
        this.rating = rating;
        this.comments = comments;
    }
    
    /**
     * Sets the rating for this review.
     *
     * @param rating The new rating to assign
     */
    public void setRating(Rating rating) {
        this.rating = rating;
    }
    
     /**
     * Gets the comments associated with this review.
     *
     * @return The comments
     */
    public String getComments() {
        return comments;
    }
    
    /**
     * Sets the comments for this review.
     *
     * @param comments The new comments to assign
     */
    public void setComments(String comments) {
        this.comments = comments;
    }
    
    /**
     * Returns a string representation of this review.
     *
     * @return A string containing the rating and comments
     */
    @Override
    public String toString() {
        return "Review{" + "rating=" + rating + ", comments='" + comments + "'}";
    }
    
}

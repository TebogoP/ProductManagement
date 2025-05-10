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
import java.text.MessageFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.util.Locale;
import java.util.ResourceBundle;

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
     * The locale used for internationalization and formatting. Determines the
     * language, country, and formatting conventions.
     */
    private Locale locale;

    /**
     * Resource bundle containing localized text messages. Provides access to
     * externalized strings based on the current locale.
     */
    private ResourceBundle resourceBundle;

    /**
     * Formatter for dates and times according to the current locale. Used to
     * format dates in a locale-specific manner.
     */
    private DateTimeFormatter dateFormat;

    /**
     * Formatter for monetary values according to the current locale. Used to
     * format prices with appropriate currency symbols and decimal separators.
     */
    private NumberFormat moneyFormat;

    /**
     * Constructs a ProductManager with the specified locale. Initializes all
     * formatters and resource bundles for the given locale.
     *
     * @param locale The locale to use for internationalization
     */
    public ProductManager(Locale locale) {
        this.locale = locale;
        resourceBundle = ResourceBundle.getBundle("labs.pm.data.resources", locale);
        dateFormat = DateTimeFormatter.ofLocalizedDate(FormatStyle.SHORT).localizedBy(locale);
        moneyFormat = NumberFormat.getCurrencyInstance(locale);
    }

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
        this.review = new Review(rating, comments);
        this.product = product.applyRating(rating);
        return this.product;
    }

    /**
     * Generates and prints a formatted report for the current product. The
     * report includes: - Product details: name, price (formatted as currency),
     * rating, and best-before date - Review information: If a review exists,
     * includes rating stars and comments; otherwise, displays a message
     * indicating no reviews are available
     *
     * All text is localized using the resource bundle configured for this
     * ProductManager, and formatting follows the locale-specific conventions.
     */
    public void printProductReport() {
        StringBuilder txt = new StringBuilder();
        txt.append(
                MessageFormat.format(
                        resourceBundle.getString("product"),
                        product.getName(),
                        moneyFormat.format(product.getPrice()),
                        product.getRating(),
                        dateFormat.format(product.getBestBefore())
                )
        ).append("\n");
        if (review != null) {
            txt.append(
                    MessageFormat.format(
                            resourceBundle.getString("review"),
                            review.getRating().getStars(),
                            review.getComments()
                    )
            );
        } else {
            txt.append(resourceBundle.getString("no.review"));
        }
        txt.append("\n");
        System.out.println(txt);
    }
}

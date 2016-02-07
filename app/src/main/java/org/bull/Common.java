package org.bull;

import org.jetbrains.annotations.Contract;

/**
 * Class that contains common functions used all around the code
 *
 * Created by amit on 08/02/16.
 */
public class Common {

    /**
     * Function to test if an object is not null
     * @param object - The object to test
     * @return true if not null, false otherwise
     */
    @Contract(value = "null -> false; !null -> true", pure = true)
    public static boolean notNull(Object object) {
        return object != null;
    }

    /**
     * Function to test if an object is null
     * @param object - The object to test
     * @return true if null, false otherwise
     */
    @Contract(value = "null -> true; !null -> false", pure = true)
    public static boolean isNull(Object object) {
        return object == null;
    }

}

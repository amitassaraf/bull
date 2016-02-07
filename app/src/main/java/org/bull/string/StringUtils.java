package org.bull.string;

import com.annimon.stream.Stream;

/**
 * Utils for working with Strings in Java and Android.
 *
 * Created by amit on 08/02/16.
 */
public class StringUtils {

    /**
     * Method to format a lot of string together instead of using "+"
     * @param data - The strings to concat
     * @return A concatenated string
     */
    public static String format(Object... data) {
        StringBuilder builder = new StringBuilder();
        Stream.of(data).forEach(builder::append);
        return builder.toString();
    }
}

package org.bull;

import com.annimon.stream.Stream;

import org.jetbrains.annotations.Contract;

import java.util.Collection;
import java.util.Map;

/**
 * Class that contains common functions used all around the code
 * <p>
 * Created by amit on 08/02/16.
 */
public class CommonUtils {

    /**
     * Function to test if an object is not null
     *
     * @param object - The object to test
     * @return true if not null, false otherwise
     */
    @Contract(value = "null -> false; !null -> true", pure = true)
    public static boolean notNull(Object object) {
        return object != null;
    }

    /**
     * Function to test if an object is null
     *
     * @param object - The object to test
     * @return true if null, false otherwise
     */
    @Contract(value = "null -> true; !null -> false", pure = true)
    public static boolean isNull(Object object) {
        return object == null;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    public static boolean is(String obj) {
        return notNull(obj) && obj.length() != 0;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(value = "null -> false; !null -> true", pure = true)
    public static <T> boolean is(T obj) {
        return notNull(obj);
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(value = "true -> true; false -> false", pure = true)
    public static boolean is(boolean obj) {
        return obj;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(pure = true)
    public static boolean is(int obj) {
        return obj != 0;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(pure = true)
    public static boolean is(float obj) {
        return obj != 0.0f;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(pure = true)
    public static boolean is(double obj) {
        return obj != 0.0;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    @Contract(pure = true)
    public static boolean is(long obj) {
        return obj != 0;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    public static <K, V> boolean is(Map<K, V> obj) {
        return notNull(obj) && obj.size() != 0;
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    public static <T> boolean is(Collection<T> obj) {
        if (isNull(obj) || obj.size() == 0)
            return false;

        return Stream.of(obj).filter(CommonUtils::is).count() != obj.size();
    }

    /**
     * Function to test an object logically if has data, for example a null object would return
     * false, and also an empty string would return false.
     *
     * @param obj - The object to test
     * @return - True if it has data, False otherwise
     */
    public static <T> boolean is(T[] obj) {
        if (isNull(obj) || obj.length == 0)
            return false;

        return Stream.of(obj).filter(CommonUtils::is).count() != obj.length;
    }

}

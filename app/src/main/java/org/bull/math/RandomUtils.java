package org.bull.math;

/**
 * RandomUtils utils
 * <p>
 * Created by amit on 14/01/16.
 */
public class RandomUtils {

    /* --- Static members --- */

    private static java.util.Random random;

    /* --- Static methods --- */

    /**
     * Returns a pseudo-random number between min and max, inclusive.
     * The difference between min and max can be at most
     * <code>Integer.MAX_VALUE - 1</code>.
     *
     * @param min Minimum value
     * @param max Maximum value.  Must be greater than min.
     * @return Integer between min and max, inclusive.
     * @see java.util.Random#nextInt(int)
     */
    public static int randInt(int min, int max) {
        if (random == null)
            random = new java.util.Random();


        // nextInt is normally exclusive of the top value,
        // so add 1 to make it inclusive
        int randomNum = random.nextInt((max - min) + 1) + min;

        return randomNum;
    }

}

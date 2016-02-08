package org.bull.generic;

import com.google.common.collect.Maps;

import org.bull.math.RandomUtils;

import java.util.HashMap;

/**
 * Class for temporary consts
 * <p>
 * Created by amit on 08/02/16.
 */
public class TempConst {

    /* --- Members --- */

    private static final HashMap<Integer, String> mConsts = Maps.newHashMap();

    /* --- General Methods --- */

    /**
     * Function to define a new temporary constant
     * @param value - The value of the constant
     * @return int - The ID of the new constant
     */
    public static int $new(String value) {
        int index = RandomUtils.randInt(0, Integer.MAX_VALUE);
        mConsts.put(index, value);
        return index;
    }

    /**
     * Function to access the temporary constant
     * @param id - The ID of the constant.
     * @return String - the constant value
     */
    public static String $(int id) {
        return mConsts.get(id);
    }

}

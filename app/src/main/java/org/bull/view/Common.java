package org.bull.view;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.Nullable;
import android.view.View;

import com.annimon.stream.function.Consumer;
import com.annimon.stream.function.Function;
import com.annimon.stream.function.Predicate;
import com.annimon.stream.function.Supplier;
import com.google.common.hash.Funnel;

/**
 * Common view functions and utils
 * <p>
 * Created by amit on 08/02/16.
 */
public class Common {

    /**
     * Function to find a view and act on it
     *
     * @param view      - The root view
     * @param resId     - The view resource ID to find
     * @param consumer - The method to act with
     */
    public static <T> T findView(View view, int resId, Function<View, T> caster, Consumer<T> consumer) {
        View child = view.findViewById(resId);
        T casted = caster.apply(child);
        consumer.accept(casted);
        return casted;
    }

    /**
     * Function to find a view and act on it
     *
     * @param activity  - The current activity
     * @param resId     - The view resource ID to find
     * @param consumer - The method to act with
     */
    public static <T> T findView(Activity activity, int resId, Function<View, T> caster, Consumer<T> consumer) {
        return findView(activity.getWindow().getDecorView(), resId, caster, consumer);
    }

}

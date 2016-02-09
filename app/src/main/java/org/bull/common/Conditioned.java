package org.bull.common;

import com.annimon.stream.function.Supplier;

import lombok.AllArgsConstructor;

/**
 * A class that is used to have one object that returns two different values according to a
 * condition.
 * Created by amit on 10/02/16.
 */
@AllArgsConstructor
public class Conditioned<T> {

    private T onTrue;
    private T onFalse;
    private Supplier<Boolean> condition;

    /**
     * Method to get the value according to the condition
     *
     * @return T - value
     */
    public T get() {
        if (CommonUtils.notNull(condition) && condition.get())
            return onTrue;
        return onFalse;
    }
}

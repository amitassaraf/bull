package org.bull.tasks;

import android.os.Bundle;

/**
 * A runnable interface that gets metadata in it's run function
 * <p>
 * Created by amit on 14/01/16.
 */
public interface TypedMetadataRunnable<T> {

    /* --- Interface methods ---- */

    /**
     * The function to run
     *
     * @param metadata - The metadata
     * @return A value of generic type T
     */
    T run(Metadata metadata);
}

package org.bull.tasks;

import android.content.Context;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A task that runs code in a seperate thread and can repeat itself a number of times or until a
 * condition.
 * <p>
 * Created by amit on 14/01/16.
 */
@Accessors(prefix = "m")
@AllArgsConstructor
public class RepeatingTask extends MetadataTask {

    /* --- Protected members --- */

    protected Context mContext;
    protected MetadataRunnable mLogicRunnable;
    protected TypedMetadataRunnable<Boolean> mCondition;

    /* --- Overridden methods --- */

    public void run() {
        while (mCondition.run(mMetadata)) {
            mLogicRunnable.run(mMetadata);
        }
    }
}

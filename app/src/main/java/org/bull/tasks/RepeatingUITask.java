package org.bull.tasks;

import android.app.Activity;
import android.content.Context;

import java.lang.annotation.Inherited;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A task that runs code in a seperate thread and can repeat itself a number of times or until a
 * condition.
 * <p>
 * Created by amit on 14/01/16.
 */
@Accessors(prefix = "m")
public class RepeatingUITask extends RepeatingTask {

    /**
     * Default repeating UI task constructor
     * @param context - The context
     * @param logicRunnable - The logic to run on the UI
     * @param condition - The condition which to continue at
     */
    public RepeatingUITask(Context context, MetadataRunnable logicRunnable, TypedMetadataRunnable<Boolean> condition) {
        super(context, logicRunnable, condition);
    }

    /* --- Overridden methods --- */

    public void run() {
        while (mCondition.run(mMetadata)) {
            ((Activity) mContext).runOnUiThread(() -> mLogicRunnable.run(mMetadata));
        }
    }
}

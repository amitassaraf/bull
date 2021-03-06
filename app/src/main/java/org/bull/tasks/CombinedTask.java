package org.bull.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A task that runs a runnable on a seperate thread, then executes a runnable on the UI thread.
 * <p>
 * Created by amit on 14/01/16.
 */
@Accessors(prefix = "m")
@AllArgsConstructor
public class CombinedTask extends MetadataTask {

    /* --- Protected members --- */

    protected Context mContext;
    protected MetadataRunnable mLogicRunnable;
    protected MetadataRunnable mUIRunnable;

    /* --- Overridden methods --- */

    public void run() {
        mLogicRunnable.run(mMetadata);
        ((Activity) mContext).runOnUiThread(() -> mUIRunnable.run(mMetadata));
    }
}

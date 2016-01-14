package org.bull.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import lombok.AllArgsConstructor;
import lombok.experimental.Accessors;

/**
 * A network task
 * <p>
 * Created by amit on 14/01/16.
 */
@Accessors(prefix = "m")
@AllArgsConstructor
public class NetworkTask extends CombinedTask {

    /* --- Overridden methods ---*/

    @Override
    public void run() {
        Bundle metadata = new Bundle();
        mLogicRunnable.run(metadata);
        mUIRunnable.run(metadata);
    }
}

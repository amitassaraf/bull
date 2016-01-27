package org.bull.tasks;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.CallSuper;

import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
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
        mLogicRunnable.run(mMetadata);
        mUIRunnable.run(mMetadata);
    }
}

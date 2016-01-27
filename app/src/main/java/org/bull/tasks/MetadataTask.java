package org.bull.tasks;

import android.os.Bundle;

import lombok.AllArgsConstructor;
import lombok.NonNull;
import lombok.experimental.Accessors;

/**
 * A Task that has metadata.
 *
 * Created by amit on 27/01/16.
 */
@Accessors(prefix = "m")
public class MetadataTask extends Task {

    protected Bundle mMetadata;

    /**
     * Start the task with metadata
     * @param initialMetadata - Initialize the task with metadata
     */
    public void start(@NonNull Bundle initialMetadata) {
        mMetadata = initialMetadata;
        super.start();
    }

    /**
     * Start the task
     */
    public void start() {
        mMetadata = new Bundle();
        super.start();
    }

}

package org.bull.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v4.util.Pair;

import org.bull.tasks.Task;

import lombok.AccessLevel;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.experimental.Accessors;

/**
 * Builder used for navigating between activities.
 * Created by amit on 13/01/16.
 */
@Accessors(prefix = "m")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public final class ActivitySwitcher extends Task {

    /* --- Members --- */

    @NonNull
    private Context mContext;
    @NonNull
    private Class<? extends Activity> mTarget;
    protected SwitcherMetadata mMetadata;

    /* --- Overridden methods --- */

    public void run() {
        if (mMetadata.requiresAction)
            return;

        Task.sleep(mMetadata.delay);

        Activity currentActivity = (Activity) mContext;
        Intent switchIntent = new Intent(mContext, mTarget);
        switchIntent.setFlags(mMetadata.flags);
        currentActivity.overridePendingTransition(mMetadata.transition.first, mMetadata.transition.second);

        currentActivity.startActivity(switchIntent);

        if (mMetadata.finish)
            currentActivity.finish();
    }

    /* --- General methods --- */

    /**
     * Method to trigger the switcher if requiresAction was called when building.
     */
    public void trigger() {
        mMetadata.requiresAction = false;
        this.start();
    }

    /* --- Static methods --- */

    /**
     * Method to begin building an activity switcher
     *
     * @param currentActivity - The current activity (the activity to switch from)
     * @return Builder - an activity switcher builder
     */
    public static Builder $chain(Activity currentActivity) {
        return new Builder(currentActivity);
    }

    /* --- Inner classes --- */

    /**
     * Switcher metadata class
     */
    static class SwitcherMetadata {
        long delay; // Delay
        boolean finish; // Whether to finish the activity when switching
        boolean requiresAction; // Whether starting switching process requires action
        int flags; // The intent flags
        Pair<Integer, Integer> transition; // The transition animation
    }

    /**
     * The builder used to build the ActivitySwitcher
     */
    @Accessors(prefix = "m")
    @RequiredArgsConstructor
    public static class Builder {

        /* --- Members --- */

        @NonNull
        private Context mContext;
        // The switching metadata
        private SwitcherMetadata mMetadata = new SwitcherMetadata();

        /* --- Constructors --- */

        /**
         * Method used to add delay to the activity switch
         *
         * @param delay - The delay to add
         * @return Builder
         */
        public Builder delay(long delay) {
            mMetadata.delay = delay;
            return this;
        }

        /* --- General methods --- */

        /**
         * Method to add a transition to the activity switch
         *
         * @param in_transition  - The in transition resource
         * @param out_transition - The out transition resource
         * @return Builder
         */
        public Builder transition(int in_transition, int out_transition) {
            mMetadata.transition = new Pair<>(in_transition, out_transition);
            return this;
        }

        /**
         * Method to make the previous activity close when switching
         *
         * @return Builder
         */
        public Builder exitOnSwitch() {
            mMetadata.finish = true;
            return this;
        }

        /**
         * Method to set the intent flags for the new activity
         *
         * @param flags - The new flags
         * @return Builder
         */
        public Builder intentFlags(int flags) {
            mMetadata.flags = flags;
            return this;
        }

        /**
         * Method to make the switcher only start the switching process when 'trigger' is called
         * on it.
         *
         * @return Builder
         */
        public Builder requireTrigger() {
            mMetadata.requiresAction = true;
            return this;
        }

        /**
         * Method to begin the switching process (unless requiresAction was called)
         *
         * @param target - The activity to switch to
         * @return ActivitySwitcher instance
         */
        public ActivitySwitcher $switch(Class<? extends Activity> target) {
            ActivitySwitcher activitySwitcher = new ActivitySwitcher(mContext, target);
            activitySwitcher.mMetadata = mMetadata;
            activitySwitcher.start();
            return activitySwitcher;
        }

    }

}

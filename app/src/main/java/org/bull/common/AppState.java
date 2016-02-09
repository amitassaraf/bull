package org.bull.common;

import org.jetbrains.annotations.Contract;

/**
 * Class used to switch between release mode and debug mode easily across the entire app
 * Created by amit on 10/02/16.
 */
public enum AppState {

    RELEASE, DEBUG;

    // Public and static so it can be changed from the app :D
    public static AppState currentState = AppState.RELEASE;

    /**
     * Method to check if the app is in debug mode
     * @return True if the app is in debug mode
     */
    @Contract(pure = true)
    public static boolean isDebug() {
        return currentState == AppState.DEBUG;
    }

}

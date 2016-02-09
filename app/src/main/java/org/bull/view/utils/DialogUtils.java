package org.bull.view.utils;

import android.content.Context;
import android.support.v7.app.AlertDialog;

import org.bull.R;

/**
 * Class that includes a lot of useful dialog utils
 * Created by amit on 10/02/16.
 */
public class DialogUtils {

    /**
     * Method to show a message popup
     *
     * @param context - The application context
     * @param title   - The title of the popup
     * @param message - The message of the popup
     * @return AlertDialog - The alert dialog instance created
     */
    public static AlertDialog showMessagePopup(Context context, String title, String message,
                                               int icon_resource) {
        return new AlertDialog.Builder(context)
                .setTitle(title)
                .setMessage(message)
                .setIcon(icon_resource)
                .show();
    }

    /**
     * Method to show a message popup
     *
     * @param context       - The resource id application context
     * @param title         - The resource id title of the popup
     * @param message       - The message of the popup
     * @param icon_resource - The resource id of the icon
     * @return AlertDialog - The alert dialog instance created
     */
    public static AlertDialog showMessagePopup(Context context, int title, int message,
                                               int icon_resource) {
        return showMessagePopup(context, context.getString(title), context.getString(message),
                icon_resource);
    }

    /**
     * Method to show a message popup
     *
     * @param context - The resource id application context
     * @param title   - The resource id title of the popup
     * @param message - The message of the popup
     * @return AlertDialog - The alert dialog instance created
     */
    public static AlertDialog showMessagePopup(Context context, int title, int message) {
        return showMessagePopup(context, context.getString(title), context.getString(message),
                R.drawable.ic_announecment_black_48dp);
    }

    /**
     * Method to show a message popup
     *
     * @param context - The resource id application context
     * @param title   - The resource id title of the popup
     * @param message - The message of the popup
     * @return AlertDialog - The alert dialog instance created
     */
    public static AlertDialog showMessagePopup(Context context, String title, String message) {
        return showMessagePopup(context, title, message, R.drawable.ic_announecment_black_48dp);
    }

}

package org.bull.view;

import android.view.View;

/**
 * A listener for view draws & renders.
 * Created by amit on 10/02/16.
 */
public interface ViewDrawListener {

    /**
     * Method called when a view this listener was assigned to is drawn
     * @param view - The view that was drawn
     */
    void onViewDrawn(View view);
}

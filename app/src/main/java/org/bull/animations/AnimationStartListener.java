package org.bull.animations;

import android.view.animation.Animation;

/**
 * Animation listener that only listens to the animation start.
 * <p>
 * Created by amit on 10/01/16.
 */
public abstract class AnimationStartListener implements Animation.AnimationListener {

    /* --- Overridden methods --- */

    @Override
    public void onAnimationEnd(Animation animation) {
    }

    @Override
    public void onAnimationRepeat(Animation animation) {
    }

}

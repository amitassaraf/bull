package org.bull;

import android.app.Activity;
import android.content.Intent;

import com.annimon.stream.function.Function;

import org.bull.activity.ActivitySwitcher;

import java.lang.reflect.Method;

/**
 * Raw compilation test
 *
 * Created by amit on 13/01/16.
 */
public class RawMainTest {

    static class TestActivity extends Activity {}

    public static void main(String[] args) {
        ActivitySwitcher switcher = ActivitySwitcher
                                        .$chain(new TestActivity())
                                            .delay(100)
                                            .intentFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                            .transition(R.anim.fadein, R.anim.fadeout)
                                            .exitOnSwitch()
                                            .requireTrigger()
                                        .$switch(TestActivity.class);
        switcher.trigger();


    }
}

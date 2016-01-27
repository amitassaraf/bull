package org.bull;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import com.annimon.stream.function.Function;

import org.bull.activity.ActivitySwitcher;
import org.bull.tasks.CombinedTask;
import org.bull.tasks.MetadataRunnable;
import org.bull.tasks.NetworkTask;
import org.bull.tasks.RepeatingTask;

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

        new CombinedTask(new TestActivity(), metadata -> {
            metadata.putInt("test", 7);
        }, metadata -> {
            System.out.println(metadata.getInt("test", 0));
        }).start();

        new RepeatingTask(new TestActivity(), metadata -> {
            System.out.println("Forever repeating task");
        }, metadata -> true).start();

        Bundle repeatTimes = new Bundle();
        repeatTimes.putInt("repeat", 8);
        new RepeatingTask(new TestActivity(), metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt("repeat", metadata.getInt("repeat") - 1);
        }, metadata -> metadata.getInt("repeat") > 0).start(repeatTimes);

    }
}

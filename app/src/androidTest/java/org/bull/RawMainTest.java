package org.bull;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import org.bull.activity.ActivitySwitcher;
import org.bull.generic.TempConst;
import static org.bull.generic.TempConst.$;
import org.bull.string.StringUtils;
import org.bull.tasks.CombinedTask;
import org.bull.tasks.Metadata;
import org.bull.tasks.RepeatingTask;
import org.bull.tasks.RepeatingUITask;
import org.bull.view.utils.CommonView;

/**
 * Raw compilation test
 *
 * Created by amit on 13/01/16.
 */
public class RawMainTest {

    private static View mSample;

    static class TestActivity extends Activity {}

    public static void main(String[] args) {
        TestActivity mContext = new TestActivity();

        // Activity switcher
        ActivitySwitcher switcher = ActivitySwitcher
                                        .$chain(mContext)
                                            .delay(100)
                                            .intentFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK)
                                            .transition(R.anim.fadein, R.anim.fadeout)
                                            .exitOnSwitch()
                                            .requireTrigger()
                                        .$switch(TestActivity.class);
        switcher.trigger();

        // Combined UI & Thread task
        new CombinedTask(mContext, metadata -> {
            metadata.putInt("test", 7);
        }, metadata -> {
            System.out.println(metadata.getInt("test", 0));
        }).start();

        // Forever repeating task
        new RepeatingTask(mContext, metadata -> {
            System.out.println("Forever repeating task");
        }, metadata -> true).start();

        // Temporary constant strings for less code duplication! Access using TempConst.$(id)
        int repeat = TempConst.$new("repeat");

        // Bull metadata object
        Metadata repeatTimes = new Metadata();
        repeatTimes.putInt($(repeat), 8);

        // Repeating task
        new RepeatingTask(mContext, metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt($(repeat), metadata.getInt($(repeat)) - 1);
        }, metadata -> metadata.getInt($(repeat)) > 0).start(repeatTimes);

        // Repeating UI task
        new RepeatingUITask(mContext, metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt($(repeat), metadata.getInt($(repeat)) - 1);
        }, metadata -> metadata.getInt($(repeat)) > 0).start(repeatTimes);

        // Common generic format string
        String concatString = StringUtils.format("Hey", " my name is ", 8, "Don't forget to star!");

        // Common find view
        mSample = CommonView.findView(mContext, R.id.txt_sample, view -> (TextView) view, text_view -> {
            text_view.setText(concatString);
        });

        // Also added some common ugly checks for the heck of it
        if (Common.notNull(mSample)) {
            mSample.setTop(View.DRAWING_CACHE_QUALITY_AUTO);
        }


    }
}

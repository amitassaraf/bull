package org.bull;

import android.app.Activity;
import android.content.Intent;
import android.view.View;
import android.widget.TextView;

import com.google.common.collect.Lists;

import org.bull.activity.ActivitySwitcher;
import org.bull.generic.Conditioned;
import org.bull.math.RandomUtils;
import org.bull.string.StringUtils;
import org.bull.tasks.CombinedTask;
import org.bull.tasks.Metadata;
import org.bull.tasks.RepeatingTask;
import org.bull.tasks.RepeatingUITask;
import org.bull.view.utils.CommonView;
import org.bull.view.utils.DialogUtils;

import java.util.List;

import static org.bull.CommonUtils.is;


/**
 * Raw compilation test
 * <p>
 * Created by amit on 13/01/16.
 */
public class CompileTimeTest {

    private static View mSample;

    static class TestActivity extends Activity {
    }

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

        String repeat = "repeat";

        // Bull metadata object
        Metadata repeatTimes = new Metadata();
        repeatTimes.putInt(repeat, 8);

        // Repeating task
        new RepeatingTask(mContext, metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt(repeat, metadata.getInt(repeat) - 1);
        }, metadata -> metadata.getInt(repeat) > 0).start(repeatTimes);

        // Repeating UI task
        new RepeatingUITask(mContext, metadata -> {
            System.out.println("This repeats 8 times!");
            metadata.putInt(repeat, metadata.getInt(repeat) - 1);
        }, metadata -> metadata.getInt(repeat) > 0).start(repeatTimes);

        // Common generic format string
        String concatString = StringUtils.format("Hey", " my name is ", 8, "Don't forget to star!");

        // Common find view
        mSample = CommonView.findView(mContext, R.id.txt_sample, view -> (TextView) view, text_view -> {
            text_view.setText(concatString);
        });

        // Also added some common ugly checks for the heck of it
        if (CommonUtils.notNull(mSample)) {
            mSample.setTop(View.DRAWING_CACHE_QUALITY_AUTO);
        }

        // Quick show dialog message
        DialogUtils.showMessagePopup(mContext, "Hello", "mate!");

        // View draw listener
        CommonView.setViewDrawListener(mSample, view -> {
            int drawnHeight = view.getHeight();
            DialogUtils.showMessagePopup(mContext, "View Height",
                    StringUtils.format("View height is ", drawnHeight));
        });

        // 'is' is a function that is used to check the logical existence of a variable
        // similar to python's "if var: # do stuff"
        if (CommonUtils.is(mSample)) {
            System.out.println("Woo hoo!");
        }

        // import static org.bull.CommonUtils.is;
        // Long ass example:
        List<Integer> list = Lists.newArrayList();
        if (is(list)) {
            System.out.println("Won't enter!");
        }

        list.add(null);
        if (is(list)) {
            System.out.println("Still won't enter!");
        }

        list.add(5);
        if (is(list)) {
            System.out.println("Will enter!");
        }

        // Conditioned is an object that returns between two values based on a condition
        Conditioned<Integer> menuColor = new Conditioned<>(R.color.colorPrimary,
                R.color.colorAccent, RandomUtils::yesno);

        // Get the value based on the condition
        System.out.println(StringUtils.format("This time we got color ", menuColor.get()));

    }
}

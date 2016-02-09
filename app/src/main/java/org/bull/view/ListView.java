package org.bull.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;

import org.bull.R;
import org.bull.view.utils.ListViewUtils;

/**
 * A ListView with some useful attributes (Improved List View)
 * Created by amit on 10/02/16.
 */
public class ListView extends android.widget.ListView {

    /* --- Members --- */

    private final int maxHeight;

    /* --- Constructors --- */

    /**
     * Base constructor
     * @param context - App context
     */
    public ListView(Context context) {
        this(context, null);
    }

    /**
     * Secondary constructor
     * @param context - App context
     * @param attrs - Attribute set
     */
    public ListView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    /**
     * Third constructor
     * @param context - App context
     * @param attrs - Attribute set
     * @param defStyleAttr - The default style attr
     */
    public ListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        if (attrs != null) {
            TypedArray a = getContext().obtainStyledAttributes(attrs, R.styleable.ListView);
            maxHeight = a.getDimensionPixelSize(R.styleable.ListView_maxHeight, Integer.MAX_VALUE);
            a.recycle();
        } else {
            maxHeight = 0;
        }
    }

    /* --- General Methods --- */

    /**
     * Method to set the height of the list view based on it's items
     */
    public void setHeightBasedOnItems() {
        ListViewUtils.setListViewHeightBasedOnItems(this);
    }

    /* --- Overridden methods --- */

    /**
     * Overridden to limit the height based on max height
     * @param widthMeasureSpec - width measure spec
     * @param heightMeasureSpec - height measure spec
     */
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int measuredHeight = MeasureSpec.getSize(heightMeasureSpec);
        if (maxHeight > 0 && maxHeight < measuredHeight) {
            int measureMode = MeasureSpec.getMode(heightMeasureSpec);
            heightMeasureSpec = MeasureSpec.makeMeasureSpec(maxHeight, measureMode);
        }
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
    }

}

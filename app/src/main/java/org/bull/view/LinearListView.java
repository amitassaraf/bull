package org.bull.view;

import android.content.Context;
import android.database.DataSetObserver;
import android.util.AttributeSet;
import android.view.View;
import android.widget.Adapter;
import android.widget.LinearLayout;

import lombok.Getter;
import lombok.experimental.Accessors;

/**
 * LinearLayout with ListView functionality
 * Created by amit on 10/02/16.
 */
@Accessors(prefix = "m")
public class LinearListView extends LinearLayout {

    @Getter
    private Adapter mAdapter;

    public LinearListView(Context context) {
        super(context);
    }

    public LinearListView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LinearListView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * Method to set the linear list view adapter
     *
     * @param mAdapter - The adapter
     */
    public void setAdapter(Adapter mAdapter) {
        this.mAdapter = mAdapter;
        this.mAdapter.registerDataSetObserver(new LinearListDataSetObserver());
    }

    private class LinearListDataSetObserver extends DataSetObserver {

        @Override
        public void onChanged() {
            LinearListView.this.removeAllViews();
            for (int i = 0; i < mAdapter.getCount(); i++) {
                View itemView = mAdapter.getView(i, null, LinearListView.this);
                LinearListView.this.addView(itemView);
            }
            super.onChanged();
        }

        @Override
        public void onInvalidated() {
            this.onChanged();
            super.onInvalidated();
        }
    }
}

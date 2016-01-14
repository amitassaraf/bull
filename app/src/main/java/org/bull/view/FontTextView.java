package org.bull.view;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

import org.bull.R;

/**
 * View used to be able to give a font from assets/fonts/FONT_FILE_NAME to a textview.
 * <p>
 * Created by amit on 14/01/16.
 */
public class FontTextView extends TextView {

    /* --- Members --- */

    private static Typeface font;

    /* --- Consturctors --- */

    public FontTextView(Context context) {
        super(context);
        initFont(context, null);
    }

    public FontTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        initFont(context, attrs);
    }

    public FontTextView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initFont(context, attrs);
    }

    /* --- General methods --- */

    /**
     * Initialize the font with the context and attributes
     * @param context - The app context
     * @param attrs - The attributeset
     */
    private void initFont(Context context, AttributeSet attrs) {
        String fontName = null;
        if (attrs != null) {
            TypedArray ta = context.obtainStyledAttributes(attrs, R.styleable.FontTextView, 0, 0);
            try {
                fontName = ta.getString(R.styleable.FontTextView_font_file_name);
            } finally {
                ta.recycle();
            }
        }

        if (font == null && fontName != null) {
            font = Typeface.createFromAsset(context.getAssets(), String.format("fonts/%s", fontName));
        } else if (font != null) {
            this.setTypeface(font);
        }
    }

}

package com.mehdok.fontify;

import android.content.Context;
import android.graphics.Typeface;
import android.support.v7.widget.AppCompatButton;
import android.util.AttributeSet;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class BaseButton extends AppCompatButton {
    public BaseButton(Context context) {
        super(context);
    }

    public BaseButton(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public BaseButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    protected void init(FontType fontType) {
        Typeface typeface = TypefaceUtil.getInstance().getTypeFace(getContext(), fontType);

        if (typeface != null) {
            setTypeface(typeface);
        }
    }
}

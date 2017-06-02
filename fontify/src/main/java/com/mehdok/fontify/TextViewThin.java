package com.mehdok.fontify;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class TextViewThin extends BaseTextView {
    public TextViewThin(Context context) {
        super(context);

        init(FontType.THIN);
    }

    public TextViewThin(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(FontType.THIN);
    }

    public TextViewThin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(FontType.THIN);
    }
}

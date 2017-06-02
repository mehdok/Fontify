package com.mehdok.fontify;

import android.content.Context;
import android.util.AttributeSet;

/**
 * @author mehdok (mehdok@gmail.com) on 6/2/2017.
 */

public class TextViewNormal extends BaseTextView {
    public TextViewNormal(Context context) {
        super(context);

        init(FontType.NORMAL);
    }

    public TextViewNormal(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(FontType.NORMAL);
    }

    public TextViewNormal(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);

        init(FontType.NORMAL);
    }
}

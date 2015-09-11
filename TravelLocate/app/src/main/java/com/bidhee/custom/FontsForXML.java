package com.bidhee.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontsForXML extends TextView{
	
	public FontsForXML(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontsForXML(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontsForXML(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                                               "Roboto-Regular.ttf");
        setTypeface(tf);
    }

}



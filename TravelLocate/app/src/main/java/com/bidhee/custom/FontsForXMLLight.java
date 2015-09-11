package com.bidhee.custom;

import android.content.Context;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.widget.TextView;

public class FontsForXMLLight extends TextView{
	
	public FontsForXMLLight(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }

    public FontsForXMLLight(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public FontsForXMLLight(Context context) {
        super(context);
        init();
    }

    private void init() {
        Typeface tf = Typeface.createFromAsset(getContext().getAssets(),
                                               "Roboto-Light.ttf");
        setTypeface(tf);
    }

}



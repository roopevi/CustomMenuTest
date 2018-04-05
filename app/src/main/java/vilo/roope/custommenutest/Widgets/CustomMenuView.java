package vilo.roope.custommenutest.Widgets;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.LinearLayout;

import vilo.roope.custommenutest.R;

public class CustomMenuView extends LinearLayout {

    public CustomMenuView(Context context) {
        super(context);
    }

    public CustomMenuView(Context context, AttributeSet attrs) {
        this(context, attrs,0);
    }

    public CustomMenuView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init(){

        inflate(getContext(), R.layout.custom_menu_layout, this);

    }
}

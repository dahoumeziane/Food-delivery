package com.dahou.fooddelivery;

import android.widget.ImageView;
import android.widget.TextView;

public class BottomBarElement {

    ImageView icon;
    TextView txt ;

    public BottomBarElement(ImageView icon, TextView txt) {
        this.icon = icon;
        this.txt = txt;
    }

    public ImageView getIcon() {
        return icon;
    }

    public TextView getTxt() {
        return txt;
    }
}

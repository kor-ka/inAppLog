package com.mycompany.myapp;

public class CardHeaderView extends FrameLayout{

  public inAppLogView(Context context) {
        super(context);
    LayoutInflater inflater = (LayoutInflater) getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mInternalOuterView = inflater.inflate(R.layout.inapploglay, this, true);
    }

}

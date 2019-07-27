package com.frenzy.ebook.mysummary1;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SingerItemView extends LinearLayout {

    TextView nameView;
    TextView commentView;

    public SingerItemView(Context context) {
        super(context);

        init(context);
    }

    public SingerItemView(Context context, AttributeSet attrs) {
        super(context, attrs);

        init(context);
    }

    private void init(Context context){
        LayoutInflater layoutInflater = (LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        layoutInflater.inflate(R.layout.singer_item,this,true);

        nameView = (TextView)findViewById(R.id.reviewer_name);
        commentView = (TextView)findViewById(R.id.reviewer_comment);

    }

    public void setName(String name){
        nameView.setText(name);
    }

    public void setMobile(String comment){
        commentView.setText(comment);
    }
}

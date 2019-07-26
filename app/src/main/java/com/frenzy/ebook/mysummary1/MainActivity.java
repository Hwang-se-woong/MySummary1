package com.frenzy.ebook.mysummary1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    Button disLikeButton;
    TextView likeCountView;
    TextView disLikeCountView;

    int likeCount = 0;
    boolean likeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(likeState){
                    decrLikeCount();
                }else{
                    incLikeCount();
                }

                likeState = !likeState;
            }
        });

        disLikeButton = (Button) findViewById(R.id.disLikeButton);

        likeCountView = (TextView) findViewById(R.id.likeCountView);
        disLikeCountView = (TextView) findViewById(R.id.disLikeCountView);

    }

    public void incLikeCount(){
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);

    }

    public void decrLikeCount(){
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up);

    }
}

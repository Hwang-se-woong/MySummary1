package com.frenzy.ebook.mysummary1;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    Button likeButton;
    Button dislikeButton;
    TextView likeCountView;
    TextView dislikeCountView;

    int likeCount = 0;
    int dislikeCount = 0;
    boolean likeState = false;
    boolean dislikeState = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ListView listView = (ListView)findViewById(R.id.listView);
        SingerAdapter adapter = new SingerAdapter();

        adapter.addItem(new SingerItem("id1","재미없다"));
        adapter.addItem(new SingerItem("id2","재미있다"));
        adapter.addItem(new SingerItem("소녀시대","010-2432-1231"));
        adapter.addItem(new SingerItem("소녀시대","010-2432-1231"));
        adapter.addItem(new SingerItem("소녀시대","010-2432-1231"));
        listView.setAdapter(adapter);

        //작성버튼
        Button writeButton = (Button)findViewById(R.id.write_button);
        writeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"작성했습니다.",Toast.LENGTH_LONG).show();
            }
        });

        //모두보기
        Button showAllButton = (Button)findViewById(R.id.show_all);
        showAllButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"모두보기",Toast.LENGTH_LONG).show();
            }
        });

        //좋아요버튼 시작
        likeButton = (Button) findViewById(R.id.likeButton);
        likeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (likeState == false && dislikeState == false) {
                    incLikeCount();
                    likeState = !likeState;
                } else if (likeState == true && dislikeState == false) {
                    decrLikeCount();
                    likeState = !likeState;
                }
            }
        });

        dislikeButton = (Button) findViewById(R.id.dislikeButton);
        dislikeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (dislikeState == false && likeState == false) {
                    incDislikeCount();
                    dislikeState = !dislikeState;
                } else if (dislikeState == true && likeState == false) {
                    decrDislkeCount();
                    dislikeState = !dislikeState;
                }
            }
        });

        likeCountView = (TextView) findViewById(R.id.likeCountView);
        dislikeCountView = (TextView) findViewById(R.id.dislikeCountView);


    }

    public void incLikeCount() {
        likeCount += 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up_selected);

    }

    public void decrLikeCount() {
        likeCount -= 1;
        likeCountView.setText(String.valueOf(likeCount));

        likeButton.setBackgroundResource(R.drawable.ic_thumb_up);

    }

    public void incDislikeCount() {
        dislikeCount += 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));

        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down_selected);

    }

    public void decrDislkeCount() {
        dislikeCount -= 1;
        dislikeCountView.setText(String.valueOf(dislikeCount));

        dislikeButton.setBackgroundResource(R.drawable.ic_thumb_down);

    }
    //좋아요버튼 끝

    class SingerAdapter extends BaseAdapter {

        ArrayList<SingerItem> items = new ArrayList<SingerItem>();
        @Override
        public int getCount() {
            return items.size();
        }

        public void addItem(SingerItem item){
            items.add(item);
        }


        @Override
        public Object getItem(int i) {
            return items.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            SingerItemView singerItemView = new SingerItemView(getApplicationContext());
            SingerItem item = items.get(i);
            singerItemView.setName(item.getName());
            singerItemView.setMobile(item.getComment());

            return singerItemView;
        }
    }

}

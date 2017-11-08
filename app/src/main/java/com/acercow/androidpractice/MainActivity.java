package com.acercow.androidpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;

import com.acercow.androidpractice.rankview.HourRankingView;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ((HourRankingView)findViewById(R.id.ranking)).updateContent(" 在输出之前放置m个0在输出个0 ");

        findViewById(R.id.ranking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WebView web = new XiaoSenWebView(MainActivity.this);
                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.web);
                web.startAnimation(anim);

            }
        });
//        startActivity(new Intent(this, GestureTestActivity.class));
//        startActivity(new Intent(this, ScreenSlidePageActivity.class));
//        startActivity(new Intent(this, LifeCycleActivity.class));
//        finish();
//        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
//        User user = new User("Test", "User");
//        binding.setUser(user);
//        binding.setMyHandler(new MyHandler() {
//            @Override
//            public void onClickFriend(View view) {
//                super.onClickFriend(view);
//                Toast.makeText(MainActivity.this, "bind success", Toast.LENGTH_SHORT).show();
//            }
//        });
//
//        binding.setTask(new Task());
//        binding.setPresenter(new Presenter() {
//            @Override
//            public void onSaveClick(Task task) {
//                super.onSaveClick(task);
//            }
//        });
//
//        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
//            }
//        });

//        findViewById(R.id.view).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this, "view", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
    }
}
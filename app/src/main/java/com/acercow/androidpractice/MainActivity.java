package com.acercow.androidpractice;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import com.acercow.androidpractice.rankview.HourRankingHeaderView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {

    int i = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((HourRankingHeaderView) findViewById(R.id.ranking)).updateContent(" 另撒娇扥拉斯看扥令爱三扥 ");

        findViewById(R.id.ranking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                WebView web = new XiaoSenWebView(MainActivity.this);
//                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.web);
//                web.startAnimation(anim);
//                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
                HourRankingDialog dialog = new HourRankingDialog(MainActivity.this, R.style.CommonBottomDialog);
                dialog.show();

            }
        });
//        startActivity(new Intent(this, GestureTestActivity.class));
//        startActivity(new Intent(this, ScreenSlidePageActivity.class));
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
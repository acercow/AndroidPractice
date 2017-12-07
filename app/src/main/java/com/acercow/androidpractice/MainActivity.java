package com.acercow.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.acercow.androidpractice.lifecycle.LifeCycleActivity;
import com.acercow.androidpractice.rankview.HourRankingHeaderView;
import com.acercow.androidpractice.viewpager.ScreenSlidePageActivity;

public class MainActivity extends AppCompatActivity {
    private static final String TAG = "[LifeCycle]" + "[Main]";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        Log.v(TAG, "onCreate");
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ((HourRankingHeaderView) findViewById(R.id.ranking)).updateContent(" 另撒娇扥拉斯看扥令爱三扥 ");

        findViewById(R.id.ranking).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                WebView web = new XiaoSenWebView(MainActivity.this);
//                Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.web);
//                web.startAnimation(anim);
                startActivity(new Intent(MainActivity.this, LifeCycleActivity.class));
//                HourRankingDialog dialog = new HourRankingDialog(MainActivity.this, R.style.CommonBottomDialog);
//                dialog.show();

            }
        });
//        startActivity(new Intent(this, GestureTestActivity.class));
//        startActivity(new Intent(this, ScreenSlidePageActivity.class));
        startActivity(new Intent(this, ScreenSlidePageActivity.class));
        finish();
//        Activit yMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
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


    @Override
    public void onStart() {
        Log.v(TAG, "onStart");
        super.onStart();
    }

    @Override
    public void onResume() {
        Log.v(TAG, "onResume");
        super.onResume();
    }

    @Override
    public void onPause() {
        Log.v(TAG, "onPause");
        super.onPause();
    }

    @Override
    public void onStop() {
        Log.v(TAG, "onStop");
        super.onStop();
    }

    @Override
    public void onDestroy() {
        Log.v(TAG, "onDestroy");
        super.onDestroy();
    }
}
package com.acercow.androidpractice;

import android.content.Intent;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Toast;

import com.acercow.androidpractice.databinding.ActivityMainBinding;
import com.acercow.androidpractice.databinding.MyHandler;
import com.acercow.androidpractice.databinding.Presenter;
import com.acercow.androidpractice.databinding.Task;
import com.acercow.androidpractice.databinding.User;
import com.acercow.androidpractice.lifecycle.LifeCycleActivity;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this, GestureTestActivity.class));
//        startActivity(new Intent(this, ScreenSlidePageActivity.class));
//        finish();
        startActivity(new Intent(this, LifeCycleActivity.class));
        finish();
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        User user = new User("Test", "User");
        binding.setUser(user);
        binding.setMyHandler(new MyHandler() {
            @Override
            public void onClickFriend(View view) {
                super.onClickFriend(view);
                Toast.makeText(MainActivity.this, "bind success", Toast.LENGTH_SHORT).show();
            }
        });

        binding.setTask(new Task());
        binding.setPresenter(new Presenter() {
            @Override
            public void onSaveClick(Task task) {
                super.onSaveClick(task);
            }
        });

        findViewById(R.id.click).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "clicked", Toast.LENGTH_SHORT).show();
            }
        });

//        findViewById(R.id.view).setOnTouchListener(new View.OnTouchListener() {
//            @Override
//            public boolean onTouch(View v, MotionEvent event) {
//                Toast.makeText(MainActivity.this, "view", Toast.LENGTH_SHORT).show();
//                return false;
//            }
//        });
    }
}
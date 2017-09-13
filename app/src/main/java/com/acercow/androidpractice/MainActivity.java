package com.acercow.androidpractice;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.acercow.androidpractice.gesture.GestureTestActivity;
import com.acercow.androidpractice.viewpager.ScreenSlidePageActivity;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        startActivity(new Intent(this, GestureTestActivity.class));
        startActivity(new Intent(this, ScreenSlidePageActivity.class));
        startActivity(new Intent(this, ScreenSlidePageActivity.class));
    }
}

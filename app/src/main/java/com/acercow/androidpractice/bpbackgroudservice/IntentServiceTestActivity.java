package com.acercow.androidpractice.bpbackgroudservice;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;

import com.acercow.androidpractice.R;

public class IntentServiceTestActivity extends Activity {
    public final static String TAG = IntentServiceTestActivity.class.getSimpleName();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_intent_service_test);
        Log.i(TAG, "Thread :: " + Thread.currentThread());
        MyIntentService2.startActionDownload(this, "param");
    }
}

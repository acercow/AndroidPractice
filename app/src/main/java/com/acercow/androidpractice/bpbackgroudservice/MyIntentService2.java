package com.acercow.androidpractice.bpbackgroudservice;

import android.app.IntentService;
import android.content.Context;
import android.content.Intent;
import android.support.annotation.Nullable;
import android.util.Log;


/**
 * Created by Jansen on 2017/9/16.
 */

public class MyIntentService2 extends IntentService {
    public final static String TAG = MyIntentService2.class.getSimpleName();

    public final static String EXTRA_TASKS = "com.acercow.androidpractice.bpbackgroudservice.extra.tasks";
    public final static String ACTION_DOWNLOAD = "com.acercow.androidpractice.bpbackgroudservice.action.download";
    /**
     * Creates an IntentService.  Invoked by your subclass's constructor.
     *
     * @param name Used to name the worker thread, important only for debugging.
     */
    public MyIntentService2(String name) {
        super(name);
        Log.i(TAG, "Thread :: " + Thread.currentThread());
    }

    @Override
    protected void onHandleIntent(@Nullable Intent intent) {
        if (intent != null) {
            Log.i(TAG, "Thread :: " + Thread.currentThread());
        }
    }


    public static void startActionDownload(Context context, String param) {
        Intent intent = new Intent();
        intent.setAction(ACTION_DOWNLOAD);
        intent.putExtra(EXTRA_TASKS, param);
        context.startActivity(intent);
    }
}

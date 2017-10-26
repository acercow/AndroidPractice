package com.acercow.androidpractice;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.Toast;

import com.acercow.androidpractice.gesture.GestureTestActivity;
import com.acercow.androidpractice.viewpager.ScreenSlidePageActivity;

public class MainActivity extends Activity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private View mDecorView;
    private EditText et;
    private InputMethodManager mInputMethodManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mDecorView = getWindow().getDecorView();
//        mDecorView.setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN);

        final AlertDialog.Builder alert = new AlertDialog.Builder(MainActivity.this)
                .setTitle("title");
        setContentView(R.layout.activity_main);
        FragmentManager fm = getFragmentManager();
        fm.beginTransaction().replace(R.id.main_content, new PlusOneFragment()).commit();
//        AndroidBug5497Workaround.assistActivity(this, findViewById(R.id.hide_key));
        findViewById(R.id.hide_key).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AndroidBug5497Workaround.assistActivity(MainActivity.this, findViewById(R.id.et));
                InputMethodManager imm = (InputMethodManager)
                        getSystemService(Context.INPUT_METHOD_SERVICE);
                imm.toggleSoftInput(InputMethodManager.SHOW_IMPLICIT, 0);

                Toast.makeText(MainActivity.this, "", Toast.LENGTH_SHORT).show();
            }
        });
        findViewById(R.id.et).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "et clicked", Toast.LENGTH_SHORT).show();
                showKeyboard();
            }
        });

//        et = (EditText) findViewById(R.id.et_test);
//        findViewById(R.id.et_test).setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                hideKeyboard();
//            }
//        });
//        startActivity(new Intent(this, GestureTestActivity.class));
//        startActivity(new Intent(this, ScreenSlidePageActivity.class));
//        finish();
    }

    @Override
    public void onWindowFocusChanged(boolean hasFocus) {
        super.onWindowFocusChanged(hasFocus);
//            hidestickySystemUI();
        Log.d(TAG, "onWindowFocusChanged :: hasFocus :: " + hasFocus);
    }


    private void hidestickySystemUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
    }


    // This snippet hides the system bars.
    private void hideSystemUI() {
        // Set the IMMERSIVE flag.
        // Set the content to appear under the system bars so that the content
        // doesn't resize when the system bars hide and show.
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                        | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION // hide nav bar
                        | View.SYSTEM_UI_FLAG_FULLSCREEN // hide status bar
                        | View.SYSTEM_UI_FLAG_IMMERSIVE);
    }


    // This snippet shows the system bars. It does this by removing all the flags
// except for the ones that make the content appear under the system bars.
    private void showSystemUI() {
        mDecorView.setSystemUiVisibility(
                View.SYSTEM_UI_FLAG_LAYOUT_STABLE
                        | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                        | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
    }

    public void showKeyboard() {
        if (mInputMethodManager == null) {
            mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
//        mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
        mInputMethodManager.showSoftInput(et, 0); // 默认chatedit隐藏的 所以传过去也获取不到焦点
    }

    public void hideKeyboard() {
        if (mInputMethodManager == null) {
            mInputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        }
//        mInputMethodManager.toggleSoftInput(0, InputMethodManager.HIDE_NOT_ALWAYS);
//        mInputMethodManager.hideSoftInputFromWindow(chatEdit.getWindowToken(), 0); // 默认chatedit隐藏的 所以传过去也获取不到焦点
    }
}

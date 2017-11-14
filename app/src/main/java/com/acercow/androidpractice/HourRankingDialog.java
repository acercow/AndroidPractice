package com.acercow.androidpractice;

import android.app.Activity;
import android.app.Dialog;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by zhaosen on 2017/11/8.
 */

public class HourRankingDialog extends Dialog {

    private TextView tvCountDown;
    private Activity activity;
    private int mTotalSecond;
    private Timer mTimer;
    private WebView webView;

    public HourRankingDialog(@NonNull Activity activity, int themeResId) {
        super(activity, themeResId);
        this.activity = activity;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_hour_rank);
        tvCountDown = (TextView) findViewById(R.id.tv_count_down);
        webView = (WebView) findViewById(R.id.web_view);
        intWindow();
        updateTimer(3);
        webView.getSettings().setJavaScriptEnabled(true);
        webView.setWebViewClient(new WebViewClient(){
            public boolean shouldOverrideUrlLoading(WebView view, String url){
                view.loadUrl(url);
                return true;
            }
        });
        webView.loadUrl("https://www.baidu.com");

    }

    private void intWindow() {
        Window window = getWindow();
//        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        window.setGravity(Gravity.BOTTOM);
        WindowManager.LayoutParams layoutParams = window.getAttributes();
        layoutParams.width = WindowManager.LayoutParams.MATCH_PARENT;
        layoutParams.height = WindowManager.LayoutParams.WRAP_CONTENT;
        window.setAttributes(layoutParams);
    }

    public void updateTimer(final int totalSecond) {
        this.mTotalSecond = totalSecond;
        mTimer = new Timer();
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                String cdStr = String.format(getContext().getResources().getString(R.string.hour_ranking_webview_count_down), getMinutes(mTotalSecond), getSeconds(mTotalSecond));
                final SpannableString spannableString= new SpannableString(cdStr);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.colorAccent)), 7, 9, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.colorAccent)), 12, 14, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
                activity.runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        tvCountDown.setText(spannableString);
                        if (mTotalSecond < 0) {
                            mTimer.cancel();
                            webView.loadUrl("https://www.sina.com.cn");
                        }
                    }
                });
                mTotalSecond--;
            }
        }, 0, 1000);
    }

    @Override
    protected void onStop() {
        super.onStop();
        mTimer.cancel();
    }

    private String getMinutes(int count) {
        int minute = count / 60;
        if (minute < 10) {
            return "0" + minute;
        }
        return String.valueOf(minute);
    }

    private String getSeconds(int count) {
        int second = count % 60;
        if (second < 10) {
            return "0" + second;
        }
        return String.valueOf(second);
    }


}

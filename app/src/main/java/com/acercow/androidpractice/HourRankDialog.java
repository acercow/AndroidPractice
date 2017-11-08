package com.acercow.androidpractice;

import android.app.Dialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.text.SpannableString;
import android.text.Spanned;
import android.text.style.ForegroundColorSpan;
import android.view.Gravity;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

/**
 * Created by Administrator on 2017/11/8.
 */

public class HourRankDialog extends Dialog {

    public HourRankDialog(@NonNull Context context, int themeResId) {
        super(context, themeResId);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webview_hour_rank);
        TextView tvCountDown = (TextView) findViewById(R.id.tv_count_down);

        String cdStr = String.format(getContext().getResources().getString(R.string.hour_ranking_webview_count_down), 12, 43);
        SpannableString spannableString= new SpannableString(cdStr);
        spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.colorAccent)), 6, 8, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        spannableString.setSpan(new ForegroundColorSpan(getContext().getResources().getColor(R.color.colorAccent)), 9, 11, Spanned.SPAN_INCLUSIVE_EXCLUSIVE);
        tvCountDown.setText(spannableString);

        intWindow();
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
}

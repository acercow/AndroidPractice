package com.acercow.androidpractice;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;

/**
 * Created by Administrator on 2017/11/8.
 */

public class XiaoSenWebView extends WebView {
    public XiaoSenWebView(Context context) {
        super(context);
        init();
    }

    public XiaoSenWebView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init() {
        loadUrl("http://www.baidu.com");
    }


}

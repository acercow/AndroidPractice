package com.acercow.androidpractice.rankview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.acercow.androidpractice.R;

/**
 *
 *
 *
 */
public class HourRankingView extends FrameLayout implements View.OnClickListener {

    private TextView mTextView;
    private String mDefaultTitle;
    private LinearLayout mllContent;

    public HourRankingView(Context context) {
        super(context);
        init(null, 0);
    }

    public HourRankingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HourRankingView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressLint("ResourceType")
    private void init(AttributeSet attrs, int defStyle) {
        mDefaultTitle = getContext().getResources().getString(R.string.hour_ranking_default_title);
        // To support right icon displayed outside of its bounds
        setClipChildren(false);

        mllContent = new LinearLayout(getContext());
        LayoutParams contentParams = new LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        mllContent.setLayoutParams(contentParams);
        mllContent.setOrientation(LinearLayout.HORIZONTAL);
        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setColors(new int[]{0xB3FF5C25, 0xB3FF374A});
        gradientDrawable.setCornerRadius(90);
        mllContent.setBackground(gradientDrawable);
        mllContent.setClipChildren(false);
        addView(mllContent);

        ImageView ivLft = new ImageView(getContext());
        ivLft.setId(1000);
        LinearLayout.LayoutParams ltIconParams = new LinearLayout.LayoutParams(dip2px(12), dip2px(12));
        ltIconParams.weight = 0;
        ivLft.setLayoutParams(ltIconParams);
        ivLft.setImageDrawable(getContext().getResources().getDrawable(R.drawable.wblive_hour_rank_bg_left));
        mllContent.addView(ivLft);

        mTextView = new TextView(getContext());
        mTextView.setId(1002);
        LinearLayout.LayoutParams textParams = new LinearLayout.LayoutParams(0, ViewGroup.LayoutParams.WRAP_CONTENT);
        textParams.gravity = Gravity.CENTER_VERTICAL;
        textParams.weight = 1;
        textParams.leftMargin = dip2px(-2);
        mTextView.setLayoutParams(textParams);
        mTextView.setTextColor(0xFFFFFFFF);
        mTextView.setTextSize(14);
        mTextView.setText(mDefaultTitle);
        mTextView.setLines(1);
        mTextView.setEllipsize(TextUtils.TruncateAt.END);
        mllContent.addView(mTextView);

        ImageView ivArrow = new ImageView(getContext());
        LinearLayout.LayoutParams arrowParams = new LinearLayout.LayoutParams(dip2px(6), dip2px(8.6F));
        arrowParams.weight = 0;
        arrowParams.gravity = Gravity.CENTER_VERTICAL;
        arrowParams.leftMargin = dip2px(4);
        ivArrow.setLayoutParams(arrowParams);
        ivArrow.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_arrow_right));
        mllContent.addView(ivArrow);


        ImageView ivRt = new ImageView(getContext());
        LinearLayout.LayoutParams rtIconParams = new LinearLayout.LayoutParams(dip2px(12), dip2px(12));
        rtIconParams.weight = 0;
        rtIconParams.gravity = Gravity.BOTTOM;
        rtIconParams.leftMargin = dip2px(-2);
        ivRt.setLayoutParams(rtIconParams);
        ivRt.setImageDrawable(getContext().getResources().getDrawable(R.drawable.wblive_hour_rank_bg_right));
        ivRt.setTranslationX(dip2px(4));
        mllContent.addView(ivRt);

//        setOnClickListener(this);
    }

    public void updateContent(String content) {
        this.updateContent(null, content);
    }

    public void updateContent(String title, String content) {
        this.updateContent(title, content, -1, -1);
    }

    public void updateContent(String title, String content, int color, int size) {
        if (color != -1) mTextView.setTextColor(color);
        if (size != -1) mTextView.setTextSize(size);
        mDefaultTitle = TextUtils.isEmpty(title) ? mDefaultTitle : title;
        mTextView.setText(String.format(getContext().getResources().getString(R.string.hour_ranking), mDefaultTitle, content));
    }


    public int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mllContent.setOnClickListener(l);
    }

    @Override
    public void onClick(View v) {
//        getContext().startActivity(new Intent(getContext(), WebViewActivity.class));
    }
}

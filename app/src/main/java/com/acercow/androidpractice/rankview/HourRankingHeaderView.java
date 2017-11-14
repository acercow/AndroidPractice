package com.acercow.androidpractice.rankview;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Resources;
import android.graphics.drawable.GradientDrawable;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.acercow.androidpractice.R;

/**
 *
 * Created by zhaosen on 2017/11/8.
 *
 */
public class HourRankingHeaderView extends RelativeLayout implements View.OnClickListener {

    private TextView mTextView;
    private String mDefaultTitle;

public HourRankingHeaderView(Context        context) {
        super(context);
        init(null, 0);
    }

    public HourRankingHeaderView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(attrs, 0);
    }

    public HourRankingHeaderView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(attrs, defStyle);
    }

    @SuppressLint("ResourceType")
    private void init(AttributeSet attrs, int defStyle) {
        mDefaultTitle = getContext().getResources().getString(R.string.hour_ranking_default_title);
        // To support right icon displayed outside of its bounds
//        setClipChildren(false);

        GradientDrawable gradientDrawable = new GradientDrawable();
        gradientDrawable.setOrientation(GradientDrawable.Orientation.LEFT_RIGHT);
        gradientDrawable.setGradientType(GradientDrawable.LINEAR_GRADIENT);
        gradientDrawable.setColors(new int[]{0xB3FF5C25, 0xB3FF374A});
        gradientDrawable.setCornerRadius(90);

        mTextView = new TextView(getContext());
        mTextView.setId(1000);
        LayoutParams textParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.MATCH_PARENT);
        mTextView.setLayoutParams(textParams);
        mTextView.setPadding(dip2px(10), 0, dip2px(19), 0);
        mTextView.setTextColor(0xFFFFFFFF);
        mTextView.setTextSize(12);
        mTextView.setText(mDefaultTitle);
        mTextView.setGravity(Gravity.CENTER_VERTICAL);
        mTextView.setLines(1);
        mTextView.setMaxWidth(Resources.getSystem().getDisplayMetrics().widthPixels - dip2px(20));
        mTextView.setBackground(gradientDrawable);
        mTextView.setEllipsize(TextUtils.TruncateAt.END);
        addView(mTextView);

        ImageView ivArrow = new ImageView(getContext());
        LayoutParams arrowParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
        arrowParams.addRule(ALIGN_RIGHT, mTextView.getId());
        arrowParams.addRule(CENTER_VERTICAL);
        arrowParams.rightMargin = dip2px(10F);
        ivArrow.setLayoutParams(arrowParams);
        ivArrow.setImageDrawable(getContext().getResources().getDrawable(R.drawable.icon_arrow_right));
        addView(ivArrow);

        ImageView ivLft = new ImageView(getContext());
        LayoutParams ltIconParams = new LayoutParams(dip2px(12), dip2px(12));
        ivLft.setLayoutParams(ltIconParams);
        ivLft.setImageDrawable(getContext().getResources().getDrawable(R.drawable.wblive_hour_rank_bg_left));
        addView(ivLft);

        ImageView ivRt = new ImageView(getContext());
        LayoutParams rtIconParams = new LayoutParams(dip2px(12), dip2px(12));
        rtIconParams.addRule(RIGHT_OF, mTextView.getId());
        rtIconParams.addRule(ALIGN_BOTTOM, mTextView.getId());
        rtIconParams.leftMargin = dip2px(-8);
        ivRt.setLayoutParams(rtIconParams);
        ivRt.setImageDrawable(getContext().getResources().getDrawable(R.drawable.wblive_hour_rank_bg_right));
        addView(ivRt);

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
        mTextView.setText(String.format(getContext().getResources().getString(R.string.hour_ranking_header), mDefaultTitle, content));
    }


    public int dip2px(float dipValue) {
        final float scale = getContext().getResources().getDisplayMetrics().density;
        return (int) (dipValue * scale + 0.5f);
    }

    @Override
    public void setOnClickListener(@Nullable OnClickListener l) {
        mTextView.setOnClickListener(l);
    }

    @Override
    public void onClick(View v) {
//        getContext().startActivity(new Intent(getContext(), WebViewActivity.class));
    }
}

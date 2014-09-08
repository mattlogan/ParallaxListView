package me.mattlogan.parallaxlistview.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

public class ParallaxListView extends FrameLayout {

    private ScrollView mScrollView;
    private LinearLayout mBackgroundLayout;
    private ImageView mBackgroundImage;
    private View mBackgroundLowerView;

    private ListView mListView;

    public ParallaxListView(Context context) {
        super(context);
        init(context);
    }

    public ParallaxListView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public ParallaxListView(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init(context);
    }

    private void init(Context context) {
        mScrollView = new ScrollView(context);
        mScrollView.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(mScrollView);

        mBackgroundLayout = new LinearLayout(context);
        mBackgroundLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mBackgroundLayout.setOrientation(LinearLayout.VERTICAL);
        mScrollView.addView(mBackgroundLayout);

        int imageHeight = (int) (context.getResources().getDisplayMetrics().heightPixels * 2 / 3f);

        mBackgroundImage = new ImageView(context);
        mBackgroundImage.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, imageHeight));
        mBackgroundLayout.addView(mBackgroundImage);

        mBackgroundLowerView = new View(context);
        mBackgroundLowerView.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, imageHeight));
        mBackgroundLayout.addView(mBackgroundLowerView);

        mListView = new ListView(context);
        mListView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        addView(mListView);
    }
}

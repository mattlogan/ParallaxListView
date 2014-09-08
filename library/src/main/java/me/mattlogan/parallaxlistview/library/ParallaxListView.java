package me.mattlogan.parallaxlistview.library;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;

public class ParallaxListView extends FrameLayout implements AbsListView.OnScrollListener {

    private ScrollView mScrollView;
    private LinearLayout mBackgroundLayout;
    private ImageView mBackgroundHeader;
    private int mHeaderHeight;

    private ListView mListView;
    private View mTransparentHeader;

    private BaseAdapter adapter;

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
        mHeaderHeight = (int) (context.getResources().getDisplayMetrics().heightPixels * 2 / 3f);

        mScrollView = new ScrollView(context);
        mScrollView.setLayoutParams(new LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, mHeaderHeight));
        mScrollView.setVerticalScrollBarEnabled(false);
        addView(mScrollView);

        mBackgroundLayout = new LinearLayout(context);
        mBackgroundLayout.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        mBackgroundLayout.setOrientation(LinearLayout.VERTICAL);
        mScrollView.addView(mBackgroundLayout);

        mBackgroundHeader = new ImageView(context);
        mBackgroundHeader.setLayoutParams(new LinearLayout.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, mHeaderHeight));
        mBackgroundLayout.addView(mBackgroundHeader);

        mListView = new ListView(context);
        mListView.setLayoutParams(new ViewGroup.LayoutParams(
                ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT));
        mListView.setOnScrollListener(this);
        addView(mListView);

        mTransparentHeader = new View(context);
        mTransparentHeader.setBackgroundColor(Color.TRANSPARENT);
        mTransparentHeader.setLayoutParams(new AbsListView.LayoutParams(
                AbsListView.LayoutParams.MATCH_PARENT, mHeaderHeight));
    }

    public void setAdapter(BaseAdapter adapter) {
        this.adapter = adapter;
        mListView.setAdapter(new ActualAdapter());
    }

    public void setBackgroundHeaderDrawable(Drawable drawable) {
        mBackgroundHeader.setImageDrawable(drawable);
    }

    @Override public void onScrollStateChanged(AbsListView absListView, int i) {
    }

    @Override public void onScroll(AbsListView absListView, int firstVisibleItem,
                                   int visibleItemCount, int totalItemCount) {

        View firstChild = absListView.getChildAt(0);
        if (firstChild != null && firstChild == mTransparentHeader) {
            int scrollY = -absListView.getChildAt(0).getTop();
            if (mScrollView.getScrollY() != scrollY) {
                mScrollView.scrollTo(0, (int) (scrollY / 2f));

                ViewGroup.LayoutParams lp = mScrollView.getLayoutParams();
                lp.height = mHeaderHeight - scrollY;
                mScrollView.setLayoutParams(lp);
            }
        }
    }

    private class ActualAdapter extends BaseAdapter {

        @Override public int getCount() {
            return adapter.getCount() + 1;
        }

        @Override public Object getItem(int pos) {
            return pos == 0 ? null : adapter.getItem(pos - 1);
        }

        @Override public long getItemId(int pos) {
            return pos == 0 ? 0 : adapter.getItemId(pos - 1);
        }

        @Override public View getView(int pos, View view, ViewGroup viewGroup) {
            if (pos == 0) {
                return mTransparentHeader;
            }

            if (view == mTransparentHeader) {
                view = null;
            }

            return adapter.getView(pos - 1, view, viewGroup);
        }
    }
}

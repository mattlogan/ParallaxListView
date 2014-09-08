package me.mattlogan.parallaxlistview;

import android.content.Context;
import android.graphics.Color;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import me.mattlogan.parallaxlistview.library.ParallaxListView;

public class MainActivity extends ActionBarActivity {

    private static String[] sSongList = new String[] {
            "Mozart's House", "Extraordinary", "Dust Clears", "Rather Be", "A+E", "Come Over",
            "Cologne", "Telephone Banking", "Up Again", "Heart On Fire", "New Eyes", "Birch",
            "Outro Movement III", "Rihanna", "UK Shanty", "Nightingale"
    };

    private ParallaxListView mParallaxListView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mParallaxListView = (ParallaxListView) findViewById(R.id.parallax_listview);
        mParallaxListView.setAdapter(new ListAdapter());

        mParallaxListView.setBackgroundHeaderDrawable(
                getResources().getDrawable(R.drawable.clean_bandit));
    }

    private static class ViewHolder {
        private TextView textView;
    }

    private class ListAdapter extends BaseAdapter {

        @Override public int getCount() {
            return sSongList.length;
        }

        @Override public Object getItem(int i) {
            return sSongList[i];
        }

        @Override public long getItemId(int i) {
            return i;
        }

        @Override public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder vh;
            if (view == null) {
                LayoutInflater li = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
                view = li.inflate(R.layout.list_item, viewGroup, false);

                vh = new ViewHolder();
                vh.textView = (TextView) view.findViewById(R.id.list_item_text);
                view.setTag(vh);
            } else {
                vh = (ViewHolder) view.getTag();
            }

            vh.textView.setText(sSongList[i]);

            return view;
        }
    }
}

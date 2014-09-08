package me.mattlogan.parallaxlistview;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;


public class MainActivity extends ActionBarActivity {

    private static String[] sSongList = new String[] {
            "Mozart's House", "Extraordinary", "Dust Clears", "Rather Be", "A+E", "Come Over",
            "Cologne", "Telephone Banking", "Up Again", "Heart On Fire", "New Eyes", "Birch",
            "Outro Movement III", "Rihanna", "UK Shanty", "Nightingale"
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    private class ListAdapter extends BaseAdapter {

        @Override public int getCount() {
            return sSongList.length;
        }

        @Override public Object getItem(int i) {
            return sSongList[i];
        }

        @Override public long getItemId(int i) {
            return 0;
        }

        @Override public View getView(int i, View view, ViewGroup viewGroup) {
            return null;
        }
    }
}

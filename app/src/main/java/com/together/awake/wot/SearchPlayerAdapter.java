package com.together.awake.wot;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Void on 02.03.2015.
 */
public class SearchPlayerAdapter extends BaseAdapter {

    private ArrayList<String> mPlayers;
    private LayoutInflater mInflater;
    private ArrayList<String> mId;

    public SearchPlayerAdapter(Context context, ArrayList<String> players, ArrayList<String> id) {
        mPlayers = players;
        mId = id;
        mInflater = LayoutInflater.from(context);

    }

    @Override
    public int getCount() {
        return mPlayers.size();
    }

    @Override
    public Object getItem(int position) {
        return mPlayers.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup vg) {
        if(view == null){
            view = mInflater.inflate(R.layout.list_items, vg, false);
        }

        TextView nameText = (TextView) view.findViewById(R.id.nameText);
        TextView idText = (TextView) view.findViewById(R.id.player_id);

        nameText.setText(mPlayers.get(position));
        idText.setText(mId.get(position));
        return view;
    }
}

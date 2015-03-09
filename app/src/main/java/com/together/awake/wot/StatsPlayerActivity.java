package com.together.awake.wot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.together.awake.wotliblary.Api;
import com.together.awake.wotliblary.OnInfoGetListener;
import com.together.awake.wotliblary.StatsContainer;

/**
 * Created by Void on 03.03.2015.
 */
public class StatsPlayerActivity extends Activity implements OnInfoGetListener {

    Api myApi;

    private TextView player_name_view;
    private TextView battles_view;
    private TextView frags_view;
    private TextView hits_view;
    private TextView exp_view;
    private TextView wins_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stats);

        Intent i = getIntent();
        String id = i.getStringExtra("infaId");
        String name = i.getStringExtra("infaName");

        Log.d("ZjzaaaHZ", id);
        Log.d("ZjzaaaHZ", name);

        player_name_view = (TextView) findViewById(R.id.name_player);
        battles_view = (TextView) findViewById(R.id.num_games_view);
        wins_view = (TextView) findViewById(R.id.wins_view);
        frags_view = (TextView) findViewById(R.id.frags_view);
        hits_view = (TextView) findViewById(R.id.hits_view);
        exp_view = (TextView) findViewById(R.id.battle_exp_view);

        player_name_view.setText(name);

        myApi = new Api(getApplicationContext());
        myApi.getInfoPlayer(id);
        myApi.setOnInfoGetListener(this);

    }

    @Override
    public void onGetInfo(StatsContainer container) {

        battles_view.setText(container.getNum_games());
        wins_view.setText(container.getWins());
        frags_view.setText(container.getFrags());
        hits_view.setText(container.getHits_percents());
        exp_view.setText(container.getBattle_avg_xp());
        Log.d("infaaaaa", container.getNum_games());

    }
}

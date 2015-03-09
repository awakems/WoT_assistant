package com.together.awake.wot;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.together.awake.wotliblary.Api;
import com.together.awake.wotliblary.OnPlayerSearchListener;
import com.together.awake.wotliblary.StatsContainer;

import org.json.JSONArray;


/**
 * Created by Void on 01.03.2015.
 */
public class MainActivity extends Activity implements OnPlayerSearchListener{

    private EditText mEditText;
    private ListView mListView;
    private Api mApi;
    private Api izi;
    private SearchPlayerAdapter mAdapter;
    private JSONAdapter adapter;
    private String arrAdapter;
    StatsContainer player;
    TextView tv;
    TextView tv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        mEditText = (EditText) findViewById(R.id.nameEdit);
        mListView = (ListView) findViewById(R.id.nameList);

        mApi = new Api(getApplicationContext());
        mApi.setOnPlayerChangeListener(this);


        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                tv = (TextView) view.findViewById(R.id.player_id);
                tv2 = (TextView) view.findViewById(R.id.nameText);
                String id_number = tv.getText().toString();
                String name_player = tv2.getText().toString();

                Intent intent = new Intent(MainActivity.this, StatsPlayerActivity.class);
                intent.putExtra("infaId", id_number);
                intent.putExtra("infaName", name_player);

                Toast toast = Toast.makeText(getApplicationContext(),
                        id_number  , Toast.LENGTH_SHORT);
                toast.show();
                startActivity(intent);




            }
        });




    }
    public void search (View view){
        mApi.searchPlayer(mEditText.getText().toString());
    }

    @Override
    public void onPlayerSearch(JSONArray jarray ) {
      //  mAdapter = new SearchPlayerAdapter(getApplicationContext(), players, id);
        adapter = new JSONAdapter(MainActivity.this, jarray);
        mListView.setAdapter(adapter);
    }




}

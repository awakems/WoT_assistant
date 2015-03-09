package com.together.awake.wotliblary;

import android.content.Context;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;


/**
 * Created by Void on 01.03.2015.
 */
public class Api {

    private RequestQueue mQueue;
    private RequestQueue mQueue2;
    private OnPlayerSearchListener mListener;
    private OnInfoGetListener mListenerGet;


    public static final String SEARCH_URL = "http://api.worldoftanks.ru/2.0/account/list/?application_id=171745d21f7f98fd8878771da1000a31&search=";
    public static final String SEARCH_URL_INFO = "http://api.worldoftanks.ru/2.0/account/info/?application_id=171745d21f7f98fd8878771da1000a31&fields=statistics&account_id=";

    public Api(Context context) {
        mQueue = Volley.newRequestQueue(context);
    }

    public void searchPlayer (String name){

        JsonObjectRequest getRequest = new JsonObjectRequest(Request.Method.GET, SEARCH_URL + name, null,
                new Response.Listener<JSONObject>()
                {
                    @Override
                    public void onResponse(JSONObject response) {

                        ArrayList<String> players = new ArrayList<String>();
                        ArrayList<String> ids = new ArrayList<String>();

                        try {
                            JSONArray data = response.getJSONArray("data");
//                          battles  for (int i = 0; i < data.length(); i++) {
//                                JSONObject c = data.getJSONObject(i);
//                                String nick = c.getString("nickname");
//                                String id = c.getString("id");
//                                players.add(nick);
//                                ids.add(id);
//                            }
                            mListener.onPlayerSearch(data);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener()
                {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error.Response", error.getMessage());
                    }
                }
        );

        mQueue.add(getRequest);
    }

    public void getInfoPlayer(String ID){


        final String IDs = ID;

        JsonObjectRequest getInfo = new JsonObjectRequest(Request.Method.GET, SEARCH_URL_INFO + ID, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {

                        StatsContainer container = new StatsContainer();

                        try {
                            JSONObject infoObj = response.getJSONObject("data");

                            String battles = infoObj.getJSONObject(IDs).getJSONObject("statistics").getJSONObject("all").getString("battles");
                            String wins = infoObj.getJSONObject(IDs).getJSONObject("statistics").getJSONObject("all").getString("wins");
                            String frags = infoObj.getJSONObject(IDs).getJSONObject("statistics").getJSONObject("all").getString("frags");
                            String hits_percents = infoObj.getJSONObject(IDs).getJSONObject("statistics").getJSONObject("all").getString("hits_percents");
                            String battle_avg_xp = infoObj.getJSONObject(IDs).getJSONObject("statistics").getJSONObject("all").getString("battle_avg_xp");

                            container.setNum_games(battles);
                            container.setWins(wins);
                            container.setFrags(frags);
                            container.setHits_percents(hits_percents);
                            container.setBattle_avg_xp(battle_avg_xp);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                        mListenerGet.onGetInfo(container);

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                Log.d("Error.Response", volleyError.getMessage());
            }
        });
        mQueue.add(getInfo);

    }

    public void setOnPlayerChangeListener(OnPlayerSearchListener listener){
        mListener = listener;
    }

    public void setOnInfoGetListener (OnInfoGetListener listener){
        mListenerGet = listener;
    }




}

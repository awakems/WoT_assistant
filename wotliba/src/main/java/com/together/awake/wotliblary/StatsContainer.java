package com.together.awake.wotliblary;

/**
 * Created by Void on 05.03.2015.
 */
public class StatsContainer {
    private String num_games;
    private String wins;
    private String frags;
    private String hits_percents;
    private String battle_avg_xp;

    public StatsContainer() {
    }


    public StatsContainer(String num_games, String wins, String frags, String hits_percents, String battle_avg_xp) {
        this.num_games = num_games;
        this.wins = wins;
        this.frags = frags;
        this.hits_percents = hits_percents;
        this.battle_avg_xp = battle_avg_xp;
    }

    public void setNum_games(String num_games) {
        this.num_games = num_games;
    }

    public void setWins(String wins) {
        this.wins = wins;
    }

    public void setFrags(String frags) {
        this.frags = frags;
    }

    public void setHits_percents(String hits_percents) {
        this.hits_percents = hits_percents;
    }

    public void setBattle_avg_xp(String battle_avg_xp) {
        this.battle_avg_xp = battle_avg_xp;
    }

    public String getNum_games() {
        return num_games;
    }

    public String getWins() {
        return wins;
    }

    public String getFrags() {
        return frags;
    }

    public String getHits_percents() {
        return hits_percents;
    }

    public String getBattle_avg_xp() {
        return battle_avg_xp;
    }
}

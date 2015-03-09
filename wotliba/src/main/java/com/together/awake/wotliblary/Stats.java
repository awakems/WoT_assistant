package com.together.awake.wotliblary;

import java.util.HashMap;

/**
 * Created by Void on 06.03.2015.
 */
public class Stats {
    public class Statistics {
        public All all;
    }

    public class All {
        public String spotted;
        public String avg_damage_assisted_track;
        public String avg_damage_blocked;
        public String direct_hits_received;
        public String explosion_hits;
        public String piercings_received;
        public String piercings;
        public String xp;
        public String survived_battles;
        public String dropped_capture_points;
        public String hits_percents;
        public String draws;
        public String battles;
        public String damage_received;
        public String avg_damage_assisted;
        public String frags;
        public String avg_damage_assisted_radio;
        public String capture_points;
        public String base_xp;
        public String hits;
        public String battle_avg_xp;
        public String wins;
        public String losses;
        public String damage_dealt;
        public String no_damage_direct_hits_received;
        public String shots;
        public String explosion_hits_received;
        public String tanking_factor;

        public String getSpotted() {
            return spotted;
        }

        public String getAvg_damage_assisted_track() {
            return avg_damage_assisted_track;
        }

        public String getAvg_damage_blocked() {
            return avg_damage_blocked;
        }

        public String getDirect_hits_received() {
            return direct_hits_received;
        }

        public String getExplosion_hits() {
            return explosion_hits;
        }

        public String getPiercings_received() {
            return piercings_received;
        }

        public String getPiercings() {
            return piercings;
        }

        public String getXp() {
            return xp;
        }

        public String getSurvived_battles() {
            return survived_battles;
        }

        public String getDropped_capture_points() {
            return dropped_capture_points;
        }

        public String getHits_percents() {
            return hits_percents;
        }

        public String getDraws() {
            return draws;
        }

        public String getBattles() {
            return battles;
        }

        public String getDamage_received() {
            return damage_received;
        }

        public String getAvg_damage_assisted() {
            return avg_damage_assisted;
        }

        public String getFrags() {
            return frags;
        }

        public String getAvg_damage_assisted_radio() {
            return avg_damage_assisted_radio;
        }

        public String getCapture_points() {
            return capture_points;
        }

        public String getBase_xp() {
            return base_xp;
        }

        public String getHits() {
            return hits;
        }
    }

    public HashMap<String, String> data;
}


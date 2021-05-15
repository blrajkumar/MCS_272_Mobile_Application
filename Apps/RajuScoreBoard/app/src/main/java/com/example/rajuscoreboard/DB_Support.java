package com.example.rajuscoreboard;

import java.util.ArrayList;

public class DB_Support {
    public static  String mtchName="";

    public static  String plrName="";

    public static int score=0;

    public static ArrayList<String> players = new ArrayList<String>();

    public static ArrayList<String> getPlayers() {
        return players;
    }

    public static void addplayers(String player) {
        if (!DB_Support.players.contains(player)) {
            DB_Support.players.add(player);
        }
    }

    public static void delplayers(String player) {
        if (DB_Support.players.contains(player)) {
            DB_Support.players.remove(player);
        }
    }

    public static String getMtchName() {
        return mtchName;
    }

    public static void setMtchName(String mtchName) {
        DB_Support.mtchName = mtchName;
    }

    public static String getPlrName() {
        return plrName;
    }

    public static void setPlrName(String plrName) {
        DB_Support.plrName = plrName;
    }

    public static int getScore() {
        return score;
    }

    public static void setScore(int score) {
        DB_Support.score = score;
    }
}
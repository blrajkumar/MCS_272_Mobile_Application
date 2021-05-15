package com.example.vroomcarshare;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class DB_Support
{

    public static String sname;
    public static String sid;
    public static String score;


    public static String[] questions = new String[10];
    public static Map<Integer,ArrayList<String>> answers = new HashMap<>();

    public static String getSname() {
        return sname;
    }
    public static void setSname(String sname) {
        DB_Support.sname = sname;
    }

    public static String getSid() {
        return sid;
    }
    public static void setSid(String sid) {
        DB_Support.sid = sid;
    }

}

package com.quintus.labs.addremovelist;

import java.util.ArrayList;

public class FreshCo {

    public static ArrayList<String> agent_names = new ArrayList<String>();

    public static ArrayList<String> cart_items = new ArrayList<String>();

    public static ArrayList<String> getCart_items() {
        return cart_items;
    }

    public static void setCart_items(ArrayList<String> cart_items) {
        FreshCo.cart_items = cart_items;
    }


    public static ArrayList<String> getAgent_names() {
        return agent_names;
    }

    public static void addAgent_name(String agent_name) {
        if(!FreshCo.agent_names.contains(agent_name))
        {
            FreshCo.agent_names.add(agent_name);
        }
    }

    public static void delAgent_name(String agent_name) {
        if(FreshCo.agent_names.contains(agent_name))
        {
            FreshCo.agent_names.remove(agent_name);
        }
    }
}

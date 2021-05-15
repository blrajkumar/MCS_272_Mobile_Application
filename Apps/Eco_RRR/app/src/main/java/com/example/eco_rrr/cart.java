package com.example.eco_rrr;

import java.util.ArrayList;
import java.util.HashMap;

public class cart
{
    static int total=0;
    static HashMap<Integer, ArrayList<String>> cart_details=new HashMap<Integer,ArrayList<String>>();
    static int item_count =1;
    public static void insert(Integer a, ArrayList<String> b)
    {
        cart_details.put(a,b);
    }
}

package com.example.android.recyclerview;

import java.util.ArrayList;

public class FoodCart
{
    public static ArrayList<Integer> fooditems = new ArrayList<Integer>();
    public FoodCart()
    {

    }

    public static void addFoodItems(int n)
    {
        if(!fooditems.contains(n))
        {
            fooditems.add(n);
        }

    }
}

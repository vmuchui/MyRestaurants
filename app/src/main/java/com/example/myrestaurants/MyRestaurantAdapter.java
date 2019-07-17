package com.example.myrestaurants;

import android.content.Context;
import android.widget.ArrayAdapter;

public class MyRestaurantAdapter extends ArrayAdapter {

    private Context mContext;
    private String[] mRestaurants;
    private String[] mCuisines;

    public MyRestaurantAdapter(Context context, int resource, String[] restaurants, String[] cuisines) {
        super(context,resource);
        this.mContext = context;
        this.mCuisines = cuisines;
        this.mRestaurants = restaurants;
    }

    @Override
    public Object getItem(int position) {
        String restaurant = mRestaurants[position];
        String cuisine = mCuisines[position];

        return String.format("%s \nServes great: %s", restaurant,cuisine);
    }

    @Override
    public int getCount() {
        return mRestaurants.length;
    }
}

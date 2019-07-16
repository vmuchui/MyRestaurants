package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class RestaurantsActivity extends AppCompatActivity {
    private TextView mLocationTextView;

    private ListView mListView;
    private String[] restaurants = new String[] {"Free tacos","Starbucks","Five Star","Ortiz","Baguettes to the face","Panini","Wine tappers","Meek Steak","Fugo Gaucho","Kenchic inn","Mi Mero Mole", "Mother's Bistro",
            "Life of Pie", "Screen Door", "Luc Lac", "Sweet Basil",
            "Slappy Cakes", "Equinox", "Miss Delta's", "Andina",
            "Lardo", "Portland City Grill", "Fat Head's Brewery",
            "Chipotle", "Subway"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        mLocationTextView = findViewById(R.id.locationTextView);
        mListView = findViewById(R.id.listView);

        ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this,restaurant,Toast.LENGTH_LONG).show();
            }
        });

        Typeface ostrichFont = Typeface.createFromAsset(getAssets(),"fonts/OstrichSans-Bold.otf");
        mLocationTextView.setTypeface(ostrichFont);

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");
        String view = "Here are all the restaurants near: " + location;
        mLocationTextView.setText(view);
    }
}

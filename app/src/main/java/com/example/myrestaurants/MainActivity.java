package com.example.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {


    public static final String TAG = MainActivity.class.getSimpleName();
    private EditText mLocationEditText;
    private Button mFindRestaurantsButton;
    private TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mAppNameTextView = findViewById(R.id.appNameTextView);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(),"fonts/OstrichSans-Heavy.otf");
        mAppNameTextView.setTypeface(ostrichFont);
        mLocationEditText = findViewById(R.id.locationEditText);
        mFindRestaurantsButton = findViewById(R.id.findRestaurantsButton);

        mFindRestaurantsButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String location = mLocationEditText.getText().toString();
                Toast.makeText(MainActivity.this,"Checking restaurants near " + location, Toast.LENGTH_LONG).show();
                Intent intent =new Intent(MainActivity.this,RestaurantsActivity.class);
                intent.putExtra("location",location);
                startActivity(intent);
            }
        });
    }
}

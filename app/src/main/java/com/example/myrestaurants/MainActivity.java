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

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{


    public static final String TAG = MainActivity.class.getSimpleName();
    @BindView
   (R.id.locationEditText) EditText mLocationEditText;
    @BindView(R.id.findRestaurantsButton) Button mFindRestaurantsButton;
    @BindView(R.id.appNameTextView) TextView mAppNameTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
        Typeface ostrichFont = Typeface.createFromAsset(getAssets(),"fonts/Niconne-Regular.ttf");
        mAppNameTextView.setTypeface(ostrichFont);

        mFindRestaurantsButton.setOnClickListener(this);
    }
    @Override
    public void onClick(View view) {

        if (view== mFindRestaurantsButton){
            String location = mLocationEditText.getText().toString();
            Toast.makeText(MainActivity.this,"Checking restaurants near " + location, Toast.LENGTH_LONG).show();
            Intent intent =new Intent(MainActivity.this,RestaurantsActivity.class);
            intent.putExtra("location",location);
            startActivity(intent);
        }


    }
}

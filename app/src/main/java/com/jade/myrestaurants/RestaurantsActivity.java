package com.jade.myrestaurants;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RestaurantsActivity extends AppCompatActivity {
    @BindView(R.id.locationTextView) TextView mLocationTextView;
    @BindView(R.id.listView) ListView mListView;
    private String[] restaurants = new String[] {"Brews Bistro", "Casablanca", "Java", "Pizza Inn", "Mama Oliech", "Kibandaski", "Pronto", "Villa Rosa",
                                                 "Apewe", "Hilton", "Serena", "Exodus", "Weston", "Kwa Akothee", "A & L", "Ivy's Place", "Subway", "Taco Bell"};
    private String[] cuisines = new String[] {"Nyama Choma", "Omena", "Coffee", "Pizza", "Fish", "Mlima", "Pilau", "Mboga",
                                              "Apoth", "Chapo", "Ugali", "Tea", "Madondo", "Chicken", "Chips", "Biryani", "Kebab", "Taco"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_restaurants);
        ButterKnife.bind(this);

        MyRestaurantsArrayAdapter adapter = new MyRestaurantsArrayAdapter(this, android.R.layout.simple_list_item_1, restaurants, cuisines);
        mListView.setAdapter(adapter);

        mListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                String restaurant = ((TextView)view).getText().toString();
                Toast.makeText(RestaurantsActivity.this, restaurant, Toast.LENGTH_LONG).show();
            }
        });

        Intent intent = getIntent();
        String location = intent.getStringExtra("location");

        mLocationTextView.setText("Here are all the restaurants near: " + location);
    }
}

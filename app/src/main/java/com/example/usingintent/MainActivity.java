package com.example.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize SharedPreferences
        SharedPreferences sharedPreferences = getSharedPreferences("MyPrefs", MODE_PRIVATE);
        int launchCount = sharedPreferences.getInt("launchCount", 0);

        // Increment the count
        launchCount++;

        // Store the updated count
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putInt("launchCount", launchCount);
        editor.apply();

        // Display the count
        TextView countTextView = findViewById(R.id.textView2); // Replace with your TextView ID
        countTextView.setText("Count: " + launchCount);


    }

    public void onClick(View view) {
        startActivity(new Intent("com.username.usingintent.SecondActivity"));
    }

}
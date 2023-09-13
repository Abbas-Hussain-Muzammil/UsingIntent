package com.example.usingintent;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private int launchCount = 0;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Launch the SecondActivity when a button is clicked
        findViewById(R.id.buttonGoToSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });
    }

    private void updateCountTextView() {
        TextView countTextView = findViewById(R.id.textView2); // Replace with your TextView ID
        System.out.print(launchCount);
        countTextView.setText("Count: " + launchCount);
    }


    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        // Save the count to the instance state bundle
        outState.putInt("launchCount", launchCount);
    }

    @Override
    protected void onResume() {
        super.onResume();

        // Increment the count when the main activity is resumed
        launchCount++;

        // Update and display the count
        updateCountTextView();
    }

}
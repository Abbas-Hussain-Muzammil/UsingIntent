# UsingIntent

Learnings:

We can establish communication between activities through intent.

What is an Activity?
The whole screen of our Mobile

The prebuilt Activity in every other Mobile is known as MainActivity.java which is a java class file.

Steps

1. Go to New Project
    - Select Empty Views
    - Give the name to your app -
    - Select build grail type as groovy( you can other as well but groovy is recommended) -
    - Your App is created and Run it to check whether it is working or not.
2. Design your app in activity_main.xml as per the requirement ( Having two textViews, one with name MainActivity, second with name Count: )
3. Create a SecondActivity.java (class file) under  app > java > your_project name
4. Similar to MainActivity create an onCreate method for SecondActivity.
5. Also, design your SecondActivity.java file by creating a new XML file as activity_second.xml under app > res > layout (right-click and select XML and name it and hit OK)
6. Under app > Manifests > AndroidManifests.xml specify the SecondActivity using
   ```
   <activity android:name=".SecondActivity"
            android:exported="true">
            <intent-filter >
                <action android:name="com.example.YOUR_APP_NAME.SecondActivity" />
                <category android:name="android.intent.category.DEFAULT" />
            </intent-filter>
        </activity>
   ```
8. Now establish the connection between the two created activities using intent
9. In MainActivity.java file define a setOnClickListener() method when a button in activity_main.xml is tapped which then launches secondActivity,

    ```

           // Launch the SecondActivity when a button is clicked
        findViewById(R.id.buttonGoToSecond).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this, SecondActivity.class));
            }
        });

    ```
10. Similarly in SecondActivity.java,

    ```

          // Add a button to go back to the MainActivity
        findViewById(R.id.buttonGoBack).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finish();
            }

        });
    
    ```

11.  The following code increases the count in the activity_main.xml text view (Count) whenever it is viewed
```

    
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
```
    

Almost done...

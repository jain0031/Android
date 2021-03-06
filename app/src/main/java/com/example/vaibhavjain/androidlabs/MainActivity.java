package com.example.vaibhavjain.androidlabs;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(ACTIVITY_NAME,"IN onCreate(): ");
        Button button2 = (Button)findViewById(R.id.button);
        Button button4 = (Button)findViewById(R.id.weather);
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivity.this,
                        WeatherForecast.class);
                startActivityForResult(secondIntent, 50);
            }
        });

        Button toolbarBtn = (Button) findViewById(R.id.testtoolbarbtn);
        toolbarBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent4 = new Intent(MainActivity.this,TestToolbar.class);
                startActivityForResult(intent4,50);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent secondIntent = new Intent(MainActivity.this,
                        ListitemsActivity.class);
                startActivityForResult(secondIntent, 50);
            }
        });


        Button buttonChat = (Button) findViewById(R.id.button2);
        buttonChat.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.i(ACTIVITY_NAME, "User clicked Start Chat");
                Intent intent = new Intent(MainActivity.this, ChatWindow.class);
                startActivity(intent);
            }
        });
    }

    public void onActivityResult( int requestCode, int resultCode, Intent data)
    {

if ( requestCode == 50  && resultCode== Activity.RESULT_OK){
            String messagePassed = data.getStringExtra("Response");
            Toast toast = Toast.makeText(MainActivity.this , messagePassed,Toast.LENGTH_LONG); //this is the ListActivity
            toast.show(); //display your message box


        }
    }

    @Override
    public void onResume()
    {
        super.onResume();
        Log.i(ACTIVITY_NAME, "in onResume() : ");

    }
    @Override
    public void onStart()
    {
        super.onStart();
        Log.i(ACTIVITY_NAME, "In onStart() : ");


    }

    @Override
    public void onPause()
    {
        super.onPause();
        Log.i(ACTIVITY_NAME, "In onPause() : ");


    }
    @Override
    public void onStop()
    {
        super.onStop();
        Log.i(ACTIVITY_NAME, " onStop() : ");


    }
    @Override
    public void onDestroy()
    {
        super.onDestroy();
        Log.i(ACTIVITY_NAME, " onDestroy() : ");


    }
}



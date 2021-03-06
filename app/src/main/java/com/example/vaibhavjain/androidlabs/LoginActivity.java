package com.example.vaibhavjain.androidlabs;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class LoginActivity extends Activity {
    protected static final String ACTIVITY_NAME = "StartActivity";
    private static final String usrname="file";
    private static final String loginname="LoginName";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Log.i(ACTIVITY_NAME,"IN onCreate(): ");
        SharedPreferences prefs = getSharedPreferences(usrname, Context.MODE_PRIVATE);
        final SharedPreferences.Editor edit = prefs.edit(); //edit the file
        final EditText textField = (EditText)findViewById(R.id.editText);
        textField.setText(prefs.getString(loginname,"email@domain.com"));

        Button button1 = (Button)findViewById(R.id.Login);

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              edit.putString(loginname,textField.getText().toString());
                edit.commit();
                Intent secondIntent = new Intent(LoginActivity.this,
                        MainActivity.class);
//                secondIntent.putExtra("UserInput", textField.getText().toString());
                startActivityForResult(secondIntent, 275);



            }
        });
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

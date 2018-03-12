package com.blagh.asus.blagh;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.Toast;

public class BalaghActivity4 extends AppCompatActivity {
    SharedPreferences sherd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balagh4);

        sherd = getSharedPreferences("file", Context.MODE_PRIVATE);
        String val = sherd.getString("Transport", "empty");
        String val1 = sherd.getString("Ligne", "empty");
        String val2 = sherd.getString("Station", "empty");
        Toast.makeText(getApplicationContext(), val+"//"+val1+"//"+val2, Toast.LENGTH_LONG).show();



    }
}

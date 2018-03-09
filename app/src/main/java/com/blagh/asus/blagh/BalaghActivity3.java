package com.blagh.asus.blagh;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class BalaghActivity3 extends AppCompatActivity {


    SharedPreferences sherd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balagh3);
        sherd = getSharedPreferences("file", Context.MODE_PRIVATE);

        String val=sherd.getString("declare","empty");
        String val2= sherd.getString("sexe","empty");
        String val3= sherd.getString("Age","empty");
        String val4=sherd.getString("Gouvernorat","empty");
        String val5=sherd.getString("Violence","empty");
        String val6=sherd.getString("Description","empty");
        Toast.makeText(getApplicationContext(),val+"//"+val2+"//"+val3+"//"+val4+"//"+val5+"//"+val6,Toast.LENGTH_LONG).show();
    }

}

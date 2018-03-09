package com.blagh.asus.blagh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BalaghActivity extends AppCompatActivity {

    SharedPreferences sherd;
    SharedPreferences.Editor editor;
    boolean err = false,checked=false,checkedd=false;
    Intent ite;
    RadioGroup sexe;
    Spinner spinner;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balagh);

        spinner = (Spinner) findViewById(R.id.spinner);
        sexe=(RadioGroup)findViewById(R.id.sexe);
        sherd = getSharedPreferences("file", Context.MODE_PRIVATE);
        editor = sherd.edit();
        String restoredsexe = sherd.getString("sexe", null);

        if (restoredsexe != null) {
            String sex = sherd.getString("sexe", "");
            sexe.check(R.id.rd_vict);
        }
        final List<String> spinerarray = new ArrayList<String>();
        spinerarray.add("Chisir Votre Age ");
        spinerarray.add("10-15 ans");
        spinerarray.add("16-20 ans");
        spinerarray.add("21-25 ans");
        spinerarray.add("26-30 ans");
        spinerarray.add("31-35 ans");
        spinerarray.add("36-40 ans");
        spinerarray.add("41-45 ans");
        spinerarray.add("46-50 ans");
        spinerarray.add("51-60 ans");
        spinerarray.add("61 et plus ans");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinerarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor.putString("Age",spinerarray.get(i));
                editor.commit();
            }
            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinner.setSelection(1);

            }
        });
    }
    public void declareur(View view) {
         checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rd_vict:
                if (checked){
                    editor.putString("declare", "victime");
                    editor.commit();
                    err=true;
                }
                break;
            case R.id.rd_temo:
                if (checked){
                    editor.putString("declare", "Témoin");
                    editor.commit();
                    err=true;
                }
                break;
        }
    }
    public void Sexe(View view) {

        checkedd = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.homme:
                if (checkedd){

                    editor.putString("sexe","Homme");
                    editor.apply();
                    err=true;
                }
                break;
            case R.id.famme:
                if (checkedd){
                    editor.putString("sexe","Femme");
                    editor.apply();
                    err=true;
                }
                break;
        }

    }

    public void suivant(View view) {
        if(spinner.getSelectedItemPosition()==0){

            err=true;
        }else{
            err=false;
        }

        if(err==false && checked==true && checkedd==true){
             ite = new Intent(BalaghActivity.this, BalaghActivity2.class);
            startActivity(ite);
        }else{
            Toast.makeText(getApplicationContext(),"Remplir Votre Formulaire",Toast.LENGTH_LONG).show();

        }


    }

    public void accueil(View view) {
         ite = new Intent(BalaghActivity.this, AcueilActivity.class);
        startActivity(ite);

    }

    public void contacts(View view) {
        ite = new Intent(BalaghActivity.this, ContactActivity.class);
        startActivity(ite);
    }

    public void exite(View view) {
         ite = new Intent(Intent.ACTION_MAIN);
        ite.addCategory(Intent.CATEGORY_HOME);
        startActivity(ite);
    }



}

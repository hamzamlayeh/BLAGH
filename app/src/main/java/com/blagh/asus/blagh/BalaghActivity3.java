package com.blagh.asus.blagh;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BalaghActivity3 extends AppCompatActivity {
    SharedPreferences.Editor editor;
    SharedPreferences sherd;
    Intent ite;
    RadioGroup rd1;
    LinearLayout lbus, lmetro, ltrain, ltgm, lautre;
    Spinner sp_tgm;
    EditText ligne, lieu;
    boolean checked = false, chekbus = false, chekmetro = false, chektrain = false;
    boolean chekb = false, chekm = false, chekt = false;
    String value_b, value_m, value_t;
    String[] TGM;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balagh3);

        TGM = getResources().getStringArray(R.array.TGM);
        sherd = getSharedPreferences("file", Context.MODE_PRIVATE);
        editor = sherd.edit();
        rd1 = (RadioGroup) findViewById(R.id.transport);
        lbus = (LinearLayout) findViewById(R.id.linearbus);
        lmetro = (LinearLayout) findViewById(R.id.linearmetro);
        ltrain = (LinearLayout) findViewById(R.id.lineartrain);
        ltgm = (LinearLayout) findViewById(R.id.lineartgm);
        lautre = (LinearLayout) findViewById(R.id.linearautre);
        ligne = (EditText) findViewById(R.id.ligne);
        lieu = (EditText) findViewById(R.id.lieu);
        sp_tgm = (Spinner) findViewById(R.id.sp_tgm);

        String val = sherd.getString("declare", "empty");
        String val2 = sherd.getString("sexe", "empty");
        String val3 = sherd.getString("Age", "empty");
        String val4 = sherd.getString("Gouvernorat", "empty");
        String val5 = sherd.getString("Violence", "empty");
        String val6 = sherd.getString("Description", "empty");
        Toast.makeText(getApplicationContext(), val + "//" + val2 + "//" + val3 + "//" + val4 + "//" + val5 + "//" + val6, Toast.LENGTH_LONG).show();

        final List<String> spinerarray = new ArrayList<String>();
        spinerarray.add("Choisir Station...");
        for (int i = 0; i < TGM.length; i++) {
            spinerarray.add(TGM[i]);
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinerarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        sp_tgm.setAdapter(adapter);
        sp_tgm.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor.putString("Station", spinerarray.get(i));
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                sp_tgm.setSelection(1);

            }
        });
        rd1.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {
                switch (i) {
                    case R.id.rd_bus:
                        checked = true;
                        lbus.setVisibility(lbus.VISIBLE);
                        ltrain.setVisibility(ltrain.INVISIBLE);
                        lmetro.setVisibility(lmetro.INVISIBLE);
                        chekbus = true;
                        chektrain = false;
                        chekmetro = false;
                        ltgm.setVisibility(ltgm.INVISIBLE);
                        lautre.setVisibility(lautre.INVISIBLE);
                        break;
                    case R.id.rd_metro:
                        checked = true;
                        lmetro.setVisibility(lmetro.VISIBLE);
                        lbus.setVisibility(lbus.INVISIBLE);
                        ltrain.setVisibility(ltrain.INVISIBLE);
                        chekmetro = true;
                        chekbus = false;
                        chektrain = false;
                        ltgm.setVisibility(ltgm.INVISIBLE);
                        lautre.setVisibility(lautre.INVISIBLE);
                        break;
                    case R.id.rd_train:
                        checked = true;
                        ltrain.setVisibility(ltrain.VISIBLE);
                        lmetro.setVisibility(lmetro.INVISIBLE);
                        lbus.setVisibility(lbus.INVISIBLE);
                        chektrain = true;
                        chekmetro = false;
                        chekbus = false;
                        break;
                }
            }
        });
    }

    public void func_bus(View view) {
        chekb = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_b1:
                value_b = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_b2:
                value_b = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_b3:
                value_b = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_b4:
                value_b = ((RadioButton) view).getText().toString();
                break;
        }
    }
    public void func_metro(View view) {
        chekm = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_m1:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m2:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m3:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m4:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m5:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m6:
                value_m = ((RadioButton) view).getText().toString();
                break;
            case R.id.rd_m7:
                value_m = ((RadioButton) view).getText().toString();
                break;
        }
    }

    public void func_train(View view) {
        chekt = ((RadioButton) view).isChecked();

        switch (view.getId()) {
            case R.id.rd_tgm:
                value_t = ((RadioButton) view).getText().toString();
                ltgm.setVisibility(ltgm.VISIBLE);
                lautre.setVisibility(lautre.INVISIBLE);
                break;
            case R.id.rd_at:
                value_t = ((RadioButton) view).getText().toString();
                ltgm.setVisibility(ltgm.INVISIBLE);
                lautre.setVisibility(lautre.VISIBLE);
                break;
        }
    }

    public void precedant(View view) {
        ite = new Intent(this, BalaghActivity2.class);
        startActivity(ite);
    }

    public void suivant(View view) {
        if (checked) {
            if (chekbus == true) {
                editor.putString("Transport", "BUS");
                editor.apply();
                if (chekb) {
                    editor.putString("Ligne", value_b);
                    editor.apply();
                } else {
                    Toast.makeText(getApplicationContext(), "Remplir Votre Ligne", Toast.LENGTH_LONG).show();
                }
            } else if (chekmetro == true) {
                editor.putString("Transport", "Metro legere");
                editor.apply();
                if (chekm) {
                    editor.putString("Ligne", value_m);
                    editor.apply();
                } else {
                    Toast.makeText(getApplicationContext(), "Remplir Votre Ligne", Toast.LENGTH_LONG).show();
                }
            } else if (chektrain == true) {
                editor.putString("Transport", "Train");
                editor.apply();
                if (chekt) {
                    if (value_t.equals("TGM")) {
                        editor.putString("Ligne", value_t);
                        editor.apply();
                        if (sp_tgm.getSelectedItemPosition() == 0) {
                            Toast.makeText(getApplicationContext(), "Choisire  Votre Station", Toast.LENGTH_LONG).show();
                        } else {
                            Toast.makeText(getApplicationContext(), "b1111", Toast.LENGTH_LONG).show();
//                            ite = new Intent(this, BalaghActivity4.class);
//                            startActivity(ite);
                        }
                    } else if (value_t.equals("Autre")) {
                        if (valider()) {
                            editor.putString("Ligne", ligne.getText().toString());
                            editor.putString("Station", lieu.getText().toString());
                            editor.commit();
                            Toast.makeText(getApplicationContext(), "b1111", Toast.LENGTH_LONG).show();
//                            ite = new Intent(this, BalaghActivity4.class);
//                            startActivity(ite);
                        }
                    }
                } else {
                    Toast.makeText(getApplicationContext(), "Remplir Votre Ligne", Toast.LENGTH_LONG).show();
                }
            }

        } else {
            Toast.makeText(getApplicationContext(), "Remplir Votre Formulaire", Toast.LENGTH_LONG).show();

        }
    }

    private boolean valider() {
        boolean valide = true;
        if (ligne.getText().toString().isEmpty()) {
            ligne.setError("Remplir Votre Ligne");
            valide = false;
        }
        if (lieu.getText().toString().isEmpty()) {
            lieu.setError("Remplir Votre Lieu");
            valide = false;
        }
        return valide;
    }

}
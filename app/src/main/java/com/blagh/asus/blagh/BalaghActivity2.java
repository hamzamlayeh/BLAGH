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
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class BalaghActivity2 extends AppCompatActivity {

    SharedPreferences sherd;
    SharedPreferences.Editor editor;
    Spinner spinner;
    EditText description;
    String desc;
    Intent ite;
    boolean err = false,checked=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_balagh2);

        sherd = getSharedPreferences("file", Context.MODE_PRIVATE);
        editor = sherd.edit();
        String val=sherd.getString("declare","empty");
        String val2= sherd.getString("sexe","empty");
        String val3= sherd.getString("Age","empty");
        Toast.makeText(getApplicationContext(),val+"//"+val2+"//"+val3,Toast.LENGTH_LONG).show();

        spinner = (Spinner) findViewById(R.id.spinner);
        description=(EditText)findViewById(R.id.description);

        String restoredesc = sherd.getString("description", null);

        if (restoredesc != null) {
            String dsc = sherd.getString("description", "");
            description.setText(dsc);

        }
        final List<String> spinerarray = new ArrayList<String>();
        spinerarray.add("Chisir Votre Gouvernorat ");
        spinerarray.add("Grand Tunis");
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, spinerarray);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

                editor.putString("Gouvernorat",spinerarray.get(i));
                editor.commit();
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {
                spinner.setSelection(1);

            }
        });

    }
    public void violence(View view) {
         checked = ((RadioButton) view).isChecked();

        switch(view.getId()) {
            case R.id.rd_vv:
                if (checked){
                    editor.putString("Violence", "violence verbale");
                    editor.commit();

                }
                break;
            case R.id.rd_vps:
                if (checked){
                    editor.putString("Violence", "violence psychologique");
                    editor.commit();

                }
                break;
            case R.id.rd_vph:
                if (checked){
                    editor.putString("Violence", "violence physique");
                    editor.commit();

                }
                break;
            case R.id.rd_vs:
                if (checked){
                    editor.putString("Violence", "Violence Sexuelle");
                    editor.commit();

                }
                break;
        }
    }

    public void suivant(View view) {
        desc=description.getText().toString().trim();

        if(valider()){
          editor.putString("Description", desc);
          editor.commit();
          err=false;
      }

        if(spinner.getSelectedItemPosition()==0){

            err=true;
        }else{
            err=false;
        }
        if(err==false && checked==true &&valider()==true){
             ite = new Intent(this, BalaghActivity3.class);
            startActivity(ite);
        }else{
            Toast.makeText(getApplicationContext(),"Remplir Votre Formulaire",Toast.LENGTH_LONG).show();

        }
    }
    private boolean valider() {
        boolean valide = true;
        if(desc.isEmpty()) {
            description.setError("Remplir Votre Description");
            valide = false;
        }
        return valide;
    }

    public void precedant(View view) {
        ite = new Intent(this, BalaghActivity.class);
        startActivity(ite);
    }
    public void accueil(View view) {
        ite = new Intent(BalaghActivity2.this, AcueilActivity.class);
        startActivity(ite);

    }

    public void contacts(View view) {
        ite = new Intent(BalaghActivity2.this, ContactActivity.class);
        startActivity(ite);
    }

    public void exite(View view) {
        ite = new Intent(Intent.ACTION_MAIN);
        ite.addCategory(Intent.CATEGORY_HOME);
        startActivity(ite);
    }


}

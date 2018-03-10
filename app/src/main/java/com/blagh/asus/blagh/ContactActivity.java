package com.blagh.asus.blagh;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;

import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class ContactActivity extends AppCompatActivity {

    final private int requestcodeR=123;
    EditText message, nom, sujet, email;
    String name, msg, suj,mail;
    Intent ite;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact);

        nom = (EditText) findViewById(R.id.nom);
        email = (EditText) findViewById(R.id.email);
        sujet = (EditText) findViewById(R.id.sujet);
        message =(EditText) findViewById(R.id.message);
    }
    public void Envoyer(View view) {
        name = nom.getText().toString().trim();
        mail = email.getText().toString().trim();
        msg = message.getText().toString().trim();
        suj = sujet.getText().toString().trim();
        if (!valider()) {
            Toast.makeText(getApplicationContext(), "Verifier Tout les champs", Toast.LENGTH_LONG).show();
        } else {

            Toast.makeText(getApplicationContext(), "Envoyer avec Succer", Toast.LENGTH_LONG).show();
            sendEmail();
        }
        }

    @SuppressLint("LongLogTag")
    protected void sendEmail() {
        Log.i("Send email", "");

        String[] TO = {"khaledhizawi@gmail.com"};
        String[] CC = {mail};
        Intent emailIntent = new Intent(Intent.ACTION_SEND);
        emailIntent.setData(Uri.parse("mailto:"));
        emailIntent.setType("text/plain");


        emailIntent.putExtra(Intent.EXTRA_EMAIL, TO);
        emailIntent.putExtra(Intent.EXTRA_CC, CC);
        emailIntent.putExtra(Intent.EXTRA_SUBJECT, suj);
        emailIntent.putExtra(Intent.EXTRA_TEXT, "Nom="+name+"\n"+msg);

        try {
            startActivity(Intent.createChooser(emailIntent, "Send mail..."));
            finish();
            Log.i("Finished sending email...", "");
        } catch (android.content.ActivityNotFoundException ex) {
            Toast.makeText(this,
                    "There is no email client installed.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean valider() {
        boolean valide = true;
        if (name.isEmpty() || name.length() > 25) {
            nom.setError(getString(R.string.v_nom));
            valide = false;
        }
        if (msg.isEmpty() ) {
            message.setError(getString(R.string.v_message));
            valide = false;
        }
        if (suj.isEmpty() || suj.length() > 25) {
            sujet.setError(getString(R.string.v_sujet));
            valide = false;
        }
        if (mail.isEmpty() || (!android.util.Patterns.EMAIL_ADDRESS.matcher(mail).matches())) {
            email.setError(getString(R.string.v_email));
            valide = false;
        }
        return valide;
    }

    public void accueil(View view) {
         ite = new Intent(ContactActivity.this, AcueilActivity.class);
        startActivity(ite);

    }
    public void balagh(View view) {
         ite = new Intent(ContactActivity.this, BalaghActivity.class);
        startActivity(ite);
    }



    @SuppressLint("NewApi")
    public void appel(View view) {

         ite = new Intent(Intent.ACTION_CALL);
        ite.setData(Uri.parse("tel:80100345"));
        if((int) Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
            if (ActivityCompat.checkSelfPermission(this, Manifest.permission.CALL_PHONE) != PackageManager.PERMISSION_GRANTED) {

                requestPermissions(new String []{Manifest.permission.CALL_PHONE},requestcodeR);
                return ;
            }
            startActivity(ite);
        }}


}

package com.curso.petagram.activity;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;

import com.curso.petagram.R;

public class AgregarMascota extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.agregar_mascota);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    public void volver(View view) {
        //Intent intent = new Intent(AgregarMascota.this, MainActivity.class);
        onBackPressed();
        //startActivity(intent);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {

            case android.R.id.home:

                onBackPressed();
                return true;

            default:
                return super.onOptionsItemSelected(item);

        }


    }

}

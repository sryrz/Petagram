package com.curso.petagram.activity;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.curso.petagram.R;

import java.lang.reflect.Array;

public class FormularioContacto extends AppCompatActivity {

    EditText nombre, email, mensaje;
    Button botonEnviar;
    String[] to = new String[] {"example@example.com"};
    String mensajeString;

    String stringNombre, stringEmail, stringMensaje;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.formulario_contacto);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);


        /*nombre = (EditText) findViewById(R.id.etNombre);
        email = (EditText) findViewById(R.id.etEmail);
        mensaje = (EditText) findViewById(R.id.etMensaje);

        botonEnviar = (Button) findViewById(R.id.btnEnviarForm);

        Toast.makeText(this,    "Nombre: "  + nombre.getText()  +
                                " - Email: "   + email.getText()   +
                                " - Mensaje"   + mensaje.getText() ,
                Toast.LENGTH_SHORT).show();*/

        //FUNCIONA
        //stringNombre = nombre.getText().toString();
        //Toast.makeText(this, "Nombre: " + stringNombre, Toast.LENGTH_SHORT).show();
    }

    public void enviarEmail(View view){
        //Toast.makeText(this, "Nombre: " + stringNombre + ", email: " + email.toString() + ", mensaje: " + mensaje.toString() + ". Para: " + to,
        //        Toast.LENGTH_SHORT).show();

        nombre = (EditText) findViewById(R.id.etNombre);
        email = (EditText) findViewById(R.id.etEmail);
        mensaje = (EditText) findViewById(R.id.etMensaje);

        botonEnviar = (Button) findViewById(R.id.btnEnviarForm);

        Toast.makeText(this,    "Nombre: "       + nombre.getText()  +
                                " - Email: "     + email.getText()   +
                                " - Mensaje"     + mensaje.getText() ,
                                Toast.LENGTH_SHORT).show();

        Intent emailIntent = new Intent(Intent.ACTION_SEND);

        emailIntent.putExtra(Intent.EXTRA_EMAIL, to);
        emailIntent.putExtra(Intent.EXTRA_TEXT, nombre.getText() + " (" + email.getText() + ")\nMensaje: " + mensaje.getText());
        //emailIntent.setData(Uri.parse("mailto:"));
        //emailIntent.putExtra(Intent.EXTRA_EMAIL, to);

        emailIntent.setType("message/rfc822");
        startActivity(Intent.createChooser(emailIntent, "Email "));
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

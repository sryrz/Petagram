package com.curso.petagram.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.curso.petagram.R;
import com.curso.petagram.adapter.FavoritoAdaptador;
import com.curso.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MascotasFavoritas extends AppCompatActivity {

    ArrayList<Mascota> mascotasFavoritas;
    ArrayList<Mascota> auxFavoritas;
    ArrayList<Mascota> subFavoritas;
    private RecyclerView listaFavoritas;

    private static final int MASCOTAS_FAVORITAS = 1;

    int i,j,totalMascotas;

    Intent intent;

    Bundle extras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mascotas_favoritas);

        Toolbar actionBar = (Toolbar) findViewById(R.id.miActionBar);
        setSupportActionBar(actionBar);

        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        intent = getIntent();
        extras = intent.getExtras();
        mascotasFavoritas = new ArrayList<Mascota>();

        /*Intent intent = getIntent();


        mascotasFavoritas = (ArrayList<Mascota>)intent.getParcelableExtra("mascotasFavoritas");
        mascotas = (ArrayList<Mascota>)intent.getParcelableExtra("mascotas");*/


        listaFavoritas = (RecyclerView)findViewById(R.id.rvFavoritas);
        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);

        listaFavoritas.setLayoutManager(llm);

        recuperarListaFavoritas();
        inicializarAdaptador();

    }

    public void inicializarAdaptador(){
        FavoritoAdaptador adaptador = new FavoritoAdaptador(subFavoritas);
        listaFavoritas.setAdapter(adaptador);
    }

    public void recuperarListaFavoritas(){

        int limite;
        int foto;
        int size = (int)extras.get("size");
        boolean anadir;
        String nombre, favoritos;

        for(int i = 0; i < size; i++){

            foto = intent.getIntExtra("mascotasFoto" + String.valueOf(i),0);
            nombre = (String)extras.get("mascotasNombre" + String.valueOf(i));
            favoritos = (String)extras.get("mascotasFavorito" + String.valueOf(i));

            mascotasFavoritas.add(new Mascota(foto, R.drawable.bone, nombre, favoritos, R.drawable.filled_bone));

        }

        auxFavoritas = new ArrayList<Mascota>();

        for(i=0;i<=mascotasFavoritas.size()-1;i++){
            anadir=true;
            if(auxFavoritas.size() > 0){

                for(j=auxFavoritas.size()-1;j>=0;j--){
                    if (mascotasFavoritas.get(i).getNombre().equals(auxFavoritas.get(j).getNombre())) {
                        anadir = false;
                        break;
                    }
                }
            }
            if(anadir==true){

                auxFavoritas.add(mascotasFavoritas.get(i));
            }
        }


        if(auxFavoritas.size()>5){
            subFavoritas=new ArrayList<Mascota>(auxFavoritas.subList(0,5));

        }else{
            subFavoritas=auxFavoritas;
        }
    }

    @Override
    public void onBackPressed() {

        int size = mascotasFavoritas.size();
        Intent intentMFavoritas = new Intent(this, MainActivity.class);
        for(int i = size-1; i >= 0; i--){

            intentMFavoritas.putExtra("mascotasFoto" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getFoto());
            intentMFavoritas.putExtra("mascotasNombre" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getNombre());
            intentMFavoritas.putExtra("mascotasFavorito" + String.valueOf(size-1-i), mascotasFavoritas.get(i).getFavoritos());
        }
        intentMFavoritas.putExtra("size", size);
        setResult(RESULT_OK, intentMFavoritas);
        finish();

        super.onBackPressed();
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

package com.curso.petagram.activity;

import android.content.Intent;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.curso.petagram.R;
import com.curso.petagram.adapter.MascotaAdaptador;
import com.curso.petagram.adapter.PageAdapter;
import com.curso.petagram.fragment.PerfilFragment;
import com.curso.petagram.fragment.RecyclerViewFragment;
import com.curso.petagram.pojo.Mascota;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerViewFragment rvf;
    private Toolbar toolbar;
    private TabLayout tabLayout;
    private ViewPager viewPager;

    int i,j;

    Intent intent;


    private static final int MAIN_ACTIVITY = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        supportRequestWindowFeature(getWindow().FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.actionbar);
        setSupportActionBar(toolbar);

        //toolbar = (Toolbar) findViewById(R.id.toolbar);
        tabLayout = (TabLayout) findViewById(R.id.tabLayout);
        viewPager = (ViewPager) findViewById(R.id.viewPager);

        setUpViewPager();

        if(toolbar != null){
            setSupportActionBar(toolbar);
        }

    }

    private ArrayList<Fragment> agregarFragments(){

        ArrayList<Fragment> fragments = new ArrayList<Fragment>();
        rvf = new RecyclerViewFragment();
        fragments.add(rvf);
        fragments.add(new PerfilFragment());

        return fragments;
    }

    private void setUpViewPager(){
        viewPager.setAdapter(new PageAdapter(getSupportFragmentManager(),agregarFragments())); //Añade un adaptador al viewPager

        tabLayout.setupWithViewPager(viewPager); //conecta el tabLayout con el viewPager

        tabLayout.getTabAt(0).setText("MASCOTAS");
        tabLayout.getTabAt(1).setText("PERFIL");
    }

    public void agregarMascota (View view){
        Intent intent = new Intent(MainActivity.this, AgregarMascota.class);
        startActivity(intent);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_opciones, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()){

            case R.id.mFavoritas:
                Intent intentMFavoritas = new Intent(this, MascotasFavoritas.class);
                //FragmentManager fm = getSupportFragmentManager();

                //RecyclerViewFragment fragment = (RecyclerViewFragment)fm.findFragmentByTag("fragment_recycler_view");
                rvf.sendDataToFavorites(intentMFavoritas);




                //Bundle bndlFavs = new Bundle();
                //Bundle bndlMascs = new Bundle();
                //intentMFavoritas.putExtra("mascotasFavoritas", mascotasFavoritas);
                //intentMFavoritas.putExtra("mascotas", mascotas);
                //intentMFavoritas.putExtra("mascotasFavoritas", bndlFavs);
                //intentMFavoritas.putExtra("mascotas", bndlMascs);

                //startActivity(intentMFavoritas);
                startActivityForResult(intentMFavoritas,1);

                break;

            case R.id.mContacto:

                Intent intentContacto = new Intent(this, FormularioContacto.class);
                startActivity(intentContacto);

                break;

            case R.id.mAcerca:

                Intent intentAcerca = new Intent(this, AcercaDe.class);
                startActivity(intentAcerca);

                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        //FragmentManager fm = getSupportFragmentManager();
        //RecyclerViewFragment fragment = (RecyclerViewFragment)fm.findFragmentByTag("fragment_recycler_view");

        if (requestCode == 1){
            if(resultCode == RESULT_OK){



                rvf.receiveDataFromMainActivity(data);
                //recuperarListaFavoritas();
            }
        }
    }
}

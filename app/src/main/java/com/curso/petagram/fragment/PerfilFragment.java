package com.curso.petagram.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.curso.petagram.R;
import com.curso.petagram.adapter.FotoAdaptador;
import com.curso.petagram.pojo.Foto;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilFragment extends Fragment {

    ArrayList<Foto> galeria;

    RecyclerView recyclerViewGrid;

    public PerfilFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil, container, false);

        recyclerViewGrid = (RecyclerView) v.findViewById(R.id.rvPerfilGrid);

        GridLayoutManager glm = new GridLayoutManager(getActivity(),3);
        glm.setOrientation(GridLayoutManager.VERTICAL);

        recyclerViewGrid.setLayoutManager(glm);

        inicializarGrid();
        inicializarAdaptador();

        return v;
    }

    private void inicializarGrid() {
        galeria = new ArrayList<Foto>();

        galeria.add(new Foto(R.drawable.confucio, "2", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "5", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "2", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "1", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "0", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "6", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "11", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "3", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "157", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "1", R.drawable.filled_bone));
        galeria.add(new Foto(R.drawable.confucio, "3", R.drawable.filled_bone));
    }

    private void inicializarAdaptador() {
        FotoAdaptador adaptador = new FotoAdaptador(galeria);
        recyclerViewGrid.setAdapter(adaptador);
    }

}

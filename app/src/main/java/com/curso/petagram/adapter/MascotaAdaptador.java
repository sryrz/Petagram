package com.curso.petagram.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.curso.petagram.pojo.Mascota;
import com.curso.petagram.R;

import java.util.ArrayList;

/**
 * Created by quevivalapauli on 27/12/16.
 */

public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder> {

    private ArrayList<Mascota> mascotas;
    private ArrayList<Mascota> mascotasFavoritas;

    public MascotaAdaptador(ArrayList<Mascota> mascotas, ArrayList<Mascota> mascotasFavoritas) {

        this.mascotas = mascotas;
        this.mascotasFavoritas = mascotasFavoritas;
    }

    /*public MascotaAdaptador(ArrayList<Mascota> mascotasFavoritas, int activity) {

        this.mascotasFavoritas = mascotasFavoritas;
        this.activity = activity;
    }*/

    public static class MascotaViewHolder extends RecyclerView.ViewHolder{

        private ImageView foto;
        private Button bone;
        private TextView nombre;
        private TextView favoritos;
        private ImageView filled;

        public MascotaViewHolder(View itemView) {
            //Asociar cada elemento del XML a su objeto java de vista
            super(itemView);

            foto = (ImageView) itemView.findViewById(R.id.ivMascota);
            bone = (Button) itemView.findViewById(R.id.btnBone);
            nombre = (TextView) itemView.findViewById(R.id.tvNombre);
            favoritos = (TextView) itemView.findViewById(R.id.tvFavoritos);
            filled = (ImageView) itemView.findViewById(R.id.ivFilled);
        }
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        //Asocia el layout de una cardView al adaptador
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascotas,parent,false);
        return new MascotaViewHolder(v);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, final int position) {
        //Manipula cada elemento de la cardView
        final Mascota mascota;

            mascota = mascotas.get(position);

            mascotaViewHolder.bone.setOnClickListener(new View.OnClickListener(){
                public void onClick(View v){
                    int i,j,k;

                    int temp = Integer.parseInt(mascota.getFavoritos());
                    temp = temp + 1;
                    mascota.setFavoritos(String.valueOf(temp));
                    mascotaViewHolder.favoritos.setText(mascota.getFavoritos());

                    //añadimos siempre la siguiente mascota
                    mascotasFavoritas.add(mascota);



                }
            });

        mascotaViewHolder.foto.setImageResource(mascota.getFoto());
        mascotaViewHolder.nombre.setText(mascota.getNombre());
        mascotaViewHolder.favoritos.setText(mascota.getFavoritos());
        mascotaViewHolder.filled.setImageResource(mascota.getFilled());
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }
}

package com.curso.petagram.pojo;

/**
 * Created by quevivalapauli on 9/1/17.
 */

public class Foto {
    private int foto;
    private String favoritos;
    private int filled;

    public Foto(int foto, String favoritos, int filled) {
        this.foto = foto;
        this.favoritos = favoritos;
        this.filled = filled;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getFavoritos() {
        return favoritos;
    }

    public void setFavoritos(String favoritos) {
        this.favoritos = favoritos;
    }

    public int getFilled() {
        return filled;
    }

    public void setFilled(int filled) {
        this.filled = filled;
    }
}

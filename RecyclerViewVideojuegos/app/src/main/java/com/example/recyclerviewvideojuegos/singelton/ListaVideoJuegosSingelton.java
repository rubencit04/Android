package com.example.recyclerviewvideojuegos.singelton;

import android.util.Log;

import com.example.recyclerviewvideojuegos.entidad.VideoJuego;

import java.util.ArrayList;
import java.util.List;

public class ListaVideoJuegosSingelton {
    private static ListaVideoJuegosSingelton instance;
    private List<VideoJuego> listaVideoJuegos;
    private int contador = 1;

    private ListaVideoJuegosSingelton(){
        super();
    }

    public static ListaVideoJuegosSingelton getInstance() {
        if(instance == null){
            instance = new ListaVideoJuegosSingelton();
        }
        return instance;
    }

    public VideoJuego getVideoJuegoById(int id) {
        for (VideoJuego vj : listaVideoJuegos) {
            if (vj.getId() == id) {
                return vj;
            }
        }
        return null;
    }

    public void agregar(VideoJuego videojuego) {
        if (listaVideoJuegos != null) {
            videojuego.setId(contador);
            contador++;
            listaVideoJuegos.add(videojuego);
        }
    }

    public void inicializar(){
        listaVideoJuegos = new ArrayList<>();
        VideoJuego videoJuego = new VideoJuego();
        videoJuego.setId(contador++);
        videoJuego.setNombre("GTAV");
        videoJuego.setFechaCreacion("2013");
        videoJuego.setPuntuacion(9);

        listaVideoJuegos.add(videoJuego);

        videoJuego = new VideoJuego();
        videoJuego.setId(contador++);
        videoJuego.setNombre("Call Of Duty Black Ops 2");
        videoJuego.setFechaCreacion("2012");
        videoJuego.setPuntuacion(9);

        listaVideoJuegos.add(videoJuego);

        videoJuego = new VideoJuego();
        videoJuego.setId(contador++);
        videoJuego.setNombre("FIFA 2016");
        videoJuego.setFechaCreacion("2015");
        videoJuego.setPuntuacion(9);

        listaVideoJuegos.add(videoJuego);

        Log.i("ListaUsuarioSingleton", "########" + listaVideoJuegos);
    }

    public List<VideoJuego> getListaVideoJuegos() {
        return listaVideoJuegos;
    }

    public void borrar(VideoJuego usuario){
        listaVideoJuegos.remove(usuario);
    }
}

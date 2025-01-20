package com.example.recyclerviewvideojuegos.entidad;

public class VideoJuego {
    private int id;
    private String nombre;
    private String fechaCreacion;
    private int puntuacion;

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public String getFechaCreacion() {
        return fechaCreacion;
    }

    public int getPuntuacion() {
        return puntuacion;
    }

    public void setPuntuacion(int puntuacion) {
        this.puntuacion = puntuacion;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void setFechaCreacion(String fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "VideoJuego{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", fechaCreacion='" + fechaCreacion + '\'' +
                ", puntuacion=" + puntuacion +
                '}';
    }
}


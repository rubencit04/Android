package com.example.pizzeria2.modelo.entidad;

import java.util.Objects;

public class Usuario {
    private String nombre;
    private String pass;
    private String direccion;
    private Pizza pizza;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Pizza getPizza() {
        return pizza;
    }

    public void setPizza(Pizza pizza) {
        this.pizza = pizza;
    }

    public Usuario(String nombre, String pass, String direccion) {
        this.nombre = nombre;
        this.pass = pass;
        this.direccion = direccion;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Usuario usuario = (Usuario) o;
        return Objects.equals(nombre, usuario.nombre) && Objects.equals(pass, usuario.pass);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nombre, pass, direccion, pizza);
    }

    @Override
    public String toString() {
        return "Usuario{" +
                "nombre='" + nombre + '\'' +
                ", pass='" + pass + '\'' +
                ", direccion='" + direccion + '\'' +
                ", pizza=" + pizza +
                '}';
    }
}

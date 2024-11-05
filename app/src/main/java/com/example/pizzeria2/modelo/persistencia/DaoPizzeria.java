package com.example.pizzeria2.modelo.persistencia;

import com.example.pizzeria2.modelo.entidad.Usuario;

import java.util.ArrayList;

public class DaoPizzeria {
     ArrayList<Usuario> listaUsuarios = new ArrayList<>();

    public DaoPizzeria() {
        Usuario u1 = new Usuario("Pedro", "1234", "Orense");
        Usuario u2 = new Usuario("Paco", "admin", "Orense");
        Usuario u3 = new Usuario("Yo", "1234", "Orense");
        listaUsuarios.add(u1);
        listaUsuarios.add(u3);
        listaUsuarios.add(u3);

    }

    public Usuario verificarUsuario(String nombre) {
        for (Usuario u : listaUsuarios) {
            if (u.getNombre().equals(nombre)) {
                return u;
            }
        }
        return null;
    }
}



package com.example.pizzeria2.modelo.negocio;

import com.example.pizzeria2.modelo.entidad.Usuario;
import com.example.pizzeria2.modelo.persistencia.DaoPizzeria;

public class GestorUsuario {
    private DaoPizzeria dp;


    public int validar(Usuario u) {
        dp = new DaoPizzeria();
        try {
            Usuario uFichero = dp.verificarUsuario(u.getNombre());
            if (uFichero == null) {
                return 0;
            }
            if (uFichero.equals(u)) {
                return 1;
            } else {
                return 2;
            }
        } catch (Exception e) {
            return 666;
        }
    }


}

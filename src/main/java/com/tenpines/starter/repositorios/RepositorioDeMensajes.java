package com.tenpines.starter.repositorios;

import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class RepositorioDeMensajes {
    private List<String> mensajes;

    RepositorioDeMensajes(){
        mensajes = new ArrayList<String>();
    }

    public List<String> encontrarTodos() {
        return mensajes;
    }

    public void agregar(String mensaje) {
        mensajes.add(mensaje);
    }
}

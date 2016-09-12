package com.tenpines.starter.servicios;

import com.tenpines.starter.modelo.Mensaje;
import com.tenpines.starter.repositorios.RepositorioDeMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioDeMensajes {
    @Autowired
    private RepositorioDeMensajes repo;

    public void almacenar(String mensaje) {
        repo.save(new Mensaje(mensaje));
    }

    public List<Mensaje> buscarTodos() {
        return repo.findAll();
    }
}

package com.tenpines.starter.repositorios;

import com.tenpines.starter.modelo.Mensaje;
import org.springframework.data.repository.CrudRepository;
import org.springframework.transaction.annotation.Transactional;

@Transactional
public interface RepositorioDeMensajes extends CrudRepository<Mensaje, Long> {

}

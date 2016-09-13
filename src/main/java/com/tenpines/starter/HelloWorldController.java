package com.tenpines.starter;

import com.tenpines.starter.modelo.Mensaje;
import com.tenpines.starter.rest.AgregarRequest;
import com.tenpines.starter.servicios.ServicioDeMensajes;
import com.tenpines.starter.web.Endpoints;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
public class HelloWorldController {
    private ServicioDeMensajes servicio;

    @Autowired
    public HelloWorldController(ServicioDeMensajes servicioDeMensajes) {
        this.servicio = servicioDeMensajes;
    }

    @RequestMapping(Endpoints.HOME)
    String home(Model model) {
        model.addAttribute("mensajes", obtener());
        return "hola";
    }

    @RequestMapping(value = Endpoints.AGREGAR_MENSAJE, method = RequestMethod.POST)
    @ResponseBody
    String agregar(@RequestBody AgregarRequest mensaje){
        servicio.almacenar(mensaje.getMensaje());
        return "Exito!";
    }

    @RequestMapping(value = Endpoints.OBTENER_MENSAJES, method = RequestMethod.GET, produces = "application/json")
    @ResponseBody
    List<Mensaje> obtener(){
        return servicio.buscarTodos();
    }
}

package com.tenpines.starter;

import com.tenpines.starter.repositorios.RepositorioDeMensajes;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class HelloWorldController {
    @Autowired
    private RepositorioDeMensajes repo;

    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("mensajes", repo.encontrarTodos());
        return "hola";
    }

    @RequestMapping(value = "/", method = RequestMethod.GET, params = "mensaje")
    @ResponseBody
    String agregar(@RequestParam String mensaje){
        repo.agregar(mensaje);
        return "Exito!";
    }
}

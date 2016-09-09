package com.tenpines.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Arrays;

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("mensajes", Arrays.asList("Holitas!", "chauchis", "lala"));
        return "hola";
    }
}

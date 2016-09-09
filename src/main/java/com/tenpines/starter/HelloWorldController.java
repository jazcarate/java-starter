package com.tenpines.starter;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HelloWorldController {
    @RequestMapping("/")
    String home(Model model) {
        model.addAttribute("mensaje", "Holitas!");
        return "hola";
    }
}

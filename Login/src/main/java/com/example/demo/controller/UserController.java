package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {
    @GetMapping("/")
    private String web_principal(){
        return "web/login";
    }
    @GetMapping("/nosotros")
    public String nosotros() {
        return "cliente/nosotros";
    }
//    @GetMapping("/productos")
//    public String productos() {
//        return "cliente/productos";
//    }
}

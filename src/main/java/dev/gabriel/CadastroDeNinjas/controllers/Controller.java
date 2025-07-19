package dev.gabriel.CadastroDeNinjas.controllers;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Controller {

    @GetMapping("/mensage")
    public String myFirstMensage(){

        return "Minha Primeira Mensagem";
    }
}

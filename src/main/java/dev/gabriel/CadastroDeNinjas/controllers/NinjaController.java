package dev.gabriel.CadastroDeNinjas.controllers;


import dev.gabriel.CadastroDeNinjas.models.NinjaModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/mensage")
    public String myFirstMensage(){

        return "Minha Primeira Mensagem";
    }
}

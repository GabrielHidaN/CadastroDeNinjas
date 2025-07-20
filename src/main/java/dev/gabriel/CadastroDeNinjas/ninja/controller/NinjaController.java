package dev.gabriel.CadastroDeNinjas.ninja.controller;



import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class NinjaController {

    @GetMapping("/ninja")
    public String myFirstMensage(){

        return "Minha Primeira Mensagem";
    }
}

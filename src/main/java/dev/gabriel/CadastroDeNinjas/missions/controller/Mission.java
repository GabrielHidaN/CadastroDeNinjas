package dev.gabriel.CadastroDeNinjas.missions.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
public class Mission {
    @GetMapping("/mission")
    public String missionController(){
        return "Controller mission";

    }
}

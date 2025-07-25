package dev.gabriel.CadastroDeNinjas.ninja.controller;

import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import dev.gabriel.CadastroDeNinjas.ninja.service.NinjaService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    // Create Ninja (CREATE)
    @PostMapping("/create")
    public  String createNinja(){
        return "Ninja Created";
    }


    // Show Ninja by Id (READ)
    @GetMapping("/{id}")
    public NinjaModel showNinjaById(@PathVariable Long id){
        return ninjaService.showNinjaById(id);
    }



    // Show all Ninjas (READ)
    @GetMapping("/all")
    public List<NinjaModel> showAllNinjas(){
        return ninjaService.showAllNinjas();
    }


    // Update Ninja by Id (READ)
    @PutMapping("/update")
    public String ninjaUpdate(){
        return "Ninja Updated";
    }

    //Delete Ninja by Id (READ)
    @DeleteMapping("/delete")
    public String ninjaDelete(){
        return "Ninja Deleted";
    }
}

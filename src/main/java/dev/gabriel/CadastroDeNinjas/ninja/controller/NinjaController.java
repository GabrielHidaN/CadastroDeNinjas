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
    public NinjaModel createNinja(@RequestBody NinjaModel ninjaModel){
        return ninjaService.createNinja(ninjaModel);
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
    @PutMapping("/update/{id}")
    public NinjaModel ninjaUpdate (@PathVariable Long id , @RequestBody NinjaModel ninjaUpdate){
        return ninjaService.updateNinja(id , ninjaUpdate);
    }

    //Delete Ninja by Id (READ)
    @DeleteMapping("/delete/{id}")
    public void deleteNinja (@PathVariable Long id){
        ninjaService.deleteNinja(id);
    }
}

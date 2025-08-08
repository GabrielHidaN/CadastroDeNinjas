package dev.gabriel.CadastroDeNinjas.ninja.controller;
import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
import dev.gabriel.CadastroDeNinjas.ninja.service.NinjaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/ninjas")
public class NinjaController {

    private final NinjaService ninjaService;

    public NinjaController(NinjaService ninjaService) {
        this.ninjaService = ninjaService;
    }

    @PostMapping("/create")
    public ResponseEntity<String> createNinja(@RequestBody NinjaDTO ninja){

        NinjaDTO newNinja =ninjaService.createNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Created successfully. - ID:" +newNinja.getId() +
                        " Name : " + newNinja.getName());
    }




    @GetMapping("/{id}")
    public ResponseEntity<?> showNinjaById(@PathVariable Long id){
        NinjaDTO ninjaById = ninjaService.showNinjaById(id);
        if (ninjaById != null){
            return ResponseEntity.ok(ninjaById);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }





    @GetMapping("/all")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas(){

        List<NinjaDTO> allNinjas = ninjaService.showAllNinjas();

        return ResponseEntity.ok(allNinjas);
    }




    @PutMapping("/update/{id}")
    public ResponseEntity<?> ninjaUpdate (@PathVariable Long id , @RequestBody NinjaDTO ninjaUpdate){

        NinjaDTO ninja = ninjaService.updateNinja(id , ninjaUpdate);

        if (ninja != null){
            return ResponseEntity.ok(ninja);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> deleteNinja (@PathVariable Long id){

        NinjaDTO ninja = ninjaService.showNinjaById(id);

        if(ninja != null){
            String ninjaName = ninja.getName();
            ninjaService.deleteNinja(id);
            return ResponseEntity.ok("Ninja Deleted successfully. - ID:" + id +
                    " Name: " +ninjaName);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }

    }
}

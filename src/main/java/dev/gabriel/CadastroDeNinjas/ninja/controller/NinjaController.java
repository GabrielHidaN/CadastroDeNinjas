package dev.gabriel.CadastroDeNinjas.ninja.controller;
import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
import dev.gabriel.CadastroDeNinjas.ninja.service.NinjaService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
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
    @Operation(summary = "Creates a new ninja" ,
            description = "Route creates a new ninja and inserts into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Ninja created"),
            @ApiResponse(responseCode = "400" ,
                    description = "Ninja Creation Error")
    })
    public ResponseEntity<String> createNinja(
            @Parameter(description = "User sends the mission data to be updated in the body of the request")
            @RequestBody NinjaDTO ninja){

        NinjaDTO newNinja =ninjaService.createNinja(ninja);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Ninja Created successfully. - ID:" +newNinja.getId() +
                        " Name : " + newNinja.getName());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Show Ninja By Id" ,
            description = "Route show a ninja by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja found"),
            @ApiResponse(responseCode = "404" ,
                    description = "Ninja Not found")
    })
    public ResponseEntity<?> showNinjaById(
            @Parameter(description = "The user provides the ID along the path of the route")
            @PathVariable Long id){

        NinjaDTO ninjaById = ninjaService.showNinjaById(id);
        if (ninjaById != null){
            return ResponseEntity.ok(ninjaById);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }


    @GetMapping("/all")
    @Operation(summary = "Show all Ninjas" ,
            description = "Route show all ninjas")
    public ResponseEntity<List<NinjaDTO>> showAllNinjas(){

        List<NinjaDTO> allNinjas = ninjaService.showAllNinjas();

        return ResponseEntity.ok(allNinjas);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update the Ninja" ,
            description = "Route updates a ninja and inserts changes in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja updated"),
            @ApiResponse(responseCode = "404" ,
                    description = "Ninja error not found, it was not possible to make the changes")
    })
    public ResponseEntity<?> ninjaUpdate (
            @Parameter(description = "The user provides the ninja ID who wants to update along the path of the route")
            @PathVariable Long id ,
            @Parameter(description = "User sends the ninja data to be updated in the body of the request")
            @RequestBody NinjaDTO ninjaUpdate){

        NinjaDTO ninja = ninjaService.updateNinja(id , ninjaUpdate);

        if (ninja != null){
            return ResponseEntity.ok(ninja);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete the Ninja" ,
            description = "Route excludes a ninja and removes in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Ninja updated"),
            @ApiResponse(responseCode = "404",
                    description = "Ninja error not found")
    })
    public ResponseEntity<String> deleteNinja (
            @Parameter(description = "The user provides the ID along the path of the route")
            @PathVariable Long id){

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

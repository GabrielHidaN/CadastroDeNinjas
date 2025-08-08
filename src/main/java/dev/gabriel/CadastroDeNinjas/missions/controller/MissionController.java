package dev.gabriel.CadastroDeNinjas.missions.controller;
import dev.gabriel.CadastroDeNinjas.missions.dto.MissionDTO;
import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.service.MissionService;
import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }



    @PostMapping("/create")
    @Operation(summary = "Creates a new mission" ,
            description = "Route creates a new mission and inserts into the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201",
                    description = "Mission created"),
            @ApiResponse(responseCode = "400" ,
                    description = "Mission Creation Error")
    })
    public ResponseEntity<String> createMission(
            @Parameter(description = "User sends the ninja data to be updated in the body of the request")
            @RequestBody MissionDTO mission){

        MissionDTO newMission = missionService.createMission(mission);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission Created successfully. - ID:" +newMission.getId() +
                        " Name : " + newMission.getName() +
                        " Difficulty : " +newMission.getDifficulty());
    }


    @GetMapping("/{id}")
    @Operation(summary = "Show Mission By Id" ,
            description = "Route show a mission by id")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission found"),
            @ApiResponse(responseCode = "404" ,
                    description = "Mission Not found")
    })
    public ResponseEntity<?> showMissionById(
            @Parameter(description = "The user provides the ID along the path of the route")
            @PathVariable Long id){

        MissionDTO missionById = missionService.showMissionById(id);
        if (missionById != null){
            return ResponseEntity.ok(missionById);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID:" + id +  " not found.");
        }
    }


    @GetMapping("/all")
    @Operation(summary = "Show all Missions" ,
            description = "Route show all missions")
    public ResponseEntity<List<MissionDTO>> showAllMissions(){
        List<MissionDTO> allMissions =  missionService.showAllMissions();

        return ResponseEntity.ok(allMissions);
    }


    @PutMapping("/update/{id}")
    @Operation(summary = "Update the Mission" ,
            description = "Route updates a mission and inserts changes in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission updated"),
            @ApiResponse(responseCode = "404" ,
                    description = "Mission error not found, it was not possible to make the changes")
    })
    public ResponseEntity<?> updateMission(
            @Parameter(description = "The user provides the ninja ID who wants to update along the path of the route")
            @PathVariable Long id ,
            @Parameter(description = "User sends the ninja data to be updated in the body of the request")
            @RequestBody MissionDTO mission){

        MissionDTO missionUpdate = missionService.updateMission(id , mission);

        if (missionUpdate != null){
            return ResponseEntity.ok(missionUpdate);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }


    @DeleteMapping("/delete/{id}")
    @Operation(summary = "Delete the Mission" ,
            description = "Route excludes a mission and removes in the database")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200",
                    description = "Mission updated"),
            @ApiResponse(responseCode = "404",
                    description = "Mission error not found")
    })
    public ResponseEntity<String> missionDelete(
            @Parameter(description = "The user provides the ID along the path of the route")
            @PathVariable  Long id){

        MissionDTO mission = missionService.showMissionById(id);

        if (mission != null){
            String missionName = mission.getName();
            missionService.deleteMission(id);

            return ResponseEntity.ok("Mission Deleted successfully. - ID: " + id +
                    " Name: " + missionName);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID:" + id +  " not found.");
        }
    }
}

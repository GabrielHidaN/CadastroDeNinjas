package dev.gabriel.CadastroDeNinjas.missions.controller;
import dev.gabriel.CadastroDeNinjas.missions.dto.MissionDTO;
import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.service.MissionService;
import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
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
    public ResponseEntity<String> createMission(@RequestBody MissionDTO mission){

        MissionDTO newMission = missionService.createMission(mission);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body("Mission Created successfully. - ID:" +newMission.getId() +
                        " Name : " + newMission.getName() +
                        " Difficulty : " +newMission.getDifficulty());
    }




    @GetMapping("/{id}")
    public ResponseEntity<?> showMissionById(@PathVariable Long id){

        MissionDTO missionById = missionService.showMissionById(id);
        if (missionById != null){
            return ResponseEntity.ok(missionById);
        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Mission with ID:" + id +  " not found.");
        }
    }



    // Show all Missions (READ)
    @GetMapping("/all")
    public ResponseEntity<List<MissionDTO>> showAllMissions(){
        List<MissionDTO> allMissions =  missionService.showAllMissions();

        return ResponseEntity.ok(allMissions);
    }



    @PutMapping("/update/{id}")
    public ResponseEntity<?> updateMission(@PathVariable Long id , @RequestBody MissionDTO mission){

        MissionDTO missionUpdate = missionService.updateMission(id , mission);

        if (missionUpdate != null){
            return ResponseEntity.ok(missionUpdate);

        }else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Ninja with ID:" + id +  " not found.");
        }
    }



    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> missionDelete(@PathVariable  Long id){

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

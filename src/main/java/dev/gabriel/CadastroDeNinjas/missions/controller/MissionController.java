package dev.gabriel.CadastroDeNinjas.missions.controller;
import dev.gabriel.CadastroDeNinjas.missions.dto.MissionDTO;
import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.service.MissionService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/mission")
public class MissionController {

    private final MissionService missionService;

    public MissionController(MissionService missionService) {
        this.missionService = missionService;
    }

    // Create Mission (CREATE)
    @PostMapping("/create")
    public MissionDTO createMission(@RequestBody MissionDTO mission){
        return missionService.createMission(mission);
    }


    // Show Missions by Id (READ)
    @GetMapping("/{id}")
    public MissionDTO showMissionById(@PathVariable Long id){
        return missionService.showMissionById(id);
    }

    // Show all Missions (READ)
    @GetMapping("/all")
    public List<MissionDTO> showAllMissions(){
        return missionService.showAllMissions();
    }


    // Update Mission by Id (UPDATE)
    @PutMapping("/update/{id}")
    public MissionDTO updateMission(@PathVariable Long id , @RequestBody MissionDTO mission){
        return missionService.updateMission(id, mission);
    }

    //Delete Mission by Id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void missionDelete(@PathVariable  Long id){
        missionService.deleteMission(id);
    }
        

}

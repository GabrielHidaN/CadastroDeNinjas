package dev.gabriel.CadastroDeNinjas.missions.controller;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.service.MissionService;
import dev.gabriel.CadastroDeNinjas.ninja.service.NinjaService;
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
    public String createMission(){
        return "Mission Created";
    }


    // Show Missions by Id (READ)
    @GetMapping("/{id}")
    public MissionModel showMissionById(@PathVariable Long id){
        return missionService.showMissionById(id);
    }

    // Show all Missions (READ)
    @GetMapping("/all")
    public List<MissionModel> showAllMissions(){
        return missionService.showAllMissions();
    }


    // Update Mission by Id (READ)
    @PutMapping("/update")
    public String missionUpdate(){
        return "Mission Updated";
    }

    //Delete Mission by Id (READ)
    @DeleteMapping("/delete")
    public String missionDelete(){
        return "Mission Deleted";
    }
        

}

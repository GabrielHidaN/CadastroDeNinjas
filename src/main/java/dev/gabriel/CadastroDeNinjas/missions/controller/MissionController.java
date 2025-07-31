package dev.gabriel.CadastroDeNinjas.missions.controller;
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
    public MissionModel createMission(@RequestBody MissionModel mission){
        return missionService.createMission(mission);
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


    // Update Mission by Id (UPDATE)
    @PutMapping("/update")
    public String missionUpdate(){
        return "Mission Updated";
    }

    //Delete Mission by Id (DELETE)
    @DeleteMapping("/delete/{id}")
    public void missionDelete(@PathVariable  Long id){
        missionService.deleteMission(id);
    }
        

}

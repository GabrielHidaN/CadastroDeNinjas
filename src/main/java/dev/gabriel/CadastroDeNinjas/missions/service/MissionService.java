package dev.gabriel.CadastroDeNinjas.missions.service;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.repository.MissionRepository;
import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MissionService {

    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }


    //show all missions
    public List<MissionModel> showAllMissions(){
        return missionRepository.findAll();
    }

    // show mission by id

    public MissionModel showMissionById(Long id){
        Optional<MissionModel> showMissionById = missionRepository.findById(id);
        return showMissionById.orElse(null);
    }

    // create new mission

    public  MissionModel createMission(MissionModel mission){
        return missionRepository.save(mission);
    }

    // delete mission
    public void deleteMission(Long id){
        missionRepository.deleteById(id);
    }

    // update mission

    public MissionModel updateMission(Long id , MissionModel mission){
        if(missionRepository.existsById(id)){
            mission.setId(id);
            return missionRepository.save(mission);
        }
        return null;
    }

}

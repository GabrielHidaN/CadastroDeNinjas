package dev.gabriel.CadastroDeNinjas.missions.service;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.repository.MissionRepository;
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

    public  MissionModel createMission(MissionModel missionModel){
        return missionRepository.save(missionModel);
    }

}

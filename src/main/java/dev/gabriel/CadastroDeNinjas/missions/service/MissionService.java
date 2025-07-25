package dev.gabriel.CadastroDeNinjas.missions.service;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.repository.MissionRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MissionService {

    private final MissionRepository missionRepository;

    public MissionService(MissionRepository missionRepository) {
        this.missionRepository = missionRepository;
    }

    public List<MissionModel> showAllMissions(){
        return missionRepository.findAll();
    }
}

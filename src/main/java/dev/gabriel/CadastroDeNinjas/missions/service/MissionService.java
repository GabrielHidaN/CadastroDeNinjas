package dev.gabriel.CadastroDeNinjas.missions.service;

import dev.gabriel.CadastroDeNinjas.missions.dto.MissionDTO;
import dev.gabriel.CadastroDeNinjas.missions.mapper.MissionMapper;
import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import dev.gabriel.CadastroDeNinjas.missions.repository.MissionRepository;
import dev.gabriel.CadastroDeNinjas.ninja.mapper.NinjaMapper;
import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MissionService {

    private final MissionRepository missionRepository;
    private final MissionMapper missionMapper;

    public MissionService(MissionRepository missionRepository, MissionMapper missionMapper) {
        this.missionRepository = missionRepository;
        this.missionMapper = missionMapper;
    }

    //show all missions
    public List<MissionDTO> showAllMissions(){
        List<MissionModel> mission = missionRepository.findAll();

        return mission.stream()
                .map(MissionMapper::map)
                .collect(Collectors.toList());
    }

    // show mission by id

    public MissionDTO showMissionById(Long id){
        Optional<MissionModel> showMissionById = missionRepository.findById(id);
        if (showMissionById.isPresent()){
            return showMissionById.map(MissionMapper::map).orElse(null);
        }
        return null;
    }

    // create new mission

    public MissionDTO createMission(MissionDTO missionDTO){

        MissionModel missionModel = missionMapper.map(missionDTO);
        missionModel = missionRepository.save(missionModel);
        return MissionMapper.map(missionModel);
    }

    // delete mission
    public void deleteMission(Long id){
        missionRepository.deleteById(id);
    }

    // update mission

    public MissionDTO updateMission(Long id , MissionDTO missionDTO){
        Optional<MissionModel> missionExist = missionRepository.findById(id);
        if(missionExist.isPresent()){
            MissionModel missionUpdate = missionMapper.map(missionDTO);
            missionUpdate.setId(id);
            MissionModel missionSave = missionRepository.save(missionUpdate);
            return MissionMapper.map(missionSave);
        }
        return null;
    }
}

package dev.gabriel.CadastroDeNinjas.missions.mapper;

import dev.gabriel.CadastroDeNinjas.missions.dto.MissionDTO;
import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import org.springframework.stereotype.Component;


@Component
public class MissionMapper {

    public MissionModel map(MissionDTO missionDTO){
        MissionModel missionModel = new MissionModel();

        missionModel.setId(missionDTO.getId());
        missionModel.setName(missionDTO.getName());
        missionModel.setDifficulty(missionDTO.getDifficulty());
        missionModel.setNinjas(missionDTO.getNinjas());

        return missionModel;
    }

    public  static MissionDTO map(MissionModel missionModel){
        MissionDTO missionDTO = new MissionDTO();

        missionDTO.setId(missionModel.getId());
        missionDTO.setName(missionModel.getName());
        missionDTO.setDifficulty(missionModel.getDifficulty());
        missionDTO.setNinjas(missionModel.getNinjas());

        return missionDTO;
    }


}

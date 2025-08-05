package dev.gabriel.CadastroDeNinjas.ninja.mapper;

import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import org.springframework.stereotype.Component;

@Component
public class NinjaMapper {

    public NinjaModel map(NinjaDTO ninjaDTO){
        NinjaModel ninjaModel = new NinjaModel();

        ninjaModel.setId(ninjaDTO.getId());
        ninjaModel.setName(ninjaDTO.getName());
        ninjaModel.setAge(ninjaDTO.getAge());
        ninjaModel.setEmail(ninjaDTO.getEmail());
        ninjaModel.setRank(ninjaDTO.getRank());
        ninjaModel.setUrl_img(ninjaDTO.getUrl_img());
        ninjaModel.setMissions(ninjaDTO.getMissions());

        return ninjaModel;
    }

    public static NinjaDTO map(NinjaModel ninjaModel){
        NinjaDTO ninjaDTO = new NinjaDTO();

        ninjaDTO.setId(ninjaModel.getId());
        ninjaDTO.setName(ninjaModel.getName());
        ninjaDTO.setAge(ninjaModel.getAge());
        ninjaDTO.setEmail(ninjaModel.getEmail());
        ninjaDTO.setRank(ninjaModel.getRank());
        ninjaDTO.setUrl_img(ninjaModel.getUrl_img());
        ninjaDTO.setMissions(ninjaModel.getMissions());

        return ninjaDTO;
    }

}

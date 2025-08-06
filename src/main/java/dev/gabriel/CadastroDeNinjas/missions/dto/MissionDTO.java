package dev.gabriel.CadastroDeNinjas.missions.dto;

import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MissionDTO {

    Long id;
    private String name;
    private String difficulty;
    private List<NinjaModel> ninjas;
}

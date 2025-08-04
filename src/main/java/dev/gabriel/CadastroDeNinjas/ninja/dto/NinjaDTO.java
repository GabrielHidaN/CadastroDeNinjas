package dev.gabriel.CadastroDeNinjas.ninja.dto;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class NinjaDTO {


    private Long id;
    private String name;
    private Integer age;
    private String email;
    private String rank;
    private String url_img;
    private MissionModel missions;
}

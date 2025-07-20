package dev.gabriel.CadastroDeNinjas.missions.model;

import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import jakarta.persistence.*;
import lombok.Data;

import java.util.List;


@Entity
@Data
@Table(name = "tb_mission")


public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String difficulty;


    // @OneToMany - A mission for many to ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

    public MissionModel() {
    }

    public MissionModel(Long id, String name,  String difficulty) {
        this.id = id;
        this.name = name;
        this.difficulty = difficulty;
    }
}

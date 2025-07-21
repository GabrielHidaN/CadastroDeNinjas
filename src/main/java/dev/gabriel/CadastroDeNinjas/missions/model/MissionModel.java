package dev.gabriel.CadastroDeNinjas.missions.model;

import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
@Table(name = "tb_mission")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    private String name;
    private String difficulty;


    // @OneToMany - A mission for many to ninjas
    @OneToMany(mappedBy = "missions")
    private List<NinjaModel> ninjas;

}

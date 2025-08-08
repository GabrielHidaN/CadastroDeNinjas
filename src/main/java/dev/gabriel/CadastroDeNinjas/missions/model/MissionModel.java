package dev.gabriel.CadastroDeNinjas.missions.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.util.List;


@Entity
@Table(name = "tb_mission")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class MissionModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "difficulty")
    private String difficulty;


    // @OneToMany - A mission for many to ninjas
    @OneToMany(mappedBy = "missions")
    @JsonIgnore
    private List<NinjaModel> ninjas;

}

package dev.gabriel.CadastroDeNinjas.ninja.model;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import jakarta.persistence.*;
import lombok.Data;

// Entity transforma uma classe em uma Entidade no Banco de dados
@Entity
@Data
@Table(name = "tb_cadastro")

public class NinjaModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private int age;
    private String email;


    // @ManyToOne - A ninja for one mission
    @ManyToOne
    @JoinColumn(name = "missions_id") //Forenig Id or (Chave Estrangeira (pt-br))
    private MissionModel missions;

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

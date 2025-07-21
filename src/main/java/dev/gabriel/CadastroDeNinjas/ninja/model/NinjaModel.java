package dev.gabriel.CadastroDeNinjas.ninja.model;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Entity transforma uma classe em uma Entidade no Banco de dados
@Entity
@Table(name = "tb_cadastro")
@Data
@NoArgsConstructor
@AllArgsConstructor
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

}

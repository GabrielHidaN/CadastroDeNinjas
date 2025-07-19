package dev.gabriel.CadastroDeNinjas.models;

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

    public NinjaModel() {
    }

    public NinjaModel(String name, String email, int age) {
        this.name = name;
        this.email = email;
        this.age = age;
    }
}

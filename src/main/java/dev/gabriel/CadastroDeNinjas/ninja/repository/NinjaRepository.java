package dev.gabriel.CadastroDeNinjas.ninja.repository;

import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NinjaRepository extends JpaRepository<NinjaModel , Long> {
}

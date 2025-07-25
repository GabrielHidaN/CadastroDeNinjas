package dev.gabriel.CadastroDeNinjas.missions.repository;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MissionRepository extends JpaRepository<MissionModel , Long> {
}

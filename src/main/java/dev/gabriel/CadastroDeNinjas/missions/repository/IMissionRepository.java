package dev.gabriel.CadastroDeNinjas.missions.repository;

import dev.gabriel.CadastroDeNinjas.missions.model.MissionModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMissionRepository extends JpaRepository<MissionModel , Long> {
}

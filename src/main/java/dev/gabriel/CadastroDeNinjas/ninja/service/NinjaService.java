package dev.gabriel.CadastroDeNinjas.ninja.service;


import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import dev.gabriel.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    public List<NinjaModel> showAllNinjas(){
        return ninjaRepository.findAll();
    }

}

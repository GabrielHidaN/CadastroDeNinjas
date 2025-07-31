package dev.gabriel.CadastroDeNinjas.ninja.service;


import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import dev.gabriel.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;

    public NinjaService(NinjaRepository ninjaRepository) {
        this.ninjaRepository = ninjaRepository;
    }

    // show all ninjas
    public List<NinjaModel> showAllNinjas(){
        return ninjaRepository.findAll();
    }

    // show ninja by id

    public NinjaModel showNinjaById(Long id){
        Optional<NinjaModel> showNinjaById = ninjaRepository.findById(id);
        return  showNinjaById.orElse(null);
    }

    // create new ninja

    public  NinjaModel createNinja(NinjaModel ninja){
        return ninjaRepository.save(ninja);
    }

    // delete ninja

    public void deleteNinja(Long id){
        ninjaRepository.deleteById(id);
    }

}

package dev.gabriel.CadastroDeNinjas.ninja.service;


import dev.gabriel.CadastroDeNinjas.ninja.dto.NinjaDTO;
import dev.gabriel.CadastroDeNinjas.ninja.mapper.NinjaMapper;
import dev.gabriel.CadastroDeNinjas.ninja.model.NinjaModel;
import dev.gabriel.CadastroDeNinjas.ninja.repository.NinjaRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class NinjaService {

    private final NinjaRepository ninjaRepository;
    private final NinjaMapper ninjaMapper;

    public NinjaService(NinjaRepository ninjaRepository, NinjaMapper ninjaMapper) {
        this.ninjaRepository = ninjaRepository;
        this.ninjaMapper = ninjaMapper;
    }

    // show all ninjas
    public List<NinjaDTO> showAllNinjas(){
        List<NinjaModel> ninja = ninjaRepository.findAll();
        return  ninja.stream()
                .map(NinjaMapper::map)
                .collect(Collectors.toList());
    }

    // show ninja by id

    public NinjaDTO showNinjaById(Long id){
        Optional<NinjaModel> showNinjaById = ninjaRepository.findById(id);
        if(showNinjaById.isPresent()){
            return showNinjaById.map(NinjaMapper::map).orElse(null);
        }
        return null;
    }

    // create new ninja

    public NinjaDTO createNinja(NinjaDTO ninjaDTO){
        NinjaModel ninja = ninjaMapper.map(ninjaDTO);
        ninja = ninjaRepository.save(ninja);
        return  NinjaMapper.map(ninja);
    }

    // delete ninja

    public void deleteNinja(Long id){
        ninjaRepository.deleteById(id);
    }

    // update ninja

    public  NinjaDTO updateNinja(Long id , NinjaDTO ninjaDTO){
        Optional<NinjaModel> ninjaExist = ninjaRepository.findById(id);

        if (ninjaExist.isPresent()){
            NinjaModel ninjaUpdate = ninjaMapper.map(ninjaDTO);
            ninjaUpdate.setId(id);
            NinjaModel ninjaSave = ninjaRepository.save(ninjaUpdate);
            return NinjaMapper.map(ninjaSave);
        }
        return null;
    }

}

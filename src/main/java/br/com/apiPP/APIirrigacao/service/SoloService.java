package br.com.apiPP.APIirrigacao.service;

import br.com.apiPP.APIirrigacao.model.Solo;
import java.util.List;
import java.util.Optional;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;

import br.com.apiPP.APIirrigacao.repository.SoloRepository;

@Service
public class SoloService {
    private final Logger log = LoggerFactory.getLogger(SoloService.class);
    
    @Autowired
    SoloRepository soloRepository;

    public Solo save(Solo solo){ 
        solo = soloRepository.save(solo);
        return solo;
    }

    public Optional<Solo> findOne(Long id_solo) {
        log.info("Request to get Solo : {} ", id_solo);
        return soloRepository.findById(id_solo)
    }

    public List<Solo> findAllList(){
        log.info("Request to get All Solos");
        List<Solo> soloList = soloRepository.findAll();
        log.info("Return of getAllList " + soloList.size());
        return soloList;
    }

    public void delete(Long id_solo) {
        log.info("Request to delete id_Solo : {}", id_solo);
        petRepository.deleteById(id_solo);
    }

    public List<Solo> saveAll(Liste<Solo> petList){
        log.info("Request to save Solo : {}", soloList);
        soloList = soloRepository.saveAll(soloList);
        return soloList;
    }

}

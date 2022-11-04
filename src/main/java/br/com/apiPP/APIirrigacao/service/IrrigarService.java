package br.com.apiPP.APIirrigacao.service;

import java.util.List;
import java.util.Optional;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import br.com.apiPP.APIirrigacao.repository.IrrigacaoRepository;
import br.com.apiPP.APIirrigacao.model.Irrigacao;

import br.com.apiPP.APIirrigacao.model.Irrigar;
import br.com.apiPP.APIirrigacao.repository.IrrigarRepository;

@Service
public class IrrigarService {
    private final Logger log = LoggerFactory.getLogger(IrrigarService.class);

    @Autowired 
    IrrigarRepository irrigarRepository;
    IrrigacaoRepository irrigacaoRepository;

    public Irrigar save(Irrigar irrigar){ 
        irrigar = irrigarRepository.save(irrigar);
        return irrigar;
    }

    public Optional<Irrigacao> findOne(long idIrrigacao){
        log.info("Request to get Irrigacao : {} ", idIrrigacao);
        return irrigacaoRepository.findById(idIrrigacao);
    }

    public List<Irrigar> findAllList() {
        log.info("Request to get All Irrigar");
        List<Irrigar> irrigarList = irrigarRepository.findAll();
        log.info("Return of getAllList " + irrigarList.size());
        return irrigarList;
    }

    public void delete(Long idIrrigacao) {
        log.info("Request to delete idIrrigacao : {}", idIrrigacao);
        irrigarRepository.deleteById(idIrrigacao);
    } 
}

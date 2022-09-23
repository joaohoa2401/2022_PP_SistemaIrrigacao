package br.com.apiPP.APIirrigacao.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;
import java.util.List;

import br.com.apiPP.APIirrigacao.model.Irrigacao;
import br.com.apiPP.APIirrigacao.repository.IrrigacaoRepository;

@Service
public class IrrigacaoService {
    private final Logger log = LoggerFactory.getLogger(IrrigacaoService.class);

    @Autowired
    IrrigacaoRepository irrigacaoRepository;

    public Irrigacao save(Irrigacao irrigacao) {
        irrigacao = irrigacaoRepository.save(irrigacao);
        return irrigacao;
    }

    public Optional<Irrigacao> findOne(Long idIrrigacao) {
        log.info("Request to get Irrigacao : {} ", idIrrigacao);
        return irrigacaoRepository.findById(idIrrigacao);
    }

    public List<Irrigacao> findAllList() {
        log.info("Request to get All Irrigacoes");
        List<Irrigacao> irrigacaoList = irrigacaoRepository.findAll();
        log.info("Return of getAllList " + irrigacaoList.size());
        return irrigacaoList;
    }

    public void delete(Long idIrrigacao) {
        log.info("Request to delete idIrrigacao : {}", idIrrigacao);
        irrigacaoRepository.deleteById(idIrrigacao);
    }

    public List<Irrigacao> saveAll(List<Irrigacao> irrigacaoList) {
        log.info("Request to save Irrigacao : {}", irrigacaoList);
        irrigacaoList = irrigacaoRepository.saveAll(irrigacaoList);
        return irrigacaoList;
    }
}

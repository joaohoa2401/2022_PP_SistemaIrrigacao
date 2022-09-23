package br.com.apiPP.APIirrigacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiPP.APIirrigacao.model.Irrigacao;

@Repository
public interface IrrigacaoRepository extends JpaRepository<Irrigacao, Long>{
    
}

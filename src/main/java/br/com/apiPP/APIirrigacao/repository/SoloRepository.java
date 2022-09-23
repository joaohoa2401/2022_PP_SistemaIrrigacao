package br.com.apiPP.APIirrigacao.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.apiPP.APIirrigacao.model.Solo;

@Repository
public interface SoloRepository extends JpaRepository<Solo, Long>{
    
}

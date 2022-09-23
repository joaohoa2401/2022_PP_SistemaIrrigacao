package br.com.apiPP.APIirrigacao.controller.api.v1;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.server.ResponseStatusException;

import br.com.apiPP.APIirrigacao.model.Solo;
import br.com.apiPP.APIirrigacao.service.SoloService;

public class  SoloController{
    private static SoloService soloService;

    public SoloController(SoloService soloService) {
        this.soloService = soloService;
    }

    @GetMapping("/{id_solo}")
    public ResponseEntity<Solo> getUsuario(@PathVariable Long id_solo){
        Optional<Solo> soloOp= soloService.findOne(id_solo);
        if(soloOp.isPresent()){
            return ResponseEntity.ok().body(soloOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    } 

    @GetMapping("/")
    public ResponseEntity<List<Solo>> getPets(){
        List<Solo> soloList = soloService.findAllList();
        if(soloList.size()>0){
            return ResponseEntity.ok().body(soloList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Solo> update(@RequestBody Solo solo){
        if(solo.getId_solo()== null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Solo id_solo = null");
        }
        solo =  soloService.save(solo);
        return ResponseEntity.ok().body(solo);
    }

    @PostMapping("/")
    public  ResponseEntity<Solo> create(@RequestBody Solo solo){
        if(solo.getId_solo()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Solo can't exists id_solo. ");
        }
        Solo result = soloService.save(solo);
        return ResponseEntity.ok().body(solo);
    }

    @DeleteMapping("/{id_solo}")
    public ResponseEntity<Void> deleteSolo(@PathVariable Long id_solo){
        soloService.delete(id_solo);
        return ResponseEntity.noContent().build();
    }

}
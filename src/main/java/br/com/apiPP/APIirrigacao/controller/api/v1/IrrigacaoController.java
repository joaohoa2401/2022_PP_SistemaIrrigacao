package br.com.apiPP.APIirrigacao.controller.api.v1;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;

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

import br.com.apiPP.APIirrigacao.model.Irrigacao;
import br.com.apiPP.APIirrigacao.service.IrrigacaoService;

@Controller
@RequestMapping("api/v1/irrigacao")
public class IrrigacaoController{
    private static IrrigacaoService irrigacaoService;

    public IrrigacaoController(IrrigacaoService irrigacaoService){
        this.irrigacaoService = irrigacaoService;
    }


    @GetMapping("/{idIrrigacao}")
    public ResponseEntity<Irrigacao> getIrrigacao(@PathVariable Long idIrrigacao){
        Optional<Irrigacao> irrigacaoOP= irrigacaoService.findOne(idIrrigacao);
        if(irrigacaoOP.isPresent()){
            return ResponseEntity.ok().body(irrigacaoOP.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/")
    public ResponseEntity<List<Irrigacao>> getIrrigacao(){
        List<Irrigacao> irrigacaoList = irrigacaoService.findAllList();
        if(irrigacaoList.size()>0){
            return ResponseEntity.ok().body(irrigacaoList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Irrigacao> update(@RequestBody Irrigacao irrigacao){
        if(irrigacao.getIdirrigacao()== null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Irrigacao idIrrigacao = null");
        }
        irrigacao = irrifacaoService.save(irrigacao);
        return ResponseEntity.ok().body(irrigacao);
    }

    @PostMapping("/")
    public  ResponseEntity<Irrigacao> create(@RequestBody Irrigacao irrigacao){
        if(irrigacao.getIdirrigacao()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Irrigacao can't exists idIrrigacao. ");
        }
    Irrigacao result = irrigacaoService.save(irrigacao);
        return ResponseEntity.ok().body(irrigacao);
    }

    @DeleteMapping("/{idIrrigacao}")
    public ResponseEntity<Void> deleteIrrigacao(@PathVariable Long idIrrigacao){
        irrigacaoService.delete(idIrrigacao);
        return ResponseEntity.noContent().build();
    }



}
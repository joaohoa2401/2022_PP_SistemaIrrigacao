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

import br.com.apiPP.APIirrigacao.model.Usuario;
import br.com.apiPP.APIirrigacao.service.UsuarioService;

@Controller
@RequestMapping("api/v1/usuario")

public class UsuarioController{
    private static UsuarioService usuarioService;

    public UsuarioController(UsuarioService usuarioService) {
        this.usuarioService = usuarioService;
    }

    @GetMapping("/{idUsuario}")
    public ResponseEntity<Usuario> getUsuario(@PathVariable Long idUsuario){
        Optional<Usuario> usuarioOp= usuarioService.findOne(idUsuario);
        if(usuarioOp.isPresent()){
            return ResponseEntity.ok().body(usuarioOp.get());
        }else{
            return ResponseEntity.notFound().build();
        }
    } 

    @GetMapping("/")
    public ResponseEntity<List<Usuario>> getUsuarios(){
        List<Usuario> usuarioList = usuarioService.findAllList();
        if(usuarioList.size()>0){
            return ResponseEntity.ok().body(usuarioList);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/")
    public ResponseEntity<Usuario> update(@RequestBody Usuario usuario){
        if(usuario.getIdUsuario()== null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Invalid Usuario idUsuario = null");
        }
        usuario =  usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @PostMapping("/")
    public  ResponseEntity<Usuario> create(@RequestBody Usuario usuario){
        if(usuario.getIdUsuario()!=null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "New Usuario can't exists id. ");
        }
        Usuario result = usuarioService.save(usuario);
        return ResponseEntity.ok().body(usuario);
    }

    @DeleteMapping("/{idUsuario}")
    public ResponseEntity<Void> deleteUsuario(@PathVariable Long idUsuario){
        usuarioService.delete(idUsuario);
        return ResponseEntity.noContent().build();
    }





}
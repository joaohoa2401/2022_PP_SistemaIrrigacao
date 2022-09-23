package br.com.apiPP.APIirrigacao.service;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

import br.com.apiPP.APIirrigacao.repository.UsuarioRepository;
import br.com.apiPP.APIirrigacao.model.Usuario;

@Service
public class UsuarioService {
    private final  Logger log = LoggerFactory.getLogger(UsuarioService.class);

    @Autowired
    UsuarioRepository usuarioRepository;

    public Usuario save(Usuario usuario){
        usuario = usuarioRepository.save(usuario);
        return usuario;
    }

    public Optional<Usuario> findOne(Long idUsuario){
        log.info("Request to get Usuario: {}", idUsuario);
        return usuarioRepository.findById(idUsuario);
    }

    public List<Usuario> findAllList(){
        log.info("Request to get All Usuarios");
        List<Usuario> usuarioList = usuarioRepository.findAll();
        log.info("Return of getAllList " + usuarioList.size());
        return usuarioList;
    }

    public  void delete(Long idUsuario) { 
        log.info("Request to delet Usuario : {} ", idUsuario);
        usuarioRepository.deleteById(idUsuario);
    }

    public List<Usuario> saveAll(List<Usuario> usuarioList) {
        log.info("Request to save Usuario : {}", usuarioList);
        usuarioList = usuarioRepository.saveAll(usuarioList);
        return usuarioList;
    }

}

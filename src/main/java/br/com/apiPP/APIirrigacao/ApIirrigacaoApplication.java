package br.com.apiPP.APIirrigacao;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
//import org.springframework.boot.ApplicationRunner;

import br.com.apiPP.APIirrigacao.model.Usuario;
import br.com.apiPP.APIirrigacao.service.UsuarioService;



@SpringBootApplication
public class ApIirrigacaoApplication {
	
	@Autowired
	UsuarioService usuarioService;

	public static void main(String[] args) {
		SpringApplication.run(ApIirrigacaoApplication.class, args);
	}

	public void run(ApplicationArguments args) throws Exception {
		Usuario usuario1 = new Usuario("Carlos", "31989022588", "email@email.com", "123456");
		Usuario usuario2 = new Usuario("Jorge", "31940028922", "Jorge@email.com", "1234567");
		usuario1 = usuarioService.save(usuario1);
		usuario2 = usuarioService.save(usuario2);

		System.out.println(usuario1);
		System.out.println(usuario2);
	}

}
  
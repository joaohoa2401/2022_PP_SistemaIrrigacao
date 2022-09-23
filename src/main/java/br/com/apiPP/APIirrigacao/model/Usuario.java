package br.com.apiPP.APIirrigacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name = "usuario")
public class Usuario {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idUsuario;

    @Column(length = 60, nullable = false)
    private String nome_usuario;

    @Column(length = 11, nullable = false)
    private String telefone_usuario;
    
    @Column(length = 60, nullable = false)
    private String email_usuario;

    @Column(length = 60, nullable = false)
    private String senha_usuario;

    public Usuario(String nome_usuario, String telefone_usuario, String email_usuario, String senha_usuario){
        this.nome_usuario = nome_usuario;
        this.telefone_usuario = telefone_usuario;
        this.email_usuario = email_usuario;
        this.senha_usuario = senha_usuario;
    }

}

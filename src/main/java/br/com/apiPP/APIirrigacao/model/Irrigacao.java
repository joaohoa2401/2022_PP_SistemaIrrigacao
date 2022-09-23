package br.com.apiPP.APIirrigacao.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.JoinColumn;
import javax.persistence.ForeignKey;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.time.DateTimeException;
import java.time.Duration;

@ToString
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="irrigacao")
public class Irrigacao {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idIrrigacao;

    @Column(length = 60, nullable = false)
    private String nome_irrigacao;

    @Column(length = 6, nullable = false)
    private DateTimeException horario_irrigacao;

    @Column(length = 8, nullable = false)
    private Duration tempo_irrigacao;

    @ManyToOne
    @JoinColumn(name = "idUsuario", nullable = false, foreignKey = @ForeignKey(name = "fk_irrigacao_usuario"))
    private Usuario usuario;

    public Irrigacao(String nome_irrigacao, DateTimeException horario_irrigacao, Duration tempo_irrigacao, Usuario usuario){
        this.nome_irrigacao = nome_irrigacao;
        this.horario_irrigacao = horario_irrigacao;
        this.tempo_irrigacao = tempo_irrigacao;
        this.usuario = usuario;
    }

}

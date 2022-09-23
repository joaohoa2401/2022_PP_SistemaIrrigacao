package br.com.apiPP.APIirrigacao.model;

import java.time.Instant;
import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Entity(name="solo")
public class Solo {
    @Id
    @GeneratedValue(strategy= GenerationType.IDENTITY)
    private Long id_solo;

    @Column(nullable = false)
    private Instant data_hora;
    private BigDecimal umidade;

    public Solo(Instant data_hora, BigDecimal umidade){
        this.data_hora = data_hora;
        this.umidade = umidade;
    }

}

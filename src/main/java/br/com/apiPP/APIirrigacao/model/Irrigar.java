package br.com.apiPP.APIirrigacao.model;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;


//import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@Getter
@Setter
@Entity(name="irrigar")
public class Irrigar {
    @Column(length = 1, nullable= false)
    private boolean realizar_irrigacao;

    @Column(nullable = false)
    private BigDecimal vazao_detectada;

    @ManyToOne
    @JoinColumn(name = "idIrrigacao", nullable = false, foreignKey = @ForeignKey(name = "fk_irrigar_irrigacao"))
    private Irrigacao irrigacao;

    @OneToOne
    @JoinColumn(name = "Solo_id_solo", nullable = false, foreignKey = @ForeignKey(name = "fk_irrigar_solo"))
    private Solo solo;


    public Irrigar(boolean realizar_irrigacao, BigDecimal vazao_detectada, Irrigacao irrigacao, Solo solo)
    {
        this.irrigacao = irrigacao;
        this.solo =  solo;
        this.realizar_irrigacao = realizar_irrigacao;
        this.vazao_detectada = vazao_detectada;        
    }

}

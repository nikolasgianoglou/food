package com.example.algafoodapi.domain.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;
import java.util.Objects;

@Entity
public class Restaurante {

    @Id
    private Long id;

    private String nome;

    @Column(name = "taxa_frete")
    private BigDecimal taxaFrete;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public BigDecimal getTaxaFrete() {
        return taxaFrete;
    }

    public void setTaxaFrete(BigDecimal taxaFrete) {
        this.taxaFrete = taxaFrete;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Restaurante that = (Restaurante) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

/**
 * Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
 * Simétrico: para x e y diferentes de null, se x.equals(y) == true logo y.equals(x) == true
 * Transitividade: para x, y e z diferentes de null, se x.equals(y) ==true e x.equals(z) == true logo y.equals(z) == true
 * Consistente: x.equals(x) sempre retorna true se x for diferente de null
 * para x diferente de null, x.equals(null) tem que retornar false
 */




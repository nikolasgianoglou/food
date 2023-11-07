package com.example.algafoodapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @Id
    @EqualsAndHashCode.Include
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;

    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;
}

/**
 * Reflexivo: x.equals(x) tem que ser true para tudo que for diferente de null
 * Simétrico: para x e y diferentes de null, se x.equals(y) == true logo y.equals(x) == true
 * Transitividade: para x, y e z diferentes de null, se x.equals(y) ==true e x.equals(z) == true logo y.equals(z) == true
 * Consistente: x.equals(x) sempre retorna true se x for diferente de null
 * para x diferente de null, x.equals(null) tem que retornar false
 */




package com.example.algafoodapi.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity // representa uma entidade
//@Table(name="tab_cozinhas")
public class Cozinha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // diz que quem gera a chave é o proprio provedor do banco de dados
    private Long id;

//    @Column(name = "nom_cozinha", length = 80)
    private String nome;

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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cozinha cozinha = (Cozinha) o;
        return Objects.equals(id, cozinha.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

package com.example.algafoodapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Objects;

//@Getter
//@Setter
//@EqualsAndHashCode
@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity // representa uma entidade
//@Table(name="tab_cozinhas")
public class Cozinha {

    @EqualsAndHashCode.Include //crie um equals e hash code apenas usando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // diz que quem gera a chave é o proprio provedor do banco de dados
    private Long id;

    @Column(length = 80, nullable = false)
    private String nome;
}

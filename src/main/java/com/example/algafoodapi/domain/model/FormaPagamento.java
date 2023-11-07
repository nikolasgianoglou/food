package com.example.algafoodapi.domain.model;

import lombok.Data;
import lombok.EqualsAndHashCode;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class FormaPagamento {

    @EqualsAndHashCode.Include //crie um equals e hash code apenas usando o id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) // diz que quem gera a chave é o proprio provedor do banco de dados
    private Long id;
    private String descricao;
}

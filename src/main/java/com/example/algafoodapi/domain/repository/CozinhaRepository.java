package com.example.algafoodapi.domain.repository;

import com.example.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository /** Anotando esse classe com @Repository e herdando essa classe JpaRepository<T, ID> o Spring JPA me fornece a implementação dos métodos*/
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findTodasByNome(String nome); //Colocando o nome de uma propriedade o Spring cria o metodo para consultar por nome: read, get, query, stream

    List<Cozinha> findTodasByNomeContaining(String nome); //Containing é uma key word usada para adicionar na pesquisa o like
    Optional<Cozinha> findEspecificByNome(String nome);
    boolean existsByNome(String nome);
}

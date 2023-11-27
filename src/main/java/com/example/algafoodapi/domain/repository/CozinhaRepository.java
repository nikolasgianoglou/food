package com.example.algafoodapi.domain.repository;

import com.example.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository /** Anotando esse classe com @Repository e herdando essa classe JpaRepository<T, ID> o Spring JPA me fornece a implementação dos métodos*/
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

    List<Cozinha> findByNome(String nome); //Colocando o nome de uma propriedade o Spring cria o metodo para consultar por nome
    Optional<Cozinha> findEspecificByNome(String nome);
}

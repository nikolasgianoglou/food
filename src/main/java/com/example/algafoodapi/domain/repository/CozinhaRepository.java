package com.example.algafoodapi.domain.repository;

import com.example.algafoodapi.domain.model.Cozinha;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository /** Anotando esse classe com @Repository e herdando essa classe JpaRepository<T, ID> o Spring JPA me fornece a implementação dos métodos*/
public interface CozinhaRepository extends JpaRepository<Cozinha, Long> {

//    List<Cozinha> listar();
//    List<Cozinha> buscarPorNome(String nome);
//    Cozinha buscar(Long id);
//    Cozinha salvar(Cozinha cozinha);
//    void remover(Long id);
}

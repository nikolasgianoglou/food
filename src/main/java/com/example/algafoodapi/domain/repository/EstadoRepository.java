package com.example.algafoodapi.domain.repository;
import com.example.algafoodapi.domain.model.Estado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EstadoRepository extends JpaRepository<Estado, Long> {
//    List<Estado> listar();
//    Estado buscar(Long id);
//    Estado salvar(Estado estado);
//    void remover(Long id);
}

package com.example.algafoodapi.domain.repository;
import com.example.algafoodapi.domain.model.Cidade;

import java.util.List;

public interface CidadeRepository {
    List<Cidade> listar();
    Cidade buscar(Long id);
    Cidade salvar(Cidade cidade);
    void remover(Long id);
}

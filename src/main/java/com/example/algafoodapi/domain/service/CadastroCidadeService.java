package com.example.algafoodapi.domain.service;

import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.Cidade;
import com.example.algafoodapi.domain.model.Estado;
import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.CidadeRepository;
import com.example.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Service
public class CadastroCidadeService {

    @Autowired
    private CidadeRepository cidadeRepository;
    @Autowired
    private EstadoRepository estadoRepository;

    public Cidade salvar(Cidade cidade) {
        Long estadoId = cidade.getEstado().getId();
        Estado estado = estadoRepository.findById(estadoId).orElseThrow(
                ()-> new EntidadeNaoEncontradaException(String.format("Não existe cadastro de estado com id %d", estadoId)));
//        if (estado == null) {
//            throw new EntidadeNaoEncontradaException(
//                    String.format("Não existe cadastro de estado com id %d", estadoId)
//            );
//        }
        cidade.setEstado(estado);
        return cidadeRepository.save(cidade);
    }

    public void excluir(Long cidadeId) {
        try {
            cidadeRepository.deleteById(cidadeId);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cidade com código %d", cidadeId)
            );
        } catch (DataIntegrityViolationException e) {
            String.format("Cidade com código %d não pode ser removida pois está em uso", cidadeId);
        }
    }
}

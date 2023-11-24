package com.example.algafoodapi.domain.service;

import com.example.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.FormaPagamento;
import com.example.algafoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroFormaPagamentoService {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    public FormaPagamento salvar(FormaPagamento formaPagamento) {
        return formaPagamentoRepository.save(formaPagamento);
    }

    public void excluir(Long id) {
        try {
            formaPagamentoRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format("Não existe um cadastro de cozinha com código %d", id)
            );
        }
        catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format("Cozinha de código %d não pode ser removida, pois está em uso", id)
            );
        }
    }


}

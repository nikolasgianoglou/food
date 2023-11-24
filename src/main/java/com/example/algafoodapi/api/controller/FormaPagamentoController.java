package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.FormaPagamento;
import com.example.algafoodapi.domain.repository.FormaPagamentoRepository;
import com.example.algafoodapi.domain.service.CadastroFormaPagamentoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/forma-pagamento")
public class FormaPagamentoController {

    @Autowired
    private FormaPagamentoRepository formaPagamentoRepository;

    @Autowired
    private CadastroFormaPagamentoService cadastroFormaPagamento;

    @GetMapping
    public List<FormaPagamento> listar() {
        return formaPagamentoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<FormaPagamento> buscar(@PathVariable Long id) {
        Optional<FormaPagamento> formaPagamento = formaPagamentoRepository.findById(id);
        if(formaPagamento.isPresent()) {
            return ResponseEntity.ok(formaPagamento.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    public FormaPagamento adicionar(@RequestBody FormaPagamento formaPagamento) {
        return cadastroFormaPagamento.salvar(formaPagamento);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<FormaPagamento> atualizar(@PathVariable Long id, @RequestBody FormaPagamento formaPagamento) {
        Optional<FormaPagamento> formaPagamentoAtual = formaPagamentoRepository.findById(id);
        if(formaPagamentoAtual.isPresent()) {
            BeanUtils.copyProperties(formaPagamento, formaPagamentoAtual.get(), "id");
            FormaPagamento formaPagamentoSalva = cadastroFormaPagamento.salvar(formaPagamentoAtual.get());
            return ResponseEntity.ok(formaPagamentoSalva);
        }

        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {

        try {
            cadastroFormaPagamento.excluir(id);
            return ResponseEntity.noContent().build();
        }catch (EntidadeNaoEncontradaException e){
            return ResponseEntity.notFound().build();
        }
        catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }

}

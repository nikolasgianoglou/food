package com.example.algafoodapi.api.controller;

import com.example.algafoodapi.domain.exception.EntidadeEmUsoException;
import com.example.algafoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.example.algafoodapi.domain.model.Estado;
import com.example.algafoodapi.domain.model.Permissao;
import com.example.algafoodapi.domain.model.Restaurante;
import com.example.algafoodapi.domain.repository.PermissaoRepository;
import com.example.algafoodapi.domain.service.CadastroPermissaoService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(value = "/permissao")
public class PermissaoController {

    @Autowired
    private PermissaoRepository permissaoRepository;

    @Autowired
    private CadastroPermissaoService cadastroPermissao;

    @GetMapping
    public List<Permissao> listar() {
        return permissaoRepository.findAll();
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Permissao> buscar(@PathVariable Long id) {
        Optional<Permissao> permissao = permissaoRepository.findById(id);
        if(permissao.isPresent()) {
            return ResponseEntity.ok(permissao.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping
    public Permissao adicionar(@RequestBody Permissao permissao) {
        return cadastroPermissao.salvar(permissao);
    }

    @PutMapping(value = "/{permissaoId}")
    public ResponseEntity<Permissao> atualizar(@PathVariable("permissaoId") Long id, @RequestBody Estado estado) {
        Optional<Permissao> permissaoAtual = permissaoRepository.findById(id);
        if(permissaoAtual.isPresent()) {
            BeanUtils.copyProperties(estado, permissaoAtual.get(), "id");
            Permissao permissaoSalva = cadastroPermissao.salvar(permissaoAtual.get());
            return ResponseEntity.ok(permissaoSalva);
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping(value = "/{id}")
    public ResponseEntity<?> remover(@PathVariable Long id) {
        try {
            cadastroPermissao.excluir(id);
            return ResponseEntity.noContent().build();
        } catch (EntidadeNaoEncontradaException e) {
            return ResponseEntity.notFound().build();
        } catch (EntidadeEmUsoException e) {
            return ResponseEntity.status(HttpStatus.CONFLICT).body(e.getMessage());
        }
    }
}

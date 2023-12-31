package com.example.algafoodapi.infrastructure.repository;

import com.example.algafoodapi.domain.model.Cidade;
import com.example.algafoodapi.domain.model.FormaPagamento;
import com.example.algafoodapi.domain.repository.CidadeRepository;
import com.example.algafoodapi.domain.repository.FormaPagamentoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//@Component
//public class FormaPagamentoRepositoryImp implements FormaPagamentoRepository {
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<FormaPagamento> listar() {
//        TypedQuery<FormaPagamento> query = manager.createQuery("from FormaPagamento", FormaPagamento.class);
//        return query.getResultList();
//    }
//    @Override
//    public FormaPagamento buscar(Long id) {
//        return manager.find(FormaPagamento.class, id);
//    }
//
//    @Transactional
//    @Override
//    public FormaPagamento salvar(FormaPagamento formaPagamento) {
//        return manager.merge(formaPagamento);
//    }
//
//    @Transactional
//    @Override
//    public void remover(FormaPagamento formaPagamento) {
//        formaPagamento = buscar(formaPagamento.getId());
//        manager.remove(formaPagamento);
//    }
//}

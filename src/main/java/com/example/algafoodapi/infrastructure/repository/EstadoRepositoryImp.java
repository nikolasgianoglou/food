package com.example.algafoodapi.infrastructure.repository;

import com.example.algafoodapi.domain.model.Cidade;
import com.example.algafoodapi.domain.model.Estado;
import com.example.algafoodapi.domain.repository.CidadeRepository;
import com.example.algafoodapi.domain.repository.EstadoRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//@Component
//public class EstadoRepositoryImp implements EstadoRepository {
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<Estado> listar() {
//        TypedQuery<Estado> query = manager.createQuery("from Estado", Estado.class);
//        return query.getResultList();
//    }
//    @Override
//    public Estado buscar(Long id) {
//        return manager.find(Estado.class, id);
//    }
//
//    @Transactional
//    @Override
//    public Estado salvar(Estado estado) {
//        return manager.merge(estado);
//    }
//
//    @Transactional
//    @Override
//    public void remover(Long id) {
//        Estado estado = buscar(id);
//        if(estado==null) {
//            throw new EmptyResultDataAccessException(1);
//        }
//        manager.remove(estado);
//    }
//}

package com.example.algafoodapi.infrastructure.repository;

import com.example.algafoodapi.domain.model.Estado;
import com.example.algafoodapi.domain.model.Permissao;
import com.example.algafoodapi.domain.repository.EstadoRepository;
import com.example.algafoodapi.domain.repository.PermissaoRepository;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//@Component
//public class PermissaoRepositoryImp implements PermissaoRepository {
//
//    @PersistenceContext
//    private EntityManager manager;
//
//    @Override
//    public List<Permissao> listar() {
//        TypedQuery<Permissao> query = manager.createQuery("from Permissao", Permissao.class);
//        return query.getResultList();
//    }
//    @Override
//    public Permissao buscar(Long id) {
//        return manager.find(Permissao.class, id);
//    }
//
//    @Transactional
//    @Override
//    public Permissao salvar(Permissao permissao) {
//        return manager.merge(permissao);
//    }
//
//    @Transactional
//    @Override
//    public void remover(Permissao permissao) {
//        permissao = buscar(permissao.getId());
//        manager.remove(permissao);
//    }
//}

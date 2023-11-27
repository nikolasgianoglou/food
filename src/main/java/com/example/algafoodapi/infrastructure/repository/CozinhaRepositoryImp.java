package com.example.algafoodapi.infrastructure.repository;

import com.example.algafoodapi.domain.model.Cozinha;
import com.example.algafoodapi.domain.repository.CozinhaRepository;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

//@Component
@Repository //Dá semantica a notação e traduz alguma exceptions que são lançadas
public class CozinhaRepositoryImp /**implements CozinhaRepository*/ {
    /***
     * Classe comentada para implementação do spring data JPA
     */
    @PersistenceContext
    private EntityManager manager;

//    @Override
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

//    @Override
    public List<Cozinha> consultaPorNome(String nome) {
//        return manager.createQuery("from Cozinha where nome=:nome", Cozinha.class)
        return manager.createQuery("from Cozinha where nome like :nome", Cozinha.class)
                .setParameter("nome","%"+nome+"%")
                .getResultList();
    }

//    @Override
    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional
//    @Override
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha);
    }

    @Transactional
//    @Override
    public void remover(Long id) {
        Cozinha cozinha = buscar(id);
        if(cozinha == null) {
            throw new EmptyResultDataAccessException(1);
        }
        manager.remove(cozinha);
    }
}

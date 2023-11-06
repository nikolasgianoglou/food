package com.example.algafoodapi.jpa;

import com.example.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {

    @PersistenceContext //injeta um Entity Manager
    private EntityManager manager;
    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    @Transactional // quando anoto um metodo com Transactional esse metodo sera executado dentro de uma transacao
    public Cozinha adicionar(Cozinha cozinha) {
        return manager.merge(cozinha); //retorna a instancia persistida, nao altera o que foi passado como parametro
    }
}

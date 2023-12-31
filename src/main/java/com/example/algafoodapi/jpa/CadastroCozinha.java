package com.example.algafoodapi.jpa;

import com.example.algafoodapi.domain.model.Cozinha;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import javax.transaction.Transactional;
import java.util.List;

@Component
public class CadastroCozinha {
//    EntityManagerFactory entityManagerFactory = Persistence.createEntityManagerFactory("Clientes-PU");
//    EntityManager entityManager = entityManagerFactory.createEntityManager();
    @PersistenceContext //injeta um Entity Manager
    private EntityManager manager;

    public List<Cozinha> listar() {
        TypedQuery<Cozinha> query = manager.createQuery("from Cozinha", Cozinha.class);
        return query.getResultList();
    }

    public Cozinha buscar(Long id) {
        return manager.find(Cozinha.class, id);
    }

    @Transactional // quando anoto um metodo com Transactional esse metodo sera executado dentro de uma transacao
    public Cozinha salvar(Cozinha cozinha) {
        return manager.merge(cozinha); //retorna a instancia persistida, nao altera o que foi passado como parametro
    }

    @Transactional
    public void remover(Cozinha cozinha) {
        cozinha = buscar(cozinha.getId());
        manager.remove(cozinha);
    }
}

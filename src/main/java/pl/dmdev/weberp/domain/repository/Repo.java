package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmdev.weberp.domain.Inspector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class Repo {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addInspector(Inspector inspector){
        em.persist(inspector);
    }

    @Transactional
    public void addObject(pl.dmdev.weberp.domain.repository.Object object){
        em.persist(object);
    }


    public Inspector getId(int id) {
       return em.find(Inspector.class,id);
    }
}

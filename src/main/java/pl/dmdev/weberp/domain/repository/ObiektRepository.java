package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmdev.weberp.domain.model.Obiekt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class ObiektRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addNewObiekt(Obiekt obiekt){
        em.persist(obiekt);
    }

    public Collection<Obiekt> getAllObiekt(){
        return em.createQuery("from Obiekt", Obiekt.class).getResultList();
    }

    public Obiekt getObiektById(int id){
        return em.find(Obiekt.class,id);
    }


    public void delete(Integer id) {
        Obiekt obiekt = em.find(Obiekt.class,id);
        em.remove(obiekt);
    }
}

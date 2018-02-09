package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import pl.dmdev.weberp.domain.Obiekt;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class ObiektRepository {

    @PersistenceContext
    private EntityManager em;

    public void addNewObiekt(Obiekt obiekt){
        em.persist(obiekt);
    }

    public Collection<Obiekt> getAllObiekt(){
        return em.createQuery("from Obiekt", Obiekt.class).getResultList();
    }

    public Obiekt getInspecotrById(int id){
        return em.find(Obiekt.class,id);
    }


}

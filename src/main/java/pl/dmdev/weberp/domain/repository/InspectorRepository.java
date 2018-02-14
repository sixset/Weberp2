package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmdev.weberp.domain.model.Inspector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class InspectorRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void addNewInspector(Inspector inspector){
        em.persist(inspector);
    }
    @Transactional
    public void mergeInspector(Inspector inspector){
        em.merge(inspector);
    }

    public Collection<Inspector> getAllInspector(){
        return em.createQuery("from Inspector", Inspector.class).getResultList();
    }

    public Inspector getInspecotrById(int id){
        return em.find(Inspector.class,id);
    }


    public Inspector getInspectorByUsername(String username) {

        Inspector inspectorByName = em.createQuery("from Inspector k where k.username=:username", Inspector.class)
                .setParameter("username", username).getSingleResult();

        return inspectorByName;
    }
}

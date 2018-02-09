package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import pl.dmdev.weberp.domain.Inspector;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class InspectorRepository {

    @PersistenceContext
    private EntityManager em;

    public void addNewInspector(Inspector inspector){
        em.persist(inspector);
    }

    public Collection<Inspector> getAllInspector(){
        return em.createQuery("from Inspecotr", Inspector.class).getResultList();
    }

    public Inspector getInspecotrById(int id){
        return em.find(Inspector.class,id);
    }


}

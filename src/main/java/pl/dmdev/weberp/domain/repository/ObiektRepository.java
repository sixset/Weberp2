package pl.dmdev.weberp.domain.repository;//package pl.dmdev.weberp.domain.repository;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import pl.dmdev.weberp.domain.model.Obiekt;

@Repository
public interface ObiektRepository extends JpaRepository<Obiekt, Integer> {

}













//import org.springframework.stereotype.Repository;
//import org.springframework.transaction.annotation.Transactional;
//import pl.dmdev.weberp.domain.model.Inspector;
//import pl.dmdev.weberp.domain.model.Obiekt;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import java.util.Collection;
//
//@Repository
//public class ObiektRepository {
//
//    @PersistenceContext
//    private EntityManager em;
//
//    @Transactional
//    public void addNewObiekt(Obiekt obiekt){
//        em.persist(obiekt);
//        em.clear();
//    }
//
//    public Collection<Obiekt> getAllObiekt(){
//        return em.createQuery("from Obiekt", Obiekt.class).getResultList();
//    }
//
//    public Obiekt getObiektById(int id){
//        return em.find(Obiekt.class,id);
//    }
//
//
//    public void delete(Integer id) {
//        Obiekt obiekt = em.find(Obiekt.class,id);
//        em.remove(obiekt);
//    }
//    @Transactional
//    public void mergeObiekt(Obiekt obiekt) {
//        em.merge(obiekt);
//    }
//
//    public Obiekt getObiektByName(String name) {
//        Obiekt obiekt = em.createQuery("from Obiekt k where k.name=:name", Obiekt.class)
//                .setParameter("name", name).getSingleResult();
//        return obiekt;
//    }
//}

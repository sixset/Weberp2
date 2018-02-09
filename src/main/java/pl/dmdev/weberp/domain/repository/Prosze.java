//package pl.dmdev.weberp.domain.repository;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import pl.dmdev.weberp.domain.Inspector;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//
//@Component
//public class Prosze {
//
//
//    @PersistenceContext
//    private EntityManager em;
//    @Autowired
//    Repo repo;
//
//    public void makeit() {
//        Inspector inspector = new Inspector();
//        inspector.setName("czesc");
//        repo.addInspector(inspector);
//
//        em.getTransaction().begin();
//        Inspector inspector1 = em.find(Inspector.class, 1);
//        Object object = new Object();
//        object.setName("siemnello");
//        inspector.addObject(object);
//        em.persist(object);
//        em.getTransaction().commit();
//        em.close();
//
//    }
//
//
//}

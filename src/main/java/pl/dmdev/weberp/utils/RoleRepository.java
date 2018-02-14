package pl.dmdev.weberp.utils;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Repository
public class RoleRepository {

    @PersistenceContext
    private EntityManager em;

    @Transactional
    public void persistRole(Role role){
        em.persist(role);
    }
}

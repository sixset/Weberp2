package pl.dmdev.weberp.domain.repository;

import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.dmdev.weberp.domain.Employee;


import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.Collection;

@Repository
public class EmployeeRepository {
    @PersistenceContext
    private EntityManager em;


    @Transactional
    public void createEmployee(int id,String name, String lastname, String deal, int rate, int pof, int numberoflegit,String sil,String sys,String eko){
       Employee newemployee = new Employee( id, name,  lastname,  deal,  rate,  pof,  numberoflegit ,sil,sys,eko);
        em.persist(newemployee);
    }

    public void addNewEmployee(Employee employee){
        em.persist(employee);
    }

    public Collection<Employee> getAllEmployee(){
        return  em.createQuery("from Employee", Employee.class).getResultList();
    }

    public Employee getEmployeeById(int id){
        return em.find(Employee.class, id);
    }

    public Employee newEmptyEmploye(){
        return new Employee();
    }

    @Transactional
    public void saveEditEmploye(int id , Employee employee) {
        em.merge(employee);
    }
}

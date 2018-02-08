package pl.dmdev.weberp.repository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.dmdev.weberp.domain.Employee;


import java.util.Collection;
import java.util.HashMap;
import java.util.Map;
import java.util.Random;

@Repository
public class EmployeeRepository {
    @Autowired
    Employee employee;

    Map<Integer,Employee> employeeMap =new  HashMap<>();

    public void createEmployee(int id,String name, String lastname, String deal, int rate, int pof, int numberoflegit,String sil,String sys,String eko){
       Employee newemployee = new Employee( id, name,  lastname,  deal,  rate,  pof,  numberoflegit ,sil,sys,eko);
        employeeMap.put(id,newemployee);
    }

    public void addNewEmployee(Employee employee){
        Random random = new Random();
        employeeMap.put(random.nextInt(100),employee);
    }


    public void editEmpoyee(int id, Employee employee){

//        employeeMap.get(id);
        System.out.println("edytuje "+  employeeMap.get(id));
    }

    public Collection<Employee> getAllEmployee(){
        return employeeMap.values();
    }

    public Employee getEmployeeById(int id){
        return employeeMap.get(id);
    }

    public Employee newEmptyEmploye(){
        return new Employee();
    }






}

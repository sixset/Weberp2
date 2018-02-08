package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.Employee;
import pl.dmdev.weberp.repository.EmployeeRepository;


import java.util.ArrayList;
import java.util.List;

@Component
public class EmployyeSerwice {

    @Autowired
    EmployeeRepository employeeRepository;

    public List<Employee> getAllEmploye() {
        List<Employee> allemploye = new ArrayList<>(employeeRepository.getAllEmployee());
        return allemploye;
    }

    public Employee createEmptyEmployee(){
       Employee employee = employeeRepository.newEmptyEmploye();
       return employee;
    }

    public void saveEmployee(Employee employee) {
        employeeRepository.addNewEmployee(employee);
    }

    public Employee getEmployee(int id) {
        return employeeRepository.getEmployeeById(id);

    }

    public void saveEditEmploye(Employee employee) {
        employeeRepository.saveEditEmploye(employee);
    }
}

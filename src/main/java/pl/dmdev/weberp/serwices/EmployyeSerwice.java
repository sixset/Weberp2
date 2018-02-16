package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.model.Employee;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.repository.EmployeeRepository;


import java.util.ArrayList;
import java.util.List;

@Component
public class EmployyeSerwice {

    @Autowired
    EmployeeRepository employeeRepository;
    @Autowired
    InspectorService inspectorService;

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
        employeeRepository.saveEditEmploye(employee.getId(),employee);
    }

    public void addInspector(Integer idEmployee) {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String username = authentication.getName();
        Inspector inspector = inspectorService.getInspectorByUsername(username);
        Employee employye = employeeRepository.getEmployeeById(idEmployee);
        inspector.addEmployee(employye);
        inspectorService.mergeInspector(inspector);
    }
}

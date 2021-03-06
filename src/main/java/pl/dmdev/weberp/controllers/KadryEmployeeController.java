package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import pl.dmdev.weberp.domain.model.Employee;
import pl.dmdev.weberp.domain.repository.EmployeeRepository;
import pl.dmdev.weberp.serwices.EmployyeSerwice;

import java.util.List;

@Controller
public class KadryEmployeeController {

    @Autowired
    EmployyeSerwice employyeSerwice;
    @Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/kadry/employees")
    public String getEmployee(Model model) {
        List<Employee> allEmploye = employyeSerwice.getAllEmploye();
        model.addAttribute("employees", allEmploye);
        return "kadry/kadryemployees";
    }

    @RequestMapping("/kadry/newemployee")
    public String createEmployee(Model model) {
        model.addAttribute("employe", employyeSerwice.createEmptyEmployee());
        return "kadry/newemployee";
    }

    @RequestMapping("/kadry/editemployee")
    public String editEmployee(@RequestParam("id") Integer id, Model model) {
        Employee employee = employyeSerwice.getEmployee(id);
        model.addAttribute("editemployee", employee);
        return "kadry/editemployee";
    }

    @RequestMapping(value = "/kadry/editemployee", method = RequestMethod.POST)
    public String saveEditEmployee(Employee editemploye) {
        employyeSerwice.saveEditEmploye(editemploye);
        return "redirect:/kadry/employees";
    }

    @RequestMapping(value = "/kadry/employees", method = RequestMethod.POST)
    public String saveEmployee(Employee employee) {
        employeeRepository.saveEditEmploye(employee.getId(), employee);
        return "redirect:/kadry/employees";
    }
}

package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.RequestParam;
import pl.dmdev.weberp.domain.Employee;
import pl.dmdev.weberp.repository.EmployeeRepository;
import pl.dmdev.weberp.serwices.EmployyeSerwice;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

@Autowired
EmployyeSerwice employyeSerwice;
@Autowired
    EmployeeRepository employeeRepository;

    @RequestMapping("/employees")
    public String getEmployee(Model model){
       List <Employee> allEmploye = employyeSerwice.getAllEmploye();
       model.addAttribute("employees",allEmploye);
        return "employees";
    }

    @RequestMapping("/newemployee")
    public String createEmployee(Model model){
        model.addAttribute("employe",employyeSerwice.createEmptyEmployee());
        return "newemployee";
    }

    @RequestMapping("/editemployee")
    public String editEmployee(@RequestParam("id") Integer id, Model model){
        Employee employee = employyeSerwice.getEmployee(id);
        model.addAttribute("editemployee",employee);
        return "editemployee";
    }

    @RequestMapping(value = "/editemployee",method = RequestMethod.POST)
    public String saveEditEmployee(Employee editemploye){
        employyeSerwice.saveEditEmploye(editemploye);
        return "redirect:/employees";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public String saveEmployee(Employee employee){
        employeeRepository.saveEditEmploye(employee.getId(),employee);
        return "redirect:/employees";
    }
}

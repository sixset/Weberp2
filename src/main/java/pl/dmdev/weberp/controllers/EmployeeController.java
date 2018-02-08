package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import pl.dmdev.weberp.domain.Employee;
import pl.dmdev.weberp.serwices.EmployyeSerwice;

import java.util.ArrayList;
import java.util.List;

@Controller
public class EmployeeController {

@Autowired
EmployyeSerwice employyeSerwice;

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
    public String editEmployee(Model model){
        model.addAttribute("employe",employyeSerwice.createEmptyEmployee());
        return "editemployee";
    }

    @RequestMapping(value = "/employees",method = RequestMethod.POST)
    public String saveEmployee(Employee employee){
        employyeSerwice.saveEmployee(employee);
        return "redirect:/employees";
    }
}

package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dmdev.weberp.domain.model.Employee;
import pl.dmdev.weberp.serwices.EmployyeSerwice;

import java.util.List;

@Controller
public class EmployeeController {

    @Autowired
    EmployyeSerwice employyeSerwice;

    @GetMapping("/inspektor/employees")
    public String getAllEmployees(Model model) {
        List<Employee> allEmploye = employyeSerwice.getAllEmploye();
        model.addAttribute("employees", allEmploye);
        return "employees";
    }

    @GetMapping("/inspektor/addtome")
    public String deleteObject(@RequestParam("id") Integer idEmployee) {
        employyeSerwice.addInspector(idEmployee);
        return "redirect:/inspektor/employees";
    }
}

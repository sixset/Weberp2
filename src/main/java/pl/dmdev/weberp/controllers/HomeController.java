package pl.dmdev.weberp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmdev.weberp.domain.model.Employee;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {

        return "index";
    }

//    @GetMapping("/login")
//    public String login() {
//        return "login";
//    }



}

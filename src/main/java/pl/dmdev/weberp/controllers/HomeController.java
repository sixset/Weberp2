package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.serwices.ObiektService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class HomeController {

    @Autowired
    ObiektService obiektService;


    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/objects")
    public String getAllObjects(Model model) {
        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
        model.addAllAttributes(allObiekt);
        model.addAttribute("allobject", allObiekt);
        return "objects";

    }


}

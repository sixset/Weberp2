package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dmdev.weberp.domain.Inspector;
import pl.dmdev.weberp.domain.Obiekt;
import pl.dmdev.weberp.serwices.ObiektService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenageObiektController {

    @Autowired
    ObiektService obiektService;

    @GetMapping("/allobiektadmin")
    public String index(Model model) {
        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
        List<Inspector> allInspector = new ArrayList<>(obiektService.getAllInspektor());
        model.addAttribute("allobject",allObiekt);
        model.addAttribute("allInspector",allInspector);
        return "allobiektadmin";
    }

}

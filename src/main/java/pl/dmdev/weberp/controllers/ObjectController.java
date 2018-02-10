package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dmdev.weberp.domain.Obiekt;
import pl.dmdev.weberp.serwices.ObiektService;
import pl.dmdev.weberp.utils.IdHolder;

import java.util.ArrayList;
import java.util.List;
@Controller
public class ObjectController {

    @Autowired
    ObiektService obiektService;

    @GetMapping("/objects")
    public String getAllObjects(Model model) {
        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
        model.addAllAttributes(allObiekt);
        model.addAttribute("allobject", allObiekt);
        return "objects";
    }
}

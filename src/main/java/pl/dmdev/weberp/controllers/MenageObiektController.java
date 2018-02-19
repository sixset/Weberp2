package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.serwices.InspectorService;
import pl.dmdev.weberp.serwices.ObiektService;
import pl.dmdev.weberp.utils.IdHolder;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenageObiektController {

    @Autowired
    ObiektService obiektService;
    @Autowired
    InspectorService inspectorService;

    @GetMapping("/dyrekcja/objects")
    public String getAllObjectsForAdmin(Model model) {
        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
        model.addAllAttributes(allObiekt);
        model.addAttribute("allobject", allObiekt);
        return "dyrekcja/objectsadmin";

    }


    @GetMapping("/dyrekcja/newobject")
    public String newObiekt(Model model) {

        model.addAttribute("obiekt", new Obiekt());
        model.addAttribute("idHolder", new IdHolder());
        model.addAttribute("allinspector", inspectorService.getAllInspector());

        return "dyrekcja/newobject";
    }

    @RequestMapping(value = "/objectsadmin", method = RequestMethod.POST)
    public String saveEditEmployee(Obiekt obiekt,IdHolder idHolder) {
       obiektService.addNewObjectDBWithInspecotr(idHolder.getId(),obiekt);
        return "redirect:/dyrekcja/objects";
    }

    @RequestMapping("/dyrekcja/delete")
    public String deleteObject(@RequestParam("id") Integer id, Model model) {
       obiektService.deleteObject(id);
        return "redirect:/dyrekcja/objects";
    }


}

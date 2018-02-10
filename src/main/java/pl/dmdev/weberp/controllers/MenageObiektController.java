package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmdev.weberp.domain.Inspector;
import pl.dmdev.weberp.domain.Obiekt;
import pl.dmdev.weberp.serwices.InspectorService;
import pl.dmdev.weberp.serwices.ObiektService;
import pl.dmdev.weberp.utils.IdHolder;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class MenageObiektController {

    @Autowired
    ObiektService obiektService;
    @Autowired
    InspectorService inspectorService;

    @GetMapping("/allobiektadmin")
    public String index(Model model) { ;
        return "allobiektadmin";
    }
    @GetMapping("/dyrekcja/objects")
    public String getAllObjectsForAdmin(Model model) {
        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
        model.addAllAttributes(allObiekt);
        model.addAttribute("allobject", allObiekt);
        return "objectsadmin";
    }

    @GetMapping("/newobject")
    public String newObiekt(Model model) {
        Inspector inspector = inspectorService.createEmptyInspector();
        Inspector inspecto2 = inspectorService.createEmptyInspector();
        inspector.setName("Dominik");
        inspecto2.setName("Ewa");
        inspectorService.addNewIncpectorToDB(inspector);
        inspectorService.addNewIncpectorToDB(inspecto2);

        model.addAttribute("obiekt", obiektService.createEmptyObiekt());
        model.addAttribute("idHolder", new IdHolder());
        model.addAttribute("allinspector", inspectorService.getAllInspector());

        return "newobject";
    }

    @RequestMapping(value = "/objectsadmin", method = RequestMethod.POST)
    public String saveEditEmployee(Obiekt obiekt,IdHolder idHolder) {
        obiektService.createnEewObject(Integer.valueOf(idHolder.getId()),obiekt);
        return "redirect:/dyrekcja/objects";
    }

}

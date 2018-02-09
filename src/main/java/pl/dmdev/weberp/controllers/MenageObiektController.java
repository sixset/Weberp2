package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dmdev.weberp.domain.Inspector;
import pl.dmdev.weberp.domain.Obiekt;
import pl.dmdev.weberp.serwices.InspectorService;
import pl.dmdev.weberp.serwices.ObiektService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class MenageObiektController {

    @Autowired
    ObiektService obiektService;
    @Autowired
    InspectorService inspectorService;

    @GetMapping("/allobiektadmin")
    public String index(Model model) {
        Inspector inspector = inspectorService.createEmptyInspector();
        Inspector inspecto2 = inspectorService.createEmptyInspector();

        inspecto2.setName("ewa");
        inspector.setName("Dominik");

        Obiekt obiekt = obiektService.createEmptyObiekt();
        obiekt.setName("Awf");
        Obiekt obiekt1 = obiektService.createEmptyObiekt();
        obiekt1.setName("traalla");
        Obiekt obiekt2 = obiektService.createEmptyObiekt();
        obiekt2.setName("taaaaaa");
        Obiekt obiekt3 = obiektService.createEmptyObiekt();
        obiekt3.setName("witam serdecznie");

        inspectorService.addNewInspecotr(inspector);
        inspectorService.addNewInspecotr(inspecto2);

        obiektService.addNewObject(obiekt);
        obiektService.addNewObject(obiekt1);
        obiektService.addNewObject(obiekt2);
        obiektService.addNewObject(obiekt3);

        Inspector dominik = inspectorService.getInspector(1);

        Inspector ewa = inspectorService.getInspector(2);


        ewa.addObject(obiektService.getObjectById(1));
        ewa.addObject(obiektService.getObjectById(2));
        dominik.addObject(obiektService.getObjectById(3));
        dominik.addObject(obiektService.getObjectById(4));

        inspectorService.addNewInspecotr(dominik);
        inspectorService.addNewInspecotr(ewa);

        obiektService.addNewObject(obiekt);
        obiektService.addNewObject(obiekt1);
        obiektService.addNewObject(obiekt2);
        obiektService.addNewObject(obiekt3);


        List<Obiekt> allObiekt = new ArrayList<>(obiektService.getAllObiekt());
//        List<Inspector> allInspector = new ArrayList<>(obiektService.getAllInspektor(allObiekt));
        model.addAttribute("allobject",allObiekt);
        return "allobiektadmin";
    }

}

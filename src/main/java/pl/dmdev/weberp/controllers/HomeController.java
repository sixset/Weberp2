package pl.dmdev.weberp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {


    @GetMapping("/")
    public String index() {
//        Inspector inspector = new Inspector();
//        inspector.setName("czesc");
//        repo.addInspector(inspector);
//
//        Inspector inspector23 = new Inspector();
//        inspector.setName("dwa");
//        repo.addInspector(inspector23);
//
//        Inspector inspector1 = repo.getId(1);
//        Inspector inspectorZid2 = repo.getId(2);
//        Object object = new Object();
//        object.setName("siemnello");
//
//        Object object1 = new Object();
//        object1.setName("siemnello1");
//
//        Object object2 = new Object();
//        object2.setName("siemnello2");
//
//        Object object3 = new Object();
//        object3.setName("siemnello3");
//
//        Object object4 = new Object();
//        object3.setName("siemnello4");
//        inspector.addObject(object);
//        inspector.addObject(object1);
//        inspector.addObject(object2);
//        inspector.addObject(object3);
//
//        inspectorZid2.addObject(object4);
//
//        repo.addInspector(inspector1);
//        repo.addInspector(inspectorZid2);
//
//        repo.addObject(object);
//        repo.addObject(object1);
//        repo.addObject(object2);
//        repo.addObject(object3);
//
//        repo.addObject(object4);
//
////        Inspector inspector2 = repo.getId(1);
//        Inspector inspector2 = repo.getId(2);
//        List<Object> allEmploye = inspector2.getObjects();
//        model.addAttribute("employees", allEmploye);
        return "index";
    }




}

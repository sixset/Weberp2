package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.serwices.ObiektService;
import pl.dmdev.weberp.serwices.ShedulesService;
import pl.dmdev.weberp.utils.IdHolder;
import pl.dmdev.weberp.utils.Mounth;
import pl.dmdev.weberp.utils.WorkDay;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    ShedulesService shedulesService;
    @Autowired
    ObiektService obiektService;

    @GetMapping("/inspektor/schedules")
    public String index() {

        return "shedule/schedules";
    }

    @GetMapping("/inspektor/schedules/choose")
    public String setParameter(Model model) {
        List<String> allMounths = new ArrayList<>(shedulesService.getAllMounth());
        List<Obiekt> allInspectorObiekt = new ArrayList<>(shedulesService.getAllInspObiekt());
        model.addAttribute("mounths",allMounths);
        model.addAttribute("allInspectorObiekt",allInspectorObiekt);
        model.addAttribute("obiekt",new Obiekt());
        model.addAttribute("mounthName",new Mounth());
     return "shedule/chooseparameters";
    }


    @RequestMapping(value = "/inspektor/schedules/new/schedule", method = RequestMethod.POST)
    public String getNewSchedules(Model model, Obiekt obiekt,Mounth nameOfMounth) {
        Obiekt obiekFromDb=obiektService.getObjectById(obiekt.getId());
        model.addAttribute("nameOfMounth",nameOfMounth);
        model.addAttribute("obiekt",obiekFromDb);
        return "shedule/newschedule";
    }




}

package pl.dmdev.weberp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.serwices.ShedulesService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {
    @Autowired
    ShedulesService shedulesService;

    @GetMapping("/inspektor/schedules")
    public String index() {

        return "shedule/schedules";
    }

    @GetMapping("/inspektor/schedules/choose")
    public String setMounthObject(Model model) {
        List<String> allMounths = new ArrayList<>(shedulesService.getAllMounth());
        List<Obiekt> allInspectorObiekt = new ArrayList<>(shedulesService.getAllInspObiekt());
        model.addAttribute("mounths",allMounths);
        model.addAttribute("allInspectorObiekt",allInspectorObiekt);
     return "shedule/chooseparameters";
    }

    @GetMapping("/inspektor/schedules/new/schedule")
    public String getNewSchedules(Model model) {
        List<String> listday = new ArrayList<>();
        for (int i = 1; i<=31 ; i++) {
            listday.add(String.valueOf(i));
        }
        model.addAttribute("dayInMounth",listday);
        return "shedule/newschedule";
    }




}

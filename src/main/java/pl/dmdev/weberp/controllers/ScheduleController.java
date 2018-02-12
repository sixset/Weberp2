package pl.dmdev.weberp.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
public class ScheduleController {


    @GetMapping("/inspektor/schedules")
    public String index() {

        return "schedules";
    }

    @GetMapping("/inspektor/schedules/new/schedule")
    public String getNewSchedules(Model model) {
        List<String> listday = new ArrayList<>();
        for (int i = 1; i<=31 ; i++) {
            listday.add(String.valueOf(i));
        }
        model.addAttribute("dayInMounth",listday);
        return "newschedule";
    }




}

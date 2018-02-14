package pl.dmdev.weberp.utils;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class WorkDay {

    private Map<String,Integer> workDayCalendar = new HashMap<>();

    public WorkDay(){
        makeCalendar();
    }

    public void makeCalendar(){
        this.workDayCalendar.put("Styczeń",21);
        this.workDayCalendar.put("Luty",20);
        this.workDayCalendar.put("Marzec",22);
        this.workDayCalendar.put("Kwiecień",20);
        this.workDayCalendar.put("Maj",20);
        this.workDayCalendar.put("Czerwiec",21);
        this.workDayCalendar.put("Lipiec",22);
        this.workDayCalendar.put("Sierpień",22);
        this.workDayCalendar.put("Wrzesień",20);
        this.workDayCalendar.put("Październik",23);
        this.workDayCalendar.put("Listopad",21);
        this.workDayCalendar.put("Grudzień",19);
    }

    public int getHourInMouth(String mounth){
       int day= this.workDayCalendar.get(mounth);
       return day*8;
    }

    public Collection<String> getAllMouths(){
        return this.workDayCalendar.keySet();
    }



    public Map<String, Integer> getWorkDayCalendar() {
        return workDayCalendar;
    }
}

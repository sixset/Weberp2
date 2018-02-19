package pl.dmdev.weberp.domain.model;


import org.springframework.stereotype.Component;
import pl.dmdev.weberp.serwices.ShedulesService;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    private String name;

    private String lastname;

    private String deal;

    private int rate;

    private int pof;

    private int numberoflegit;

    private String sil;

    private String sys;

    private String eko;

    private boolean settlement;


    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "id_inspektor", nullable = true)
    private Inspector inspector;


    @ManyToMany(cascade = {CascadeType.ALL})
    @JoinTable(
            name = "Employee_Scheldue",
            joinColumns = {@JoinColumn(name = "employee_id")},
            inverseJoinColumns = {@JoinColumn(name = "sheldue_id")}
    )
    private Set<Schedule> schedules = new HashSet<>();


    public Employee() {
        settlement = false;
    }

    public Set<Schedule> getSchedules() {
        return schedules;
    }

    public void setSchedules(Set<Schedule> schedules) {
        this.schedules = schedules;
    }

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }


    public boolean isSettlement() {
        return settlement;
    }

    public void setSettlement(boolean settlement) {
        this.settlement = settlement;
    }

    public Employee(int id, String name, String lastname, String deal, int rate, int pof, int numberoflegit, String sil, String sys, String eko) {
        this.name = name;
        this.lastname = lastname;
        this.deal = deal;
        this.rate = rate;
        this.pof = pof;
        this.numberoflegit = numberoflegit;
        this.sil = sil;
        this.eko = eko;
        this.sys = sys;
        this.id = id;
    }


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
    }

    public int getRate() {
        return rate;
    }

    public void setRate(int rate) {
        this.rate = rate;
    }

    public int getPof() {
        return pof;
    }

    public void setPof(int pof) {
        this.pof = pof;
    }

    public int getNumberoflegit() {
        return numberoflegit;
    }

    public void setNumberoflegit(int numberoflegit) {
        this.numberoflegit = numberoflegit;
    }

    public String getSil() {
        return sil;
    }

    public void setSil(String sil) {
        this.sil = sil;
    }

    public String getSys() {
        return sys;
    }

    public void setSys(String sys) {
        this.sys = sys;
    }

    public String getEko() {
        return eko;
    }

    public void setEko(String eko) {
        this.eko = eko;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastname='" + lastname + '\'' +
                ", deal='" + deal + '\'' +
                ", rate=" + rate +
                ", pof=" + pof +
                ", numberoflegit=" + numberoflegit +
                ", sil='" + sil + '\'' +
                ", sys='" + sys + '\'' +
                ", eko='" + eko + '\'' +
                '}';
    }
}

package pl.dmdev.weberp.domain;


import org.springframework.stereotype.Component;

@Component
public class Employee {


    private int id;
    private String name;
    private String lastname;
    private String deal;
    private String rate;
    private int pof;
    private int numberlegit;



    public Employee(){
    }

    public Employee(int id,String name, String lastname, String deal, String rate, int pof, int numberlegit) {
        this.name = name;
        this.lastname = lastname;
        this.deal = deal;
        this.rate = rate;
        this.pof = pof;
        this.numberlegit = numberlegit;
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

    public String getRate() {
        return rate;
    }

    public void setRate(String rate) {
        this.rate = rate;
    }

    public int getPof() {
        return pof;
    }

    public void setPof(int pof) {
        this.pof = pof;
    }

    public int getNumberlegit() {
        return numberlegit;
    }

    public void setNumberlegit(int numberlegit) {
        this.numberlegit = numberlegit;
    }
}

package pl.dmdev.weberp.domain;


import org.springframework.stereotype.Component;

@Component
public class Employee {


    private int id;
    private String name;
    private String lastname;
    private String deal;
    private String rate;
    private String sil;
    private String sys;
    private String eko;

    @Override
    public String toString() {
        return "Employee{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", lastName='" + lastname + '\'' +
                ", deal='" + deal + '\'' +
                ", rate='" + rate + '\'' +
                ", sil='" + sil + '\'' +
                ", sys='" + sys + '\'' +
                ", eko='" + eko + '\'' +
                '}';
    }

    public Employee(){
    }

    public Employee(int id,String name, String lastname, String deal, String rate, String sil, String sys, String eko) {
        this.name = name;
        this.lastname = lastname;
        this.deal = deal;
        this.rate = rate;
        this.sil = sil;
        this.sys = sys;
        this.eko = eko;
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
}

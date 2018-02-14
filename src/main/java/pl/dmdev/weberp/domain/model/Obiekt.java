package pl.dmdev.weberp.domain.model;

import javax.persistence.*;

@Entity
public class Obiekt {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id",updatable = false,nullable = false)
    private int id;
    private String name;
    private String adres;

    @ManyToOne(cascade = CascadeType.DETACH)
    @JoinColumn(name = "id_inspektor")
    private Inspector inspector;

    public Obiekt(){

    }

    public Obiekt(String name, String adres) {
        this.name = name;
        this.adres = adres;
    }

    public String getAdres() {
        return adres;
    }

    public void setAdres(String adres) {
        this.adres = adres;
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

    public Inspector getInspector() {
        return inspector;
    }

    public void setInspector(Inspector inspector) {
        this.inspector = inspector;
    }
}

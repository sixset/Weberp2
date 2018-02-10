package pl.dmdev.weberp.domain;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Inspector extends User{


    @OneToMany(cascade = CascadeType.ALL,mappedBy = "inspector")
    private List<Obiekt> objects = new ArrayList<Obiekt>();

    public Inspector(){
    }

    public List<Obiekt> getObjects() {
        return objects;
    }

    public void addObject(Obiekt obiekt){
        this.objects.add(obiekt);
        obiekt.setInspector(this);
    }


    public void setObjects(List<Obiekt> objects) {
        this.objects = objects;
    }
}

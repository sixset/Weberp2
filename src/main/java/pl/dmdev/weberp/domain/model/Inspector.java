package pl.dmdev.weberp.domain.model;

import javax.persistence.*;
import java.util.*;

@Entity
public class Inspector extends User{


    @OneToMany(cascade = CascadeType.ALL,
            fetch = FetchType.LAZY,mappedBy = "inspector")
    private Set<Obiekt> objects=  new HashSet<Obiekt>();

    public Inspector(){
    }

    public Set<Obiekt> getObjects() {
        return objects;
    }

    public void setObjects(Set<Obiekt> objects) {
        this.objects = objects;
    }

    public void addObject(Obiekt obiekt){
        this.objects.add(obiekt);
        obiekt.setInspector(this);
    }

    public void removeChild(Obiekt obiekt){
        this.objects.remove(obiekt);
    }

}

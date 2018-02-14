package pl.dmdev.weberp.domain.model;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
public class Inspector extends User{


    @OneToMany(orphanRemoval=true,cascade = CascadeType.ALL,mappedBy = "inspector")
    private Set<Obiekt> objects;

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



}

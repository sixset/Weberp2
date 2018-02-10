package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmdev.weberp.domain.Inspector;
import pl.dmdev.weberp.domain.Obiekt;
import pl.dmdev.weberp.domain.repository.ObiektRepository;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ObiektService {

    @Autowired
    ObiektRepository obiektRepository;

    @Autowired
    InspectorService inspectorService;

    public Collection<Obiekt> getAllObiekt() {
        return obiektRepository.getAllObiekt();
    }


    public Obiekt createEmptyObiekt() {
        return new Obiekt();
    }

    public void addNewObjectDB(Obiekt obiekt) {

        obiektRepository.addNewObiekt(obiekt);
    }

    public Obiekt getObjectById(int id) {
        return obiektRepository.getInspecotrById(id);
    }

    public void createnEewObject(int idInspecotr , Obiekt obiekt){
       Inspector inspector= inspectorService.getInspector(idInspecotr);
       inspector.addObject(obiekt);
       inspectorService.mergeInspector(inspector);

    }
}

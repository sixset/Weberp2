package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.domain.repository.ObiektRepository;

import java.util.Collection;

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
        return obiektRepository.getObiektById(id);
    }

    public void createnEewObject(int idInspecotr , Obiekt obiekt){
       Inspector inspector= inspectorService.getInspector(idInspecotr);
       inspector.addObject(obiekt);
       inspectorService.mergeInspector(inspector);

    }

    public void deleteObject(Integer id) {
        Obiekt obiekt =obiektRepository.getObiektById(id);
        Inspector inspector =obiekt.getInspector();
        inspector.getObjects().remove(obiekt);
        inspectorService.mergeInspector(inspector);
    }
}

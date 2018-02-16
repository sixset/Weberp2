package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.domain.repository.ObiektRepository;
import pl.dmdev.weberp.utils.IdHolder;

import java.util.Collection;

@Service
public class ObiektService {

    @Autowired
    ObiektRepository obiektRepository;

    @Autowired
    InspectorService inspectorService;

    public Collection<Obiekt> getAllObiekt() {
        return obiektRepository.findAll();
    }


    public Obiekt createEmptyObiekt() {
        return new Obiekt();
    }


    public Obiekt getObjectById(int id) {
        return obiektRepository.getOne(id);
    }


    public void deleteObject(Integer id) {
      Obiekt obiekt = getObjectById(id);
      Inspector inspector = obiekt.getInspector();
      inspector.removeChild(obiekt);
      obiektRepository.delete(obiekt);
      inspectorService.mergeInspector(inspector);

    }

    public void addNewObjectDBWithInspecotr(int id, Obiekt obiektFromView) {
        Obiekt newObject = new Obiekt();
        newObject.setName(obiektFromView.getName());
        newObject.setAdres(obiektFromView.getAdres());
        Inspector inspector =inspectorService.getInspector(id);
        inspector.addObject(newObject);
        inspectorService.mergeInspector(inspector);
    }
}

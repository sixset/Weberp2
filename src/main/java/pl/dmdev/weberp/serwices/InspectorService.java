package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.domain.repository.InspectorRepository;

import java.util.Collection;

@Repository
public class InspectorService {
    @Autowired
    InspectorRepository inspectorRepository;

    public Inspector createEmptyInspector() {
        return new Inspector();
    }

    public Collection<Inspector> getAllInspector() {
        return inspectorRepository.getAllInspector();
    }

    public void addNewIncpectorToDB(Inspector inspector) {
        inspectorRepository.addNewInspector(inspector);
    }

    public void mergeInspector(Inspector inspector) {
        inspectorRepository.mergeInspector(inspector);
    }


    public Inspector getInspector(int id) {
        Inspector inspector = inspectorRepository.getInspecotrById(id);
        return inspector;
    }

    public Inspector getInspectorByUsername(String currentPrincipalName) {
        return inspectorRepository.getInspectorByUsername(currentPrincipalName);
    }
}
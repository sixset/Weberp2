package pl.dmdev.weberp.serwices;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.model.Employee;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.domain.repository.EmployeeRepository;
import pl.dmdev.weberp.utils.WorkDay;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Component
public class ShedulesService {

    @Autowired
    InspectorService inspectorService;


    public Collection<String> getAllMounth() {
        WorkDay workDay = new WorkDay();
        return workDay.getAllMouths();
    }

 /*   public Collection <Obiekt> getAllInspObiekt() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String currentPrincipalName = authentication.getName();
        Inspector inspector = inspectorService.getInspectorByUsername(currentPrincipalName);
       return inspector.getObjects();

    }*/
}

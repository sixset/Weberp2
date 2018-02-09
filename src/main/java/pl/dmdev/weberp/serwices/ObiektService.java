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

    public Collection<Obiekt> getAllObiekt() {
        return obiektRepository.getAllObiekt();
    }

    public Collection<Inspector> getAllInspektor() {
        //poprawic na strem
        List<Obiekt> obiektList = new ArrayList<>(obiektRepository.getAllObiekt());
        Collection <Inspector> allInspector = null;
        for (int i = 0; i <obiektList.size() ; i++) {
            allInspector.add(obiektList.get(i).getInspector());
        }
        return allInspector;
    }
}

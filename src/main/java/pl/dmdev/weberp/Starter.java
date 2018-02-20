package pl.dmdev.weberp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.model.Employee;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.domain.model.Obiekt;
import pl.dmdev.weberp.serwices.EmployyeSerwice;
import pl.dmdev.weberp.serwices.InspectorService;
import pl.dmdev.weberp.serwices.ObiektService;
import pl.dmdev.weberp.utils.Role;
import pl.dmdev.weberp.utils.RoleRepository;


@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    InspectorService inspectorService;

    @Autowired
    RoleRepository roleRepository;

    @Autowired
    ObiektService obiektService;

    @Autowired
    EmployyeSerwice employyeSerwice;


    public void run(String... strings) throws Exception {


        Inspector inspector = new Inspector();
        Inspector inspector2 = new Inspector();
        inspector.setUsername("inspektorlogin");
        inspector2.setUsername("dyrektorlogin");
        inspector.setEnabled(true);
        inspector2.setEnabled(true);
        inspector.setPassword("test");
        inspector2.setPassword("test");
        inspector.setName("Inspektor1");
        inspector2.setName("Dyrektor2");
        inspectorService.addNewIncpectorToDB(inspector);
        inspectorService.addNewIncpectorToDB(inspector2);

        Role inspektorRole = new Role();
        inspektorRole.setUsername("inspektorlogin");
        inspektorRole.setRole("INSP");

        Role dyrRole = new Role();
        dyrRole.setUsername("dyrektorlogin");
        dyrRole.setRole("DYR");

        roleRepository.persistRole(inspektorRole);
        roleRepository.persistRole(dyrRole);




    }
}

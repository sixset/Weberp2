package pl.dmdev.weberp;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.model.Inspector;
import pl.dmdev.weberp.serwices.InspectorService;
import pl.dmdev.weberp.utils.Role;
import pl.dmdev.weberp.utils.RoleRepository;


@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    @Autowired
    InspectorService inspectorService;

    @Autowired
    RoleRepository roleRepository;


    public void run(String... strings) throws Exception {
        Inspector inspector = new Inspector();
        Inspector inspector2 = new Inspector();
        inspector.setUsername("User1");
        inspector2.setUsername("User2");
        inspector.setEnabled(true);
        inspector2.setEnabled(true);
        inspector.setPassword("test");
        inspector2.setPassword("test2");
        inspector.setName("Inspektor");
        inspector2.setName("Dyrektor");
        inspectorService.addNewIncpectorToDB(inspector);
        inspectorService.addNewIncpectorToDB(inspector2);

        Role inspektorRole = new Role();
        inspektorRole.setUsername("User1");
            inspektorRole.setRole("INSP");

        Role dyrRole = new Role();
        dyrRole.setUsername("User2");
        dyrRole.setRole("DYR");

        roleRepository.persistRole(inspektorRole);
        roleRepository.persistRole(dyrRole);

    }
}

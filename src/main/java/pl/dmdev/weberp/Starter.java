package pl.dmdev.weberp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.repository.EmployeeRepository;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception {

        employeeRepository.createEmployee(2, "Dominik", "Martyniak", "Etat", "22", "ZUS", "spec", "Ma");
        employeeRepository.createEmployee(3, "Dominik", "Etatowy", "Etat", "22", "COS", "ZUS", null);

        System.out.println(employeeRepository.getAllEmployee());


    }
}

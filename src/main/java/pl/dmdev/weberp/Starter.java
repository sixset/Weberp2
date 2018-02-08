package pl.dmdev.weberp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.Employee;
import pl.dmdev.weberp.repository.EmployeeRepository;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {
    @Autowired
    EmployeeRepository employeeRepository;

    @Override
    public void run(String... strings) throws Exception {





    }
}

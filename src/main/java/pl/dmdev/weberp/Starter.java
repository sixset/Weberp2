package pl.dmdev.weberp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;
import pl.dmdev.weberp.domain.repository.Repo;

@Component
@Scope("singleton")
public class Starter implements CommandLineRunner {

    public void run(String... strings) throws Exception {



    }
}

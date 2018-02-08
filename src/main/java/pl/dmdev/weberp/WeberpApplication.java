package pl.dmdev.weberp;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import pl.dmdev.weberp.domain.Employee;


@SpringBootApplication
public class WeberpApplication {

	public static void main(String[] args) {
		SpringApplication.run(WeberpApplication.class, args);
	}
}

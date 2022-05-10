package adhyayana.brewery_services;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"adhyayana.brewery_services.web.controller", "adhyayana.brewery_services.web.service"})
@EnableJpaRepositories(basePackages = {"adhyayana.brewery_services.web.repositories"})
@EntityScan(basePackages = {"adhyayana.brewery_services.web.model"})
public class BreweryServicesApplication {

	public static void main(String[] args) {
		SpringApplication.run(BreweryServicesApplication.class, args);
	}

}


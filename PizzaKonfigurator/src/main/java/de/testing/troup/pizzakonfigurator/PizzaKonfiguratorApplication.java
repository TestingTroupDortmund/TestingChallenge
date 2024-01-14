package de.testing.troup.pizzakonfigurator;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;

@SpringBootApplication
public class PizzaKonfiguratorApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(PizzaKonfiguratorApplication.class).web(WebApplicationType.SERVLET).run(args);
    }

}

package in.prakharsaxena.lifesparkTech;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {
    "in.prakharsaxena.lifesparkTech",
    "controller",
    "service",
    "security",
    "filter",
    "model",
    "repository"
})
@EntityScan("model")
@EnableMongoRepositories(basePackages = "repository")
public class LifesparkTechApplication {

    public static void main(String[] args) {
        SpringApplication.run(LifesparkTechApplication.class, args);
    }

}


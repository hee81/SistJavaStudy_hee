package boot.thyme.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"data.*"})
@EntityScan("data.dto") //dto
@EnableJpaRepositories("dato.dao") //dao인식
public class SpringbootThymeLeafJpaApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeLeafJpaApplication.class, args);
	}

}

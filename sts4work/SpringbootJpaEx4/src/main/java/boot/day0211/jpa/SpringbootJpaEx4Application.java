package boot.day0211.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"boot.jpa.shop"}) 
@EntityScan("boot.jpa.shop") //dto인식
@EnableJpaRepositories("boot.jpa.shop") //dao인식
public class SpringbootJpaEx4Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaEx4Application.class, args);
	}

}

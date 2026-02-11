package boot.day0211.jpa;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"boot.mycar.data"})
@EntityScan("boot.mycar.data") //dto인식시키기
@EnableJpaRepositories("boot.mycar.data") //dao인식 crud매서드 처리하는곳
public class SpringbootJpaEx3Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaEx3Application.class, args);
	}

}

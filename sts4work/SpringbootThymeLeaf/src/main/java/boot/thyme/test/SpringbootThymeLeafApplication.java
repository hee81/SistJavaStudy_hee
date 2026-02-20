package boot.thyme.test;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan({"data.*"})
public class SpringbootThymeLeafApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootThymeLeafApplication.class, args);
	}

}

package boot.jpa.upload;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan({"boot.board.*"})
@EntityScan("boot.board.data") //*(와일드카드) 사용X
@EnableJpaRepositories("boot.board.data")
public class SpringbootJpaUploadApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootJpaUploadApplication.class, args);
	}

}

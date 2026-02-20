package boot.mybatis.market;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("boot.data.*") //패키지명만 등록
@MapperScan("boot.data.mapper") //inter 스캔 위해서
public class SpringbootMybatisTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringbootMybatisTestApplication.class, args);
	}

}

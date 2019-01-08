package cho.me.springdatabasetry;

import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.jdbc.core.JdbcTemplate;

@SpringBootApplication
public class SpringDatabaseTryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDatabaseTryApplication.class, args);
	}
/*
	@Bean
	public ApplicationRunner applicationRunner(final JdbcTemplate jdbcTemplate){
		return new ApplicationRunner() {
			@Override
			public void run(ApplicationArguments args) throws Exception {
				Integer count = jdbcTemplate.queryForObject("Select count(*) from Customers",Integer.class);
				System.out.println("data.sql insert count : "+count);
			}
		};
	}
	*/


}


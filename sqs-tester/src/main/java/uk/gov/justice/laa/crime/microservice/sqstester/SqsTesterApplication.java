package uk.gov.justice.laa.crime.microservice.sqstester;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class SqsTesterApplication {

	public static void main(String[] args) {
		SpringApplication.run(SqsTesterApplication.class, args);
	}

}

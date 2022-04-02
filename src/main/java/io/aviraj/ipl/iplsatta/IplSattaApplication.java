package io.aviraj.ipl.iplsatta;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;

@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class })
public class IplSattaApplication {

	public static void main(String[] args) {
		SpringApplication.run(IplSattaApplication.class, args);
	}

}

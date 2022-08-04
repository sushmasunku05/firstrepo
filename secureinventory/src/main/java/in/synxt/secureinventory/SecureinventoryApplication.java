package in.synxt.secureinventory;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.PropertySource;

@SpringBootApplication
@EnableEurekaClient
@PropertySource("classpath:application.yml")
public class SecureinventoryApplication {

	public static void main(String[] args) {
		SpringApplication.run(SecureinventoryApplication.class, args);
	}

}

package Capgemini.Assessmnet_API;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;



/**
 * Main methods that start Spring Application
 * Example Rest Call: http://localhost:8080/data?numbers=5,4,6,1
 * @author Christopher Tassone
 *
 */
@SpringBootApplication
public class AssessmnetApiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AssessmnetApiApplication.class, args);
	}

}

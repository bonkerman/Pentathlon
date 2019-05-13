package Pentathlon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import Pentathlon.data.AthleteRepository;
import utils.Reader;


@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
    
    @Bean
    public CommandLineRunner init(AthleteRepository repository) {
    	return (args) ->{
    		Reader.readData(System.getProperty("user.dir")+"\\dataFiles\\Athlete_Results.csv", repository);
    	};
    }

}

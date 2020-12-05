package com.IncidInfo.microIncidInfo;

import com.IncidInfo.microIncidInfo.dao.SolutionRepository;
import com.IncidInfo.microIncidInfo.dao.UserRepository;
import com.IncidInfo.microIncidInfo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.stream.Stream;

@SpringBootApplication
//@EnableSwagger2WebMvc
public class MicroIncidInfoApplication{
	@Autowired
	private SolutionRepository solutionRepository;
	public static void main(String[] args) {
		SpringApplication.run(MicroIncidInfoApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository) {
		return args -> {
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com","0807906590");
				userRepository.save(user);
			});
			userRepository.findAll().forEach(System.out::println);
		};
	}


}

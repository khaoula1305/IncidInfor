package com.IncidInfo.microIncidInfo;

import com.IncidInfo.microIncidInfo.dao.IncidentRepository;
import com.IncidInfo.microIncidInfo.dao.MessageRepository;
import com.IncidInfo.microIncidInfo.dao.SolutionRepository;
import com.IncidInfo.microIncidInfo.dao.UserRepository;
import com.IncidInfo.microIncidInfo.entities.Incident;
import com.IncidInfo.microIncidInfo.entities.Message;
import com.IncidInfo.microIncidInfo.entities.User;
import io.swagger.models.auth.In;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.stream.Stream;

@SpringBootApplication
//@EnableSwagger2WebMvc

@CrossOrigin("*")

public class MicroIncidInfoApplication{
	@Autowired
	private SolutionRepository solutionRepository;
	@Autowired
  private MessageRepository messageRepository;
	@Autowired
  private IncidentRepository incidentRepository;

	public static void main(String[] args) {
		SpringApplication.run(MicroIncidInfoApplication.class, args);
	}
	@Bean
	CommandLineRunner init(UserRepository userRepository , MessageRepository messageRepository) {
		return args -> {
		  //User
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User(name, name.toLowerCase() + "@domain.com","0807906590");
				userRepository.save(user);

			});
			userRepository.findAll().forEach(System.out::println);


      //Message
      Stream.of("Erreur 404","Manque imprimante").forEach(titre-> {
        Message message = new Message();
        message.setTitre(titre);
        message.setRead(false);
        message.setSender("Salwa");
        message.setDescription("Description du message: " + titre.toUpperCase());
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        //message.setDate(dateFormat);
        messageRepository.save(message);
      });
      messageRepository.findAll().forEach(System.out::println);

      //Incident
      Stream.of("Erreur 404","Manque imprimante").forEach(nom-> {
        Incident incident = new Incident();
        incident.setNom(nom);
        incident.setDesc("Description du message: " + nom.toUpperCase());
        incident.setDate("2020-08-12");
        incident.setResolue(false);
        incidentRepository.save(incident);
      });
      incidentRepository.findAll().forEach(System.out::println);

		};



	}


}

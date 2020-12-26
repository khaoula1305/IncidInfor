package com.IncidInfo.microIncidInfo;

import com.IncidInfo.microIncidInfo.dao.IncidentRepository;
import com.IncidInfo.microIncidInfo.dao.MessageRepository;
import com.IncidInfo.microIncidInfo.dao.UserRepository;
import com.IncidInfo.microIncidInfo.entities.Incident;
import com.IncidInfo.microIncidInfo.entities.Message;
import com.IncidInfo.microIncidInfo.entities.User;

import org.hibernate.mapping.Set;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.web.bind.annotation.CrossOrigin;

import java.util.Collections;

@SpringBootApplication
@CrossOrigin("*")

public class MicroIncidInfoApplication {
  @Autowired
  private MessageRepository messageRepository;
  @Autowired
  private IncidentRepository incidentRepository;
  @Autowired
  private RepositoryRestConfiguration restConfiguration;



  public static void main(String[] args) {
    SpringApplication.run(MicroIncidInfoApplication.class, args);
  }

  @Bean
  CommandLineRunner init(UserRepository userRepository, MessageRepository messageRepository, IncidentRepository incidentRepository) {
    return args -> {

      //User
      restConfiguration.exposeIdsFor(User.class);
      userRepository.save(new User(1L,
              "Mourad Fadil",
              "fadidmourad@gmail.com",
              "mourad123",
              "Administrateur",
              null,
              "Administrateur"));
      userRepository.save(new User(2L,
              "Khaoula Benchari",
              "bencharikhaoula@gmail.com",
              "khaoula123",
              "Technicien",
              "Réseaux",
              "Ingénieur de réseaux"));
      userRepository.save(new User(3L,
              "Amal Zugari",
              "zugariamal@gmail.com",
              "amal123",
              "Helpdesk",
              null,
              "Membre de l'équipe Helpdesk"));

      userRepository.save(new User(4L,
              "Fairouz El Boualaoui",
              "elboualaouifairouz@gmail.com",
              "fairouz123",
              "Manager",
              "Réseaux",
              "Manager réseaux"));
      userRepository.save( new User(5L,
              "Salwa Batah",
              "batahsalwa@gmail.com",
              "salwa123",
              "Collaborateur",
              null,
              "responsable RH"));
      userRepository.save(new User(6L,
              "demo",
              "demo@gmail.com",
              "demo",
              "Technicien",
              "BDD",
              "Technicien"));
      //userRepository.findAll().forEach(System.out::println);

      //Message
      restConfiguration.exposeIdsFor(Message.class);
      messageRepository.save( new Message(1L,
              "Salwa Batah",
              "Amal Zugari",
              "Erreur 404",
              Collections.singleton(new String("Je n'arrive pas à acceder au serveur, on me donne une page blanche contenant le message Erreur 404. ")),
              false,
              false,
              null,
              "2020/10/12 09:17"));
      messageRepository.save(new Message(2L,
              "Amal Zugari",
              "Fairouz El Boualaoui",
              "Page Bleu Windows",
              Collections.singleton(new String("Je n'arrive pas à acceder au serveur, on me donne une page blanche contenant le message Erreur 404. ")),
              false,
              false,
              null,
              "2020/10/28 16:49"));
      Message message3 = new Message(3L,
              "Fairouz El Boualaoui",
              "Khaoula Benchari",
              "Erreur 404 dans le serveur",
              Collections.singleton(new String("Je n'arrive pas à acceder au serveur, on me donne une page blanche contenant le message Erreur 404. ")),
              false,
              false,
              "Réseau",
              "2020/10/28 16:59");
      messageRepository.save(message3);
      Message message4 = new Message(4L,
              "Khaoula Benchari",
              "Fairouz El Boualaoui",
              "Erreur 404 dans le serveur",
              Collections.singleton(new String("Je n'arrive pas à acceder au serveur, on me donne une page blanche contenant le message Erreur 404. ")),
              false,
              true,
              "Réseau",
              "2020/10/28 17:11");
      messageRepository.save(message4);

      messageRepository.save(new Message(4L,
              "Khaoula Benchari",
              "Amal Zugari",
              "Erreur 404 dans le serveur",
              Collections.singleton(new String("Je n'arrive pas à acceder au serveur, on me donne une page blanche contenant le message Erreur 404. ")),
              false,
              true,
              "Réseau",
              "2020/10/28 17:11"));
     // Message message5 = new Message(5L,"Helpdesk","Salwa Batah","Erreur 404 dans le serveur","Bonjour, votre porblème est entrain d'être traiter. Merci ",false,true,"Réseau","2020/10/28 18:11");
     // messageRepository.save(message5);
      //messageRepository.findAll().forEach(System.out::println);

      //Incident
      restConfiguration.exposeIdsFor(Incident.class);
      Incident incident2 = new Incident(2L,"Batah Salwa", "Page Bleu", "2020/10/21 12:13","La plateforme des admins est inaccessible", "Résaux", null,false,null);
      incidentRepository.save(incident2);
      Incident incident3 = new Incident(1L,"Batah Salwa", "Port inaccessible dans le serveur", "2020/10/28 09:28","Le port 9898 est déjà pris", "Résaux", "Khaoula Benchari",true,"Puisque le port est fermé, il suffit de l'ouvrir et donner le droit d'accés aux utilisateurs concernés");
      incidentRepository.save(incident3);
      incidentRepository.save(new Incident(3L,"Batah Salwa", "Erreur 404", "2020/10/28 16:59","La plateforme des admins est inaccessible ", "Résaux", null,false,null));
      incidentRepository.save(new Incident(4L,"Benchari", "Erreur 404", "2020/10/28 16:59","La plateforme des admins est inaccessible ", "Résaux", null,false,null));
      incidentRepository.save(new Incident(5L,"ZUGARI", "Les coordonnées incorrectes", "2020/10/28 16:59","La plateforme des stagiaires est inaccessible ", "Résaux", null,true,"Création un compte utilisateur "));


     // incidentRepository.findAll().forEach(System.out::println);
    };
  }
}

	/*@Bean
=======
	public static void main(String[] args) {
		SpringApplication.run(MicroIncidInfoApplication.class, args);
	}

	@Bean
>>>>>>> d090b4bedde52f42a94650800addafab861476ee
	CommandLineRunner init(UserRepository userRepository , MessageRepository messageRepository, IncidentRepository incidentRepository) {
		return args -> {
		  //User
			Stream.of("John", "Julie", "Jennifer", "Helen", "Rachel").forEach(name -> {
				User user = new User();
				user.setNom(name);
				user.setEmail(name+"@gmail.com");
				user.setPassword(name+"123"); // To hash after with SpringSecurity
        user.setTypeCompte("Collaborateur");
				userRepository.save(user);

			});
			userRepository.findAll().forEach(System.out::println);


      //Message
      Stream.of("Erreur 404","Manque imprimante").forEach(titre-> {
        Message message = new Message();
        message.setTitre(titre);
        message.setRead(false);
        message.setSender("Salwa");
        message.setReciever("Helpdesk");
        message.setDescription("Description du message: : Description du message:Description du message:Description du message:: Description du message:Description du message:Description du message:Description du message:Description du messageDescription du message:Description du message" + titre.toUpperCase());
        //Date
        Date currentDate = new Date();
        String dateToStr = DateFormat.getInstance().format(currentDate); //Date Format using getInstance(): 31/3/15 2:37 PM
        //DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
        message.setDate(dateToStr);
        messageRepository.save(message);
      });
      messageRepository.findAll().forEach(System.out::println);

      //Incident
      Stream.of("Erreur 404","Manque imprimante").forEach(nom-> {
        Incident incident = new Incident();
        incident.setTitre(nom);
        incident.setDescription("Description du message: " + nom.toUpperCase());
        incident.setDate("2020-08-12");
        incident.setResolue(false);
        incidentRepository.save(incident);
      });
      incidentRepository.findAll().forEach(System.out::println);

		};

	}

}*/

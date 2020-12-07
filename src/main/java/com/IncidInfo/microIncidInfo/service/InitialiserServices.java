package com.IncidInfo.microIncidInfo.service;

import com.IncidInfo.microIncidInfo.dao.MessageRepository;
import com.IncidInfo.microIncidInfo.entities.Message;
import com.IncidInfo.microIncidInfo.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.stream.Stream;

@Service
public class InitialiserServices implements InitServices {

  @Autowired
  private MessageRepository messageRepository;

  @Override
  public void initMessage() {
    Stream.of("Erreur 404","Manque imprimante").forEach(titre->{
      Message message = new Message();
      message.setTitre(titre);
      message.setRead(false);
      message.setSender("Salwa");
      message.setDescription("Description du message: "+ titre.toUpperCase());
      DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy HH:mm:ss");
      message.setDate(dateFormat);
      messageRepository.save(message);
    });
  }
}

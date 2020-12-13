package com.IncidInfo.microIncidInfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;
import java.text.DateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;
import java.util.Date;
import java.util.Locale;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Message {

  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 30)
  private String sender;
  private String reciever;
  private String titre;
  @Column(length = 5000)
  private String description;
  private boolean traite; // message traité par une personne de Helpdesk ou non
  private boolean read;
  private String division;
  //@Temporal(TemporalType.TIMESTAMP)
  private String date;

}

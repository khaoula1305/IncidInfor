package com.IncidInfo.microIncidInfo.entities;

import com.fasterxml.jackson.annotation.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import static javax.persistence.FetchType.EAGER;


@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
//@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "id")
public class Message {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  @Column(length = 30)
  private String sender;
  private String receiver;
  private String titre;
  @Column(length = 5000)
  /*
  @ElementCollection(fetch=EAGER)
  private Set<String> responses = new HashSet();*/
  private String response;
  private boolean traite; // message traité par une personne de Helpdesk ou non
  private boolean read;
  private String division;
  //@Temporal(TemporalType.TIMESTAMP)
  private String date;
  private Long previous;
  private Long next;
  /*@ManyToOne(fetch = FetchType.LAZY)
  Message parent;
  @OneToMany(mappedBy = "parent", fetch = FetchType.LAZY)
  private List<Message> children =new ArrayList<>();

  public Message(Long id, String sender, String receiver, String titre, String response, boolean traite, boolean read, String division, String date) {
    this.id = id;
    this.sender = sender;
    this.receiver = receiver;
    this.titre = titre;
    this.response = response;
    this.traite = traite;
    this.read = read;
    this.division = division;
    this.date = date;
    this.children =new ArrayList<>();
  }*/
}

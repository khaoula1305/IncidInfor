package com.IncidInfo.microIncidInfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

//@JsonIgnoreProperties(value = {"resolue", "id"}) filtrage statique
//@JsonFilter("monFiltreDynamique") //ce Bean accepte un filtre
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString

public class Incident  {

  @Id  @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String collaborateur;
    @Length(min=3, max=20)
    private String titre;
    private String date;
    private String description;
    private String division;
    private String affectedto; // nom technicien qui le traite et qui la resolue a la fin
    private boolean resolue=false;



  /*public Incident() {
  }

  public Incident(int id, String nom, String date, String desc) {
    this.id = id;
    this.nom = nom;
    this.date = date;
    this.desc = desc;
    resolue=false;
  }*/
/*
  public int getId() {
    return id;
  }

  public String getNom() {
    return nom;
  }

  public String getDate() {
    return date;
  }

  public String getDesc() {
    return desc;
  }

    public boolean getResolue() {
    return resolue;
  }


  public void setId(int id) {
    this.id = id;
  }

  public void setNom(String nom) {
    this.nom = nom;
  }

  public void setDate(String date) {
    this.date = date;
  }

  public void setDesc(String desc) {
    this.desc = desc;
  }
    public void setResolue(boolean resolue) {
    this.resolue = resolue;
  }


  @Override
  public String toString() {
    return "Incident{" +
      "id=" + id +
      ", nom='" + nom + '\'' +
      ", date='" + date + '\'' +
      ", desc='" + desc + '\'' +
      ", resolue='" + resolue + '\'' +
      '}';
  }*/
}

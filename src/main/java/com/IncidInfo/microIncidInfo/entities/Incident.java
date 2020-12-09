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
    private Long id;
    private String collaborateur;
    @Length(min=3, max=20)
    private String titre;
    private String date;
    private String description;
    private String division;
    private String affectedto; // nom technicien qui le traite et qui la resolue a la fin
    private boolean resolue=false;
}

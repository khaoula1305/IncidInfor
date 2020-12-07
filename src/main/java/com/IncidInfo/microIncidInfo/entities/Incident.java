package com.IncidInfo.microIncidInfo.entities;

import org.hibernate.validator.constraints.Length;

import javax.persistence.*;

//@JsonIgnoreProperties(value = {"resolue", "id"}) filtrage statique
//@JsonFilter("monFiltreDynamique") //ce Bean accepte un filtre
@Entity
public class Incident  {
    @Id
    @GeneratedValue
    private int id;
    @Length(min=3, max=20)
    private String nom;
    private String date;
    private String desc;
    //@JsonIgnore
    private boolean resolue;

    public boolean isResolue() {
        return resolue;
    }

    public void setResolue(boolean resolue) {
        this.resolue = resolue;
    }

    public Incident() {
    }

    public Incident(int id, String nom, String date, String desc) {
        this.id = id;
        this.nom = nom;
        this.date = date;
        this.desc = desc;
        resolue=false;
    }

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

    @Override
    public String toString() {
        return "Incident{" +
                "id=" + id +
                ", nom='" + nom + '\'' +
                ", date='" + date + '\'' +
                ", desc='" + desc + '\'' +
                ", resolue='" + resolue + '\'' +
                '}';
    }
}

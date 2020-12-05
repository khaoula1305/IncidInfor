package com.IncidInfo.microIncidInfo.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;


@AllArgsConstructor
@Data //getters & setters
@ToString
@Entity
public class Solution implements Serializable {
    @Id  @GeneratedValue
    private Long id;
    private String nom;
    private String desc;
}

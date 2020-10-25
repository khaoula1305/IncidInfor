package com.IncidInfo.microIncidInfo.dao;

import com.IncidInfo.microIncidInfo.model.Incident;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IncidentDao extends JpaRepository<Incident, Integer> {
     Incident findById(int id); //renvoie un produit par son Id ;

     void delete(Incident incident);
     // List<Incident> findByPrixGreaterThan(int prixLimit);

}

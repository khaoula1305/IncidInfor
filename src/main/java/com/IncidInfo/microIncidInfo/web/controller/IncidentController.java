package com.IncidInfo.microIncidInfo.web.controller;
import com.IncidInfo.microIncidInfo.dao.IncidentDao;
import com.IncidInfo.microIncidInfo.dao.IncidentRepository;
import com.IncidInfo.microIncidInfo.entities.Incident;
import com.IncidInfo.microIncidInfo.entities.Incident;
import com.IncidInfo.microIncidInfo.web.exceptions.IncidentIntrouvableException;
import com.fasterxml.jackson.databind.ser.FilterProvider;
import com.fasterxml.jackson.databind.ser.impl.SimpleBeanPropertyFilter;
import com.fasterxml.jackson.databind.ser.impl.SimpleFilterProvider;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.json.MappingJacksonValue;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@Api( "API pour les opérations CRUD sur les incidents.")
@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {

    // standard constructors

    private final IncidentRepository incidentRepository;

    public IncidentController(IncidentRepository incidentRepository) {
        this.incidentRepository = incidentRepository;
    }

    @GetMapping("/incidents")
    public List<Incident> getIncidents() {
        return (List<Incident>) incidentRepository.findAll();
    }

    @PostMapping("/incidents")
    void addIncident(@RequestBody Incident incident) {
        incidentRepository.save(incident);
    }
}
/*
@CrossOrigin(origins = "http://localhost:4200")
public class IncidentController {
    @Autowired
    private IncidentDao incidentDao ;

    @RequestMapping(value="/Incidents", method= RequestMethod.GET)
    public MappingJacksonValue listeIncidents() {
        Iterable<Incident> incidents= incidentDao.findAll();

        SimpleBeanPropertyFilter monFiltre = SimpleBeanPropertyFilter.serializeAllExcept("resolue","id");

        FilterProvider listDeNosFiltres = new SimpleFilterProvider().addFilter("monFiltreDynamique", monFiltre);

        MappingJacksonValue incidentsFiltres = new MappingJacksonValue(incidents);

        incidentsFiltres.setFilters(listDeNosFiltres);

        return incidentsFiltres;

    }
    @ApiOperation(value = "Récupère un incident grâce à son ID à condition que celui-ci soit renseigné!")
    @GetMapping(value = "/Incidents/{id}")
    public Incident afficherUnIncident(@PathVariable int id) throws IncidentIntrouvableException {
        Incident incident=incidentDao.findById(id);
        if(incident==null) throw new IncidentIntrouvableException("L'incident avec l'id " + id + " est INTROUVABLE.");
        return incident;
    }

   @PostMapping(value = "/Incidents")
    public ResponseEntity<Void> ajouterProduit(@Valid @RequestBody Incident product) {
        Incident incident=incidentDao.save(product);
        if(incident==null)
            return ResponseEntity.noContent().build();
        URI location = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(incident.getId())
                .toUri();
        return ResponseEntity.created(location).build();
    }
    @DeleteMapping (value = "/Incidents/{id}")
     public void supprimerProduit(@PathVariable int id) {
        incidentDao.deleteById(id);
  }
    @PutMapping (value = "/Incidents")
    public void updateProduit(@RequestBody Incident incident) {

        incidentDao.save(incident);
    }

    }*/


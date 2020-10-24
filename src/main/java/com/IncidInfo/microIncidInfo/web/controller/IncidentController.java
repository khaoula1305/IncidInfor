package com.IncidInfo.microIncidInfo.web.controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class IncidentController {
    @RequestMapping(value="/Incidents", method= RequestMethod.GET)
    public String listeProduits() {
        return "Il va y a voir des incidents ici";
    }
    }

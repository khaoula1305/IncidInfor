package com.IncidInfo.microIncidInfo.dao;

import com.IncidInfo.microIncidInfo.entities.Incident;
import com.IncidInfo.microIncidInfo.entities.Incident;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;

<<<<<<< HEAD
@RepositoryRestResource(collectionResourceRel = "incidents", path = "incidents")
=======
import java.util.List;

@RepositoryRestResource
>>>>>>> eae2d2814897a551a2bc2615430d6b792b4c61e1
@CrossOrigin("*")
public interface IncidentRepository extends CrudRepository<Incident, Long> {

    //Interface Technicien
    @RestResource(path = "byDescription")
    public List<Incident> findByDescriptionContains(@Param("motcle") String des);//search/byDescription?motcle=eee

    //search/byDescriptionPage?motcle=eee&page=0&size=2
    @RestResource(path = "byDescriptionPage")
    public Page<Incident> findByDescriptionContains(@Param("motcle") String des, Pageable pageable);


}

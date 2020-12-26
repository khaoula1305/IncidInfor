package com.IncidInfo.microIncidInfo.dao;

import com.IncidInfo.microIncidInfo.entities.Message;
import com.IncidInfo.microIncidInfo.entities.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Set;

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
@CrossOrigin("*")
public interface MessageRepository extends CrudRepository<Message, Long> {


    //Interface Technicien
    @RestResource(path = "byTitre")
    public List<Message> findByTitreContains(@Param("motcle") String des);//search/byTitre?motcle=eee

    //search/byTitrePage?motcle=eee&page=0&size=2
    @RestResource(path = "byTitrePage")
    public Page<Message> findByTitreContains(@Param("motcle") String des, Pageable pageable);


    //void addResponse(Set<String> responses);
}

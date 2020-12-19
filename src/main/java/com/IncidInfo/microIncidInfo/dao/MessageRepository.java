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

@RepositoryRestResource(collectionResourceRel = "messages", path = "messages")
@CrossOrigin("*")
public interface MessageRepository extends CrudRepository<Message, Long> {


    //Interface Technicien
    @RestResource(path = "byDescription")
    public List<Message> findByDescriptionContains(@Param("motcle") String des);//search/byDescription?motcle=eee

    //search/byDescriptionPage?motcle=eee&page=0&size=2
    @RestResource(path = "byDescriptionPage")
    public Page<Message> findByDescriptionContains(@Param("motcle") String des, Pageable pageable);

}

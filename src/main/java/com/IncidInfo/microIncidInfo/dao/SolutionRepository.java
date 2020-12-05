package com.IncidInfo.microIncidInfo.dao;

import com.IncidInfo.microIncidInfo.entities.Solution;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource
public interface SolutionRepository extends JpaRepository<Solution,Long> {

}

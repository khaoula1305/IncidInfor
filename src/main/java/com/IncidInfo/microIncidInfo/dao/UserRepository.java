package com.IncidInfo.microIncidInfo.dao;

import com.IncidInfo.microIncidInfo.entities.User;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository  extends CrudRepository<User, Long> {}

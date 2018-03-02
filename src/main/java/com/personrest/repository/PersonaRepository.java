package com.personrest.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.transaction.annotation.Transactional;
import com.personrest.entities.Persona;

@Transactional("transactionManager")
public interface PersonaRepository  extends JpaRepository<Persona, Integer>{

}

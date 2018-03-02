package com.personrest.services;

import java.util.List;
import com.personrest.entities.Persona;

public interface PersonaService {
	
	public List<Persona> getPersonas();
	
	public Persona getPersona(Integer personaId);
	
	public Persona savePersona(Persona persona);
	
	public Persona updatePersona(Integer personaId, Persona persona);
	
	public Persona deletePersona(Integer personaId);

}

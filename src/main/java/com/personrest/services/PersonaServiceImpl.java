package com.personrest.services;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.personrest.entities.Persona;
import com.personrest.repository.PersonaRepository;

@Service
public class PersonaServiceImpl implements PersonaService {

	@Autowired
	private PersonaRepository personaRepository;
	
	@Override
	public List<Persona> getPersonas() {
		return personaRepository.findAll();
	}

	@Override
	public Persona getPersona(Integer personaId) {
		return personaRepository.findOne(personaId);
	}

	@Override
	public Persona savePersona(Persona persona) {
		return personaRepository.save(persona);
	}

	@Override
	public Persona updatePersona(Integer personaId, Persona persona) {
		Persona p = personaRepository.findOne(personaId);
		
		if (p != null) {
			p.setNombres(persona.getApellidos());
			p.setApellidos(persona.getApellidos());
			personaRepository.save(p);
		}
		
		return p;
	}

	@Override
	public Persona deletePersona(Integer personaId) {
		Persona p = personaRepository.findOne(personaId);
		
		if (p != null)
			personaRepository.delete(personaId);
		
		return p;
	}
}

package com.personrest.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import com.personrest.entities.Persona;
import com.personrest.services.PersonaService;

@RestController
@RequestMapping("/api/v1")
public class PersonaController {

	@Autowired
	private PersonaService personaService;
	
	@RequestMapping(value = "/personas", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<List<Persona>> getPersonas() {
		return new ResponseEntity<>(personaService.getPersonas(), HttpStatus.OK);
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.GET, produces = "application/json")
	public ResponseEntity<?> getPersona(@PathVariable Integer id) {
		Persona p = personaService.getPersona(id);
		if (p != null) 
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/personas", method = RequestMethod.POST, consumes = "application/json")
	public ResponseEntity<?> savePersona(@Valid @RequestBody Persona persona) {
		Persona p = personaService.savePersona(persona);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>("Error al guardar los datos", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.PUT , consumes = "application/json")
	public ResponseEntity<?> updatePersona(@PathVariable Integer id, @Valid @RequestBody Persona persona) {
		Persona p = personaService.updatePersona(id, persona);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
	}
	
	@RequestMapping(value = "/personas/{id}", method = RequestMethod.DELETE, consumes = "application/json")
	public ResponseEntity<?> deletePersona(@PathVariable Integer id) {
		Persona p = personaService.deletePersona(id);
		if (p != null)
			return new ResponseEntity<>(p, HttpStatus.OK);
		else
			return new ResponseEntity<>("Persona no encontrada", HttpStatus.NOT_FOUND);
	}
}

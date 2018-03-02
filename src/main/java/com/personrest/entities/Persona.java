package com.personrest.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.GenericGenerator;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

@Entity
@Table(name = "personas")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Persona implements java.io.Serializable {
	
	private static final long serialVersionUID = 3935129167691857216L;
	@Id @GenericGenerator(name="idgen" , strategy="increment")
	@GeneratedValue(generator="idgen")
	@Column(name="persona_id", nullable = false, updatable = false)
	private Integer personaId;
	@NotNull
	private String nombres;
	@NotNull
	private String apellidos;
	
	public Persona() {
		super();
	}

	public Persona(Integer personaId, String nombres, String apellidos) {
		super();
		this.personaId = personaId;
		this.nombres = nombres;
		this.apellidos = apellidos;
	}
	 @JsonProperty
	public Integer getPersonaId() {
		return personaId;
	}

	public void setPersonaId(Integer personaId) {
		this.personaId = personaId;
	}
	 @JsonProperty
	public String getNombres() {
		return nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}
	 @JsonProperty
	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}
}

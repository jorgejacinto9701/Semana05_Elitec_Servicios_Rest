package com.empresa.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
@Table(name = "ubigeo")
public class Ubigeo {
	
	@Id
	private int idUbigeo;
	private String departamento;
	private String provincia;
	private String distrito;

	
}

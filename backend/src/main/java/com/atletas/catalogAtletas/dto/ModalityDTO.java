package com.atletas.catalogAtletas.dto;

import java.io.Serializable;

import com.atletas.catalogAtletas.entities.Modality;



public class ModalityDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;

	public ModalityDTO() {

	}

	public ModalityDTO(Long id, String name) {
		this.id = id;
		this.name = name;
	}

	public ModalityDTO(Modality entity) {
		this.id = entity.getId();
		this.name = entity.getName();
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

}


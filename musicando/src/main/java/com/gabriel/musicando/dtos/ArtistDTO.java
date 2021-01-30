package com.gabriel.musicando.dtos;

import com.gabriel.musicando.entities.Artist;

import java.io.Serializable;

public class ArtistDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private String nationality;


	public ArtistDTO() {
	}

	public ArtistDTO(Artist entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.nationality = entity.getNationality();
	}

	public Long getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}
}

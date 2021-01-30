package com.gabriel.musicando.dtos;

import com.gabriel.musicando.entities.Album;

import java.io.Serializable;
import java.time.Instant;

public class AlbumDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Instant releaseDate;
	private Integer duration;

	public AlbumDTO() {
	}

	public AlbumDTO(Album entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.releaseDate = entity.getReleaseDate();
		this.duration = entity.getDuration();
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

	public Instant getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Instant releaseDate) {
		this.releaseDate = releaseDate;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}

package com.gabriel.musicando.dtos;

import com.gabriel.musicando.entities.Music;

import java.io.Serializable;
import java.time.Instant;

public class MusicDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private Instant releaseDate;
	private String name;
	private Integer duration;

	public MusicDTO() {
	}

	public MusicDTO(Music entity) {
		this.id = entity.getId();
		this.releaseDate = entity.getReleaseDate();
		this.name = entity.getName();
		this.duration = entity.getDuration();
	}

	public Long getId() {
		return id;
	}

	public Instant getReleaseDate() {
		return releaseDate;
	}

	public void setReleaseDate(Instant releaseDate) {
		this.releaseDate = releaseDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getDuration() {
		return duration;
	}

	public void setDuration(Integer duration) {
		this.duration = duration;
	}
}

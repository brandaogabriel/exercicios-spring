package com.gabriel.musicando.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_music")
public class Music implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant releaseDate;

	@ManyToMany
	@JoinTable(name = "tb_music_interpreters", joinColumns = @JoinColumn(name = "music_id"),
	  inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private Set<Artist> interpreters = new HashSet<>();

	private String name;
	private Integer duration;

	public Music() {
	}

	public Music(Instant releaseDate, String name, Integer duration) {
		this.releaseDate = releaseDate;
		this.name = name;
		this.duration = duration;
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

	public Set<Artist> getInterpreters() {
		return interpreters;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Music music = (Music) o;
		return Objects.equals(id, music.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

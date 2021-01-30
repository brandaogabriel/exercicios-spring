package com.gabriel.musicando.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_artist")
public class Artist implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant createdAt;

	@Column(columnDefinition = "TIMESTAMP WITHOUT TIME ZONE")
	private Instant updatedAt;

	@ManyToMany(mappedBy = "interpreters")
	private Set<Music> interpretedMusics = new HashSet<>();

	@ManyToMany(mappedBy = "authors")
	private Set<Music> musicsAsAuthor = new HashSet<>();

	@ManyToMany(mappedBy = "participants")
	private Set<Album> albums = new HashSet<>();

	private String name;
	private String nationality;


	public Artist() {
	}

	public Artist(String name, String nationality) {
		this.name = name;
		this.nationality = nationality;
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

	public Set<Music> getInterpretedMusics() {
		return interpretedMusics;
	}

	public Set<Music> getMusicsAsAuthor() {
		return musicsAsAuthor;
	}

	public Set<Album> getAlbums() {
		return albums;
	}

	@PrePersist
	public void prePersist() {
		this.createdAt = Instant.now();
	}

	@PreUpdate
	public void preUpdate() {
		this.updatedAt = Instant.now();
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Artist artist = (Artist) o;
		return Objects.equals(id, artist.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

package com.gabriel.musicando.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.time.Instant;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "tb_album")
public class Album implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@ManyToMany
	@JoinTable(name = "tb_album_participants", joinColumns = @JoinColumn(name = "album_id"),
	  inverseJoinColumns = @JoinColumn(name = "artist_id"))
	private Set<Artist> participants = new HashSet<>();

	@ManyToMany
	@JoinTable(name = "tb_album_musics", joinColumns = @JoinColumn(name = "album_id"),
	  inverseJoinColumns = @JoinColumn(name = "music_id"))
	private Set<Music> musics = new HashSet<>();

	private String name;
	private Instant releaseDate;
	private Integer duration;

	public Album() {
	}

	public Album(String name, Instant releaseDate, Integer duration) {
		this.name = name;
		this.releaseDate = releaseDate;
		this.duration = duration;
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

	public Set<Artist> getParticipants() {
		return participants;
	}

	public Set<Music> getMusics() {
		return musics;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		Album album = (Album) o;
		return Objects.equals(id, album.id);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id);
	}
}

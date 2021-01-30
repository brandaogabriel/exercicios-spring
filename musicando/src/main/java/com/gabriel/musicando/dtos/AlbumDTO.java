package com.gabriel.musicando.dtos;

import com.gabriel.musicando.entities.Album;
import com.gabriel.musicando.entities.Artist;
import com.gabriel.musicando.entities.Music;

import java.io.Serializable;
import java.time.Instant;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class AlbumDTO implements Serializable {
	private static final long serialVersionUID = 1L;

	private Long id;
	private String name;
	private Instant releaseDate;
	private Integer duration;
	private List<ArtistDTO> artists = new ArrayList<>();
	private List<MusicDTO> musics = new ArrayList<>();

	public AlbumDTO() {
	}

	public AlbumDTO(Album entity) {
		this.id = entity.getId();
		this.name = entity.getName();
		this.releaseDate = entity.getReleaseDate();
		this.duration = entity.getDuration();
	}

	public AlbumDTO(Album entity, Set<Artist> artists, Set<Music> musics) {
		this(entity);
		artists.forEach(artist -> this.artists.add(new ArtistDTO(artist)));
		musics.forEach(music -> this.musics.add(new MusicDTO(music)));
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

	public List<ArtistDTO> getArtists() {
		return artists;
	}

	public List<MusicDTO> getMusics() {
		return musics;
	}
}

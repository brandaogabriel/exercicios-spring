package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.ArtistDTO;
import com.gabriel.musicando.entities.Artist;
import com.gabriel.musicando.repositories.ArtistRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository repository;

	public List<ArtistDTO> findAll() {
		List<Artist> artistList = this.repository.findAll();
		return artistList.stream().map(ArtistDTO::new).collect(Collectors.toList());
	}

	public ArtistDTO findById(Long id) {
		Optional<Artist> obj = this.repository.findById(id);
		return new ArtistDTO(obj.get());
	}
}

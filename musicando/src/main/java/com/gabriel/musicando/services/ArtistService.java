package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.ArtistDTO;
import com.gabriel.musicando.entities.Artist;
import com.gabriel.musicando.repositories.ArtistRepository;
import com.gabriel.musicando.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ArtistService {

	@Autowired
	private ArtistRepository repository;

	@Transactional(readOnly = true)
	public List<ArtistDTO> findAll() {
		List<Artist> artistList = this.repository.findAll();
		return artistList.stream().map(ArtistDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public ArtistDTO findById(Long id) {
		Optional<Artist> obj = this.repository.findById(id);
		Artist artist = obj.orElseThrow(() -> new ResourceNotFoundException("Artist not found"));
		return new ArtistDTO(artist);
	}
}

package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.AlbumDTO;
import com.gabriel.musicando.entities.Album;
import com.gabriel.musicando.repositories.AlbumRepository;
import com.gabriel.musicando.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class AlbumService {

	@Autowired
	private AlbumRepository repository;

	@Transactional(readOnly = true)
	public List<AlbumDTO> findAll() {
		List<Album> albumList = this.repository.findAll();
		return albumList.stream().map(AlbumDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public AlbumDTO findById(Long id) {
		Optional<Album> obj = this.repository.findById(id);
		Album album = obj.orElseThrow(() -> new ResourceNotFoundException("Album not found"));
		return new AlbumDTO(album);
	}
}

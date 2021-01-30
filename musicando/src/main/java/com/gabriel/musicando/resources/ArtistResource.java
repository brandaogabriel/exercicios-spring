package com.gabriel.musicando.resources;

import com.gabriel.musicando.dtos.ArtistDTO;
import com.gabriel.musicando.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/artists")
public class ArtistResource {

	@Autowired
	private ArtistService service;

	@GetMapping
	public ResponseEntity<List<ArtistDTO>> findAll() {
		List<ArtistDTO> artistDtoList = this.service.findAll();
		return ResponseEntity.ok().body(artistDtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<ArtistDTO> findById(@PathVariable Long id) {
		ArtistDTO artistDto = this.service.findById(id);
		return ResponseEntity.ok().body(artistDto);
	}
}

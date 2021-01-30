package com.gabriel.musicando.resources;

import com.gabriel.musicando.dtos.ArtistDTO;
import com.gabriel.musicando.services.ArtistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
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

	@PostMapping
	public ResponseEntity<ArtistDTO> insert(@RequestBody ArtistDTO artistDTO) {
		artistDTO = this.service.insert(artistDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(artistDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(artistDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<ArtistDTO> update(@PathVariable Long id, @RequestBody ArtistDTO artistDTO) {
		artistDTO = this.service.update(id, artistDTO);
		return ResponseEntity.ok().body(artistDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

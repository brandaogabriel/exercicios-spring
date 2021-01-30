package com.gabriel.musicando.resources;

import com.gabriel.musicando.dtos.MusicDTO;
import com.gabriel.musicando.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/musics")
public class MusicResource {

	@Autowired
	private MusicService service;

	@GetMapping
	public ResponseEntity<List<MusicDTO>> findAll() {
		List<MusicDTO> musicDtoList = this.service.findAll();
		return ResponseEntity.ok().body(musicDtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<MusicDTO> findById(@PathVariable Long id) {
		MusicDTO musicDto = this.service.findById(id);
		return ResponseEntity.ok().body(musicDto);
	}

	@PostMapping
	public ResponseEntity<MusicDTO> insert(@RequestBody MusicDTO musicDTO) {
		musicDTO = this.service.insert(musicDTO);
		URI uri = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
				.buildAndExpand(musicDTO.getId()).toUri();
		return ResponseEntity.created(uri).body(musicDTO);
	}

	@PutMapping(value = "/{id}")
	public ResponseEntity<MusicDTO> update(@PathVariable Long id, @RequestBody MusicDTO musicDTO) {
		musicDTO = this.service.update(id, musicDTO);
		return ResponseEntity.ok().body(musicDTO);
	}

	@DeleteMapping(value = "/{id}")
	public ResponseEntity<Void> delete(@PathVariable Long id) {
		this.service.delete(id);
		return ResponseEntity.noContent().build();
	}
}

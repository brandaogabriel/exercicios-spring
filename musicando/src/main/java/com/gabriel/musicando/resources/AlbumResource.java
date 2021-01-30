package com.gabriel.musicando.resources;

import com.gabriel.musicando.dtos.AlbumDTO;
import com.gabriel.musicando.services.AlbumService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/albums")
public class AlbumResource {

	@Autowired
	private AlbumService service;

	@GetMapping
	public ResponseEntity<List<AlbumDTO>> findAll() {
		List<AlbumDTO> albumDtoList = this.service.findAll();
		return ResponseEntity.ok().body(albumDtoList);
	}

	@GetMapping(value = "/{id}")
	public ResponseEntity<AlbumDTO> findById(@PathVariable Long id) {
		AlbumDTO albumDto = this.service.findById(id);
		return ResponseEntity.ok().body(albumDto);
	}
}

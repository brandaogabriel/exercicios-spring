package com.gabriel.musicando.resources;

import com.gabriel.musicando.dtos.MusicDTO;
import com.gabriel.musicando.services.MusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
}

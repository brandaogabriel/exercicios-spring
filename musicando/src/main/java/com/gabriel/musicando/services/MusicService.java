package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.MusicDTO;
import com.gabriel.musicando.entities.Music;
import com.gabriel.musicando.repositories.MusicRepository;
import com.gabriel.musicando.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicService {

	@Autowired
	private MusicRepository repository;

	@Transactional(readOnly = true)
	public List<MusicDTO> findAll() {
		List<Music> musicList = this.repository.findAll();
		return musicList.stream().map(MusicDTO::new).collect(Collectors.toList());
	}

	@Transactional(readOnly = true)
	public MusicDTO findById(Long id) {
		Optional<Music> obj = this.repository.findById(id);
		Music music = obj.orElseThrow(() -> new ResourceNotFoundException("Music not found"));
		return new MusicDTO(music, music.getAuthors(), music.getInterpreters());
	}
}

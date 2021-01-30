package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.MusicDTO;
import com.gabriel.musicando.entities.Music;
import com.gabriel.musicando.repositories.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicService {

	@Autowired
	private MusicRepository repository;

	public List<MusicDTO> findAll() {
		List<Music> musicList = this.repository.findAll();
		return musicList.stream().map(MusicDTO::new).collect(Collectors.toList());
	}

	public MusicDTO findById(Long id) {
		Optional<Music> obj = this.repository.findById(id);
		return new MusicDTO(obj.get());
	}
}

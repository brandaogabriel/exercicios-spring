package com.gabriel.musicando.services;

import com.gabriel.musicando.dtos.MusicDTO;
import com.gabriel.musicando.entities.Artist;
import com.gabriel.musicando.entities.Music;
import com.gabriel.musicando.repositories.ArtistRepository;
import com.gabriel.musicando.repositories.MusicRepository;
import com.gabriel.musicando.services.exceptions.DatabaseException;
import com.gabriel.musicando.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MusicService {

	@Autowired
	private MusicRepository repository;

	@Autowired
	private ArtistRepository artistRepository;

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

	@Transactional
	public MusicDTO insert(MusicDTO musicDTO) {
		Music music = new Music();
		copyDtoToEntity(music, musicDTO);
		music = this.repository.save(music);
		return new MusicDTO(music);
	}

	@Transactional
	public MusicDTO update(Long id, MusicDTO musicDTO) {
		try {
			Music music = this.repository.getOne(id);
			copyDtoToEntity(music, musicDTO);
			return new MusicDTO(music);
		} catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		}
	}

	private void copyDtoToEntity(Music music, MusicDTO musicDTO) {
		music.setName(musicDTO.getName());
		music.setReleaseDate(musicDTO.getReleaseDate());
		music.setDuration(musicDTO.getDuration());

		music.getAuthors().clear();
		musicDTO.getAuthors().forEach(artistDTO -> {
			Artist artist = this.artistRepository.getOne(artistDTO.getId());
			music.getAuthors().add(artist);
		});

		music.getInterpreters().clear();
		musicDTO.getInterpreters().forEach(artistDTO -> {
			Artist artist = this.artistRepository.getOne(artistDTO.getId());
			music.getInterpreters().add(artist);
		});
	}

	public void delete(Long id) {
		try {
			this.repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ResourceNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integry violation");
		}
	}
}

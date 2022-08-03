package com.arka.spotify.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arka.spotify.model.Song;
import com.arka.spotify.service.songService;
import com.arka.spotify.repository.*;

@Service

public class songServiceImpl implements songService {
	
	@Autowired
	private songRepository songRepository;

	
	@Override
	public List<Song> getAll() {
		return this.songRepository.findAll();
	}

	
	@Override
	public Song add(Song song) {
		return this.songRepository.save(song);
	}


	@Override
	public Song update(Song song) throws Exception {
		Optional<Song> optSong = this.songRepository.findById(song.getSongId());
		if(!optSong.isPresent())
		{
			throw new Exception();
		}
		else
		{	
		Song repSong = optSong.get();
        repSong.setSongId(song.getSongId());
        repSong.setSongName(song.getSongName());
        repSong.setGenre(song.getGenre());
        repSong.setPlaylistId(song.getPlaylistId());
        repSong.setSongDuration(song.getSongDuration());
        repSong.setArtistName(song.getArtistName());

		return this.songRepository.save(repSong);
		}
	}

	
	@Override
	public Song delete(long id) {
		this.songRepository.deleteById(id);
		return songRepository.getById(id);
	}

	
	@Override
	public Optional<Song> getSongById(long id) {
		return this.songRepository.findById(id);
	}

}
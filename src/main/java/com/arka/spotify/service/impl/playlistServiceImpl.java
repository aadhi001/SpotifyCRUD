package com.arka.spotify.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;

import com.arka.spotify.model.Playlist;
import com.arka.spotify.service.PlaylistService;
import com.arka.spotify.repository.*;

@Service

public class playlistServiceImpl implements PlaylistService {
	
	@Autowired
	private playlistRepository playlistRepository;

	
	@Override
	public List<Playlist> getAll() {
		return this.playlistRepository.findAll();
	}

	
	@Override
	public Playlist add(Playlist song) {
		return this.playlistRepository.save(song);
	}


	@Override
	public Playlist update(Playlist playlist) throws Exception {
		Playlist repPlaylist = new Playlist();
		try {
        repPlaylist.setPlaylistName(playlist.getPlaylistName());
        repPlaylist.setDescription(playlist.getDescription());
        return this.playlistRepository.save(repPlaylist);
		}
		catch(Exception e)
		{
		  throw new Exception(e);	
		}
}

	
	@Override
	public Playlist delete(long id) {
		this.playlistRepository.deleteById(id);
		return playlistRepository.getById(id);
	}

	
	@Override
	public Optional<Playlist> getPlaylistById(long id) {
		return this.playlistRepository.findById(id);
	}

}
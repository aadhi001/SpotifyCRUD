package com.arka.spotify.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Component;

import com.arka.spotify.model.Playlist;

@Component
public interface PlaylistService {

	public List<Playlist> getAll();

	public Playlist add(Playlist playlist);

	public Playlist update(Playlist playlist) throws Exception;

	public Playlist delete(long id);

	public Optional<Playlist> getPlaylistById(long id);

	}

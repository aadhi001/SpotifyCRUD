package com.arka.spotify.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arka.spotify.model.Playlist;
import com.arka.spotify.model.Song;
import com.arka.spotify.repository.PlaylistRepository;
import com.arka.spotify.service.PlaylistService;
import com.arka.spotify.service.SongService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class PlaylistController {
	@Autowired
	PlaylistService playlistService;
	
	@Autowired
	SongService songService;
	
	@Autowired
	PlaylistRepository playlistRepository;

	//Creating a new playlist
	@PostMapping("/playlist")
	public ResponseEntity<Playlist> createPlaylist(@RequestBody Playlist playlist) {
			Playlist plObj = new Playlist(playlist.getPlaylistName(),playlist.getDescription());
			try {
				if(playlistService.isDuplicate(playlist.getPlaylistName()))
				{return new ResponseEntity<>(HttpStatus.CONFLICT);}
			    Playlist _playlist = this.playlistService.update(plObj);
			    return new ResponseEntity<>(_playlist, HttpStatus.CREATED);
			}
			catch(Exception e)
			{
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} 
	
	//Adding a song to the playlist
	@PutMapping("/playlist/{playlistId}")
	public ResponseEntity<Song> addToPlaylist(@PathVariable("playlistId") long playlistId, @RequestBody Song song)
	{
		Optional<Song> songData = songService.getSongById(song.getSongId());
		Song songObj = songData.get();
		songObj.setPlaylist(playlistRepository.findById(playlistId).get());
	    try {
			songService.update(songObj);			
			return new ResponseEntity<>(songObj, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
		}		
	}
	
	}






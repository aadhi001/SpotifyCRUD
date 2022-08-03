package com.arka.spotify.controller;

import java.util.List;

import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arka.spotify.model.Song;
import com.arka.spotify.service.songService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SongController {

	
	@Autowired
	songService songService;

	//Creating a new song
	@PostMapping("/song")
	public ResponseEntity<Song> createSong(@RequestBody Song song) {
			Song songObj = new Song(song.getSongName(),song.getArtistName(), song.getSongDuration(), song.getGenre());
			try {
			    this.songService.update(song);
			    return new ResponseEntity<>(songObj, HttpStatus.CREATED);
			}
			catch(Exception e)
			{
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} 
	}






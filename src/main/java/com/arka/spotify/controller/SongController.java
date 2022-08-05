package com.arka.spotify.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.arka.spotify.model.Song;
import com.arka.spotify.service.SongService;


@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/api")
public class SongController {

	
	@Autowired
	SongService songService;

	//Creating a new song
	@PostMapping("/song")
	public ResponseEntity<Song> createSong(@RequestBody Song song) {
		try {
		    if(songService.isDuplicate(song.getSongName()))
		    {
		    	return new ResponseEntity<>(HttpStatus.CONFLICT);
		    }
			    Song _song = this.songService.update(song);
			    return new ResponseEntity<>(_song, HttpStatus.CREATED);
			}
			catch(Exception e)
			{
            	return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
			}
		} 
	 
	}






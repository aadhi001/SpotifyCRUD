package com.arka.spotify.model;
import java.util.List;

import javax.persistence.*;

/*
 We need to store the below customer details in our persistence storage. We should be
able to update and retrieve the below informations:
firstName.
lastName.
emailId.
mobileNo.
city.
address.
 */

@Entity //To specify that class is mapped to a table in the database
@Table(name = "playlists") //To make sure that the class is pointing to the right table
public class Playlist {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long playlistId;

	@Column(name = "playlistName")
	private String playlistName;
    
	@Column(name = "description")
	private String description;
	
	@Column(name = "songs")
	@ElementCollection(targetClass=Long.class)
	private List<Long> songs;
	

	public Playlist() {

	}

	//Constructor
	public Playlist(String playlistName, String description) 
	{
       this.playlistName=playlistName;
       this.description=description;
	}
	
	public long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(long playlistId) {
		this.playlistId = playlistId;
	}

	public String getPlaylistName() {
		return playlistName;
	}

	public void setPlaylistName(String playlistName) {
		this.playlistName = playlistName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Long> getSongs() {
		return songs;
	}

	public void setSongs(List<Long> songs) {
		this.songs = songs;
	}


	@Override
	public String toString() {
		return "Playlist [id=" + playlistId + ", playlistName=" + playlistName + ", description=" + description+"]";
	}
}



package com.arka.spotify.model;
import javax.persistence.*;


@Entity //To specify that class is mapped to a table in the database
@Table(name = "songs") //To make sure that the class is pointing to the right table
public class Song {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long songId;

	@Column(name = "songName")
	private String songName;
    
	@Column(name = "artistName")
	private String artistName;
	
	@Column(name = "songDuration")
	private long songDuration;
	
	@Column(name =  "genre")
    private String genre;
	
	@Column(name = "playlistId")
	private long playlistId;
	
	
	public Song() {

	}

	//Constructor
	public Song(String songName, String artistName, long songDuration, String genre) 
	{
       this.songName=songName;
       this.artistName=artistName;
       this.songDuration=songDuration;
       this.genre = genre;
	}
	
	public long getSongId() {
		return songId;
	}

	public void setSongId(long songId) {
		this.songId = songId;
	}

	public String getSongName() {
		return songName;
	}

	public void setSongName(String songName) {
		this.songName = songName;
	}

	public String getArtistName() {
		return artistName;
	}

	public void setArtistName(String artistName) {
		this.artistName = artistName;
	}

	public long getSongDuration() {
		return songDuration;
	}

	public void setSongDuration(long songDuration) {
		this.songDuration = songDuration;
	}

	public String getGenre() {
		return genre;
	}

	public void setGenre(String genre) {
		this.genre = genre;
	}

	public long getPlaylistId() {
		return playlistId;
	}

	public void setPlaylistId(long playlistId) {
		this.playlistId = playlistId;
	}


	@Override
	public String toString() {
		return "Song [id=" + songId + ", songName=" + songName + ", artistName=" + artistName + ",songDuration="+ songDuration +",city="+genre+",playlistId="+ playlistId+"]";
	}
}


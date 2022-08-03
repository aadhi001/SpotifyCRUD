package com.arka.spotify.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.arka.spotify.model.Playlist;

@Repository
public interface playlistRepository extends JpaRepository<Playlist, Long> {
	
}